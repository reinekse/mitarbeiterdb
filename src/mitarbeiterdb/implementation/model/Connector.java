package mitarbeiterdb.implementation.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mitarbeiterdb.contract.model.IConnector;
import mitarbeiterdb.implementation.controller.TableType;

public class Connector implements IConnector {
	private static final Logger logger = LogManager.getLogger(Connector.class);

	final String user = "java_app";
	final String password = "password";
	private static Connector instance;
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	private Connector(String url) { // private? Singleton, should exist only once!
		try {
			logger.info("\nAufbau der Datenbankverbindung.\n");
			this.connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			logger.info("\n Aufbau der Datenbankverbindung fehlgeschlagen.\n");
		}
	}

	public static Connector getInstance() {
		if (instance == null) {
			instance = new Connector("jdbc:mysql://localhost/mitarbeiter?");
		}
		return instance;
	}

	// to set up connection to other databases, e.g. test database for unit tests
	public static Connector getInstance(String url) {
		if (instance == null) {
			instance = new Connector(url);
		}
		return instance;
	}

	@Override
	public void setupDB() {
		try {
			logger.info("\nErstellen der Datenbanktabellen.\n");
			var existingTables = sendSQLQuery("SHOW TABLES");
			if (existingTables.size() > 1) { // more entries than just heading
				logger.warn("\nTabellen existieren bereits und werden überschrieben.\n");
			}
			var sqlBuilder = new SQLBuilder();
			statement = connection.createStatement();

			// drop existing tables
			// (drop 'personen' first, because 'standort_id' is foreign key!)
			statement.execute(sqlBuilder.dropTable(TableType.PERSONEN));
			statement.execute(sqlBuilder.dropTable(TableType.STANDORTE));

			// create new tables
			// (create 'standorte' first, because 'standort_id' is foreign key!)
			statement.execute(sqlBuilder.createTableStandorte());
			statement.execute(sqlBuilder.createTablePersonen());

			// fill tables with data
			statement.execute(sqlBuilder.fillTableStandorte());
			statement.execute(sqlBuilder.fillTablePersonen());

		} catch (Exception e) {
			logger.error("\nErstellen der Datenbanktabellen fehlgeschlagen.\n", e);
		} finally {
			close();
		}

	}

	@Override
	public List<List<String>> sendSQLQuery(String sql) {
		try {
			logger.debug("\n" + sql + "\n");
			statement = connection.createStatement();
			var result = statement.execute(sql);
			if (result) { // e.g. SELECT statements
				return convertToList(statement.getResultSet());
			} else { // e.g. INSERT or UPDATE statements
				return null;
			}
		} catch (Exception e) {
			logger.error("\nSQL-Anfrage fehlgeschlagen.\n", e);
		} finally {
			close();
		}
		return null;

	}

	public int getNumberOfRows(TableType table) { // only used for unit tests
		var result = sendSQLQuery("SELECT COUNT(*) FROM " + table.toString());
		return Integer.parseInt(result.get(1).get(0).toString());

	}

	private List<List<String>> convertToList(ResultSet resultSet) throws SQLException {
		var resultList = new ArrayList<List<String>>();
		var metadata = resultSet.getMetaData();
		var columnCount = metadata.getColumnCount();

		// add column names/ heading
		var columnNames = new ArrayList<String>();
		for (int i = 1; i <= columnCount; i++) {
			columnNames.add(metadata.getColumnName(i));
		}
		resultList.add(columnNames);

		// add data records
		while (resultSet.next()) {
			var dataSet = new ArrayList<String>();
			for (int i = 1; i <= columnCount; i++) {
				dataSet.add(resultSet.getString(i));
			}
			resultList.add(dataSet);
		}

		// resultList.forEach(System.out::println);
		return resultList;

	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			// connection is not closed: too much effort to create new connection for every
			// query
		} catch (Exception e) {
		}
	}

}
