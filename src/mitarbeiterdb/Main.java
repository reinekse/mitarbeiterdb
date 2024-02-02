package mitarbeiterdb;

import mitarbeiterdb.implementation.Connector;
import mitarbeiterdb.implementation.SQLBuilder;

public class Main {

	public static void main(String[] args) {

		var db = Connector.getInstance();
		var sql = new SQLBuilder();

		try {
			// db.setupDB();
			db.sendSQLQuery("SELECT * FROM personen;");
			db.sendSQLQuery(sql.select("ort", "standorte"));
			db.sendSQLQuery(sql.select("strasse, plz", "standorte"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
