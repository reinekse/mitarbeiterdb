package mitarbeiterdb;

import java.sql.SQLException;

import mitarbeiterdb.implementation.Connector;
import mitarbeiterdb.implementation.SQLBuilder;

public class Main {

	public static void main(String[] args) throws SQLException {

		var db = Connector.getInstance();
		var sql = new SQLBuilder();

		try {
			db.setupDB();
			db.sendSQLQuery("SELECT * FROM personen ORDER BY geburtstag;");
			db.sendSQLQuery("SELECT abteilung, COUNT(abteilung) FROM personen GROUP BY abteilung;");
			db.sendSQLQuery("SELECT vorname, strasse FROM personen JOIN standorte ON standort_id = standorte.id;");
			db.sendSQLQuery(sql.select("personen", "name"));
			db.sendSQLQuery(sql.select("standorte", "strasse, plz"));
			db.sendSQLQuery(sql.select("standorte", "strasse, plz"));
			db.sendSQLExpression(sql.insert("standorte", "strasse, hausnummer", "'Bienenweg', '15'"));
			db.sendSQLQuery(sql.select("standorte"));
			db.sendSQLExpression(sql.deleteRows("personen", "standort_id = 2"));
			db.sendSQLExpression(sql.update("personen", "name, vorname", "'Müller', 'Fenja'", "id = 4"));
			db.sendSQLExpression(sql.update("personen", "vorname", "'Andreas'", "id > 5"));
			db.sendSQLQuery(sql.select("personen"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
