package mitarbeiterdb.implementation;

public class SQLBuilder {
	public String selectAll(String table) {
		return "SELECT * FROM " + table + ";";

	}

	public String dropTable(String table) {
		return "DROP TABLE IF EXISTS " + table + ";";
	}

	// TODO autogenerate IDs
	public String createTablePersonen() {
		return "CREATE TABLE personen(" + "id INT NOT NULL, " + "name VARCHAR(50), " + "vorname VARCHAR(50), "
				+ "geburtstag DATE, " + "abteilung VARCHAR(50), " + "standort INT, " + "anstellungstag DATE, "
				+ "PRIMARY KEY(id));";
	}

	public String fillTablePersonen() {
		return "INSERT INTO personen VALUES" + "(1, 'Mönkeberg', 'Petra', '1967-03-17', 'E1', 1, '2019-02-01'), "
				+ "(2, 'Hildebrandt', 'Louis', '1997-04-12', 'E1', 1, '2020-04-01'), "
				+ "(3, 'Kowalski', 'Benedikt', '1972-01-13', 'E2', 1, '2010-05-01'), "
				+ "(4, 'Mahd-Lehmann', 'Claudia', '1969-03-18', 'E2', 1, '2012-03-01'), "
				+ "(5, 'Saleh', 'Muhammad', '1987-03-01', 'E2', 1, '2021-03-01'), "
				+ "(6, 'Petersen', 'Petra', '1971-12-07', 'A1', 2, '2005-08-01'), "
				+ "(7, 'Kulik', 'Nikita', '1992-05-01', 'A2', 2, '2019-02-01'), "
				+ "(8, 'Hermann', 'Michelle', '1989-08-05', 'A4', 2, '2015-07-01'), "
				+ "(9, 'Nguyen', 'Sarah', '2001-10-17', 'A1', 2, '2020-08-01'), "
				+ "(10, 'Pilatzki', 'Tomasz', '1974-03-31', 'E2', 1, '2017-11-01'), "
				+ "(11, 'Michaelis', 'Ronald', '1972-07-12', 'E1', 1, '2009-02-01'), "
				+ "(12, 'Leew', 'Mareike', '1987-04-22', 'A1', 1, '2015-08-01'), "
				+ "(13, 'Schnieders', 'Martin', '1981-09-11', 'C1', 3, '2023-05-01'), "
				+ "(14, 'Meyer-Friedrichsen', 'Julian', '1990-06-18', 'A2', 1, '2022-10-01')" + ";";
	}

	public String createTableStandorte() {
		return "CREATE TABLE standorte (" + "id INT NOT NULL," + "strasse VARCHAR(50)," + "hausnummer VARCHAR(6),"
				+ "plz VARCHAR(6)," + "ort VARCHAR(50)" + ");";
	}

	public String fillTableStandorte() {
		return "INSERT INTO standorte VALUES" + "(1, 'Lindenallee', '17-19', '24288', 'Duppelbach'),"
				+ "(2, 'Elisabethweg', '8', '24288', 'Duppelbach'),"
				+ "(3, 'Im Weißmoor', '27a', '24117', 'Ludwigsfehn')" + ";";
	}

}
