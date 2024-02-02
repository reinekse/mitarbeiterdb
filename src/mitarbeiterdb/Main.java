package mitarbeiterdb;

import mitarbeiterdb.implementation.Connector;
import mitarbeiterdb.implementation.SQLBuilder;

public class Main {

	public static void main(String[] args) {

		// Test Database connection
		var dbTest = TestConnection.getInstance();
		try {
			dbTest.readDataBase();
		} catch (Exception e) {
			e.printStackTrace();
		}

		var db = Connector.getInstance();
		var sql = new SQLBuilder();
		try {
			db.setupDB();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			db.sendSQLQuery("SELECT * FROM personen;");
			db.sendSQLQuery("SELECT * FROM standorte;");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
