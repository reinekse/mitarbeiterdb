package mitarbeiterdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	/**
	 * Die URL der Datenbank.
	 */
	static final String URL = "jdbc:mysql://localhost/mitarbeiter?";

	/**
	 * Nutzerdaten zum Anmelden auf der Datenbank
	 */
	static final String USER = "user=java_app&password=password";

	/**
	 * Instanz der Connection. Siehe Singelton Entwurfsmuster
	 */
	private static TestConnection instance;

	/**
	 * Methode um die Instanz der DatabaseConnection zu erhalten (Singleton)
	 * 
	 * @return das MySQLConnection-Objekt.
	 */
	public static TestConnection getInstance() {
		if (instance == null) {
			instance = new TestConnection();
		}
		return instance;
	}

	private TestConnection() {
	}

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public void readDataBase() throws Exception {
		try {
			// Einrichten der Datenbankverbindung
			connection = DriverManager.getConnection(URL + USER);
			// Erlaubt das Ausfuehren von SQL-Befehlen
			statement = connection.createStatement();
			// Enthaelt das Ergebnis einer SQL-Abfrage
			resultSet = statement.executeQuery("select * from personendaten");
			writeResultSet(resultSet);
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			String name = resultSet.getString("name");
			String vorname = resultSet.getString("vorname");
			String abteilung = resultSet.getString("abteilung");
			System.out.println("Name: " + name);
			System.out.println("Vorname: " + vorname);
			System.out.println("Abteilung: " + abteilung);
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
