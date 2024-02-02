package mitarbeiterdb.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mitarbeiterdb.contract.IConnector;

public class Connector implements IConnector {
	final String url = "jdbc:mysql://localhost/mitarbeiter?";
	final String user = "java_app";
	final String password = "password";
	private static Connector instance;
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public static Connector getInstance() {
		if (instance == null) {
			instance = new Connector();
		}
		return instance;
	}

	@Override
	public void setupDB() throws SQLException {
		try {
			var sqlBuilder = new SQLBuilder();
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			// drop existing tables
			// (drop 'personen' first, because 'standort_id' is foreign key!)
			statement.execute(sqlBuilder.dropTable("personen"));
			statement.execute(sqlBuilder.dropTable("standorte"));

			// create new tables
			// (create 'standorte' first, because 'standort_id' is foreign key!)
			statement.execute(sqlBuilder.createTableStandorte());
			statement.execute(sqlBuilder.createTablePersonen());

			// fill tables with data
			statement.execute(sqlBuilder.fillTableStandorte());
			statement.execute(sqlBuilder.fillTablePersonen());

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	@Override
	public void sendSQLExpression(String sql) throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("\n\n" + sql + "\n");
			statement = connection.createStatement();
			statement.execute(sql);

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	@Override
	public List<List<?>> sendSQLQuery(String sql) throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("\n\n" + sql + "\n");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			return convertToList(resultSet);

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	private List<List<?>> convertToList(ResultSet resultSet) throws SQLException {
		var resultList = new ArrayList<List<?>>();
		var metadata = resultSet.getMetaData();
		var columnCount = metadata.getColumnCount();

		// add column names
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

		resultList.forEach(System.out::println);
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
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
		}
	}

}
