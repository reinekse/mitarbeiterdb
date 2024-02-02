package mitarbeiterdb.implementation;

public class SQLBuilder {
	public String selectAll(String table) {
		return "select * from " + table + ";";

	}

	public String setupDB() {
		var dropAll = "";
		var createTablePersonen = "CREATE TABLE personen( " + "PID int NOT NULL, " + "Name varchar(50), "
				+ "Vorname varchar(50), " + "Abteilung varchar(50), " + "Standort int, " + "PRIMARY KEY(PID));";
		return dropAll + createTablePersonen;
	}

}
