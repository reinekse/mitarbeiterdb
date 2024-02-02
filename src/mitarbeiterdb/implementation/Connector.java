package mitarbeiterdb.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void sendSQLExpression(String sql) throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, password);
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
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			return null; // TODO resultSet to List
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	@Override
	public List<String> getTableHeaders(String table) throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select column_name from mitarbeiter;");
			return null; // TODO resultSet to List
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
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
