package mitarbeiterdb.implementation.model;

public class SQLBuilder {
	private String personenColumns = "name, vorname, geburtstag, abteilung, standort_id, anstellungstag";
	private String standorteColumns = "strasse, hausnummer, plz, ort";

	// --------------------------------
	// Actually needed for GUI:
	// --------------------------------
	public String selectAll(String table) {
		var sql = "SELECT * FROM " + table + ";";
		return sql;
	}

	public String delete(String table, String ID) {
		var sql = "DELETE FROM " + table + " WHERE id = " + ID + ";";
		return sql;
	}

	public String search(String table, String searchValue) {
		var sql = "SELECT * FROM " + table;
		if (table == "personen") {
			sql += "  WHERE CONCAT_WS(' ', id, " + personenColumns + ") LIKE '%" + searchValue + "%'";
		}
		if (table == "standorte") {
			sql += " WHERE CONCAT_WS(' ', id, " + standorteColumns + ") LIKE '%" + searchValue + "%'";
		}
		return sql + ";";
	}

	public String advancedSearch(String table, String searchValues) {
		var sql = "SELECT * FROM " + table;
		String[] colArr = {};
		if (table == "standorte") {
			colArr = standorteColumns.split(",");
		}
		if (table == "personen") {
			colArr = personenColumns.split(",");
		}

		var valArr = searchValues.split(",");
		var searchCondition = " WHERE ";
		for (int i = 0; i < colArr.length; i++) {
			if (!valArr[i].equals("null")) {
				searchCondition += colArr[i];
				searchCondition += " LIKE '%";
				searchCondition += valArr[i].replace("'", "");
				searchCondition += "%'";
				searchCondition += " AND ";

			}
			if (i == colArr.length - 1) {
				searchCondition += true;
			}
		}

		sql += searchCondition + ";";
		System.out.println(sql);
		return sql;
	}

	public String update(String table, String values, String ID) {
		String[] colArr = {};
		if (table == "standorte") {
			colArr = standorteColumns.split(",");
		}
		if (table == "personen") {
			colArr = personenColumns.split(",");
		}

		var valArr = values.split(",");
		var setStatement = "";
		for (int i = 0; i < colArr.length; i++) {
			setStatement += colArr[i];
			setStatement += " = ";
			setStatement += valArr[i];
			if (i < colArr.length - 1) {
				setStatement += ", ";
			}
		}

		var sql = "UPDATE " + table + " SET " + setStatement + " WHERE id = " + ID + ";";
		return sql;

	}

	public String insert(String table, String values) {
		String columns = "";
		if (table == "standorte") {
			columns = standorteColumns;
		}
		if (table == "personen") {
			columns = personenColumns;
		}
		var sql = "INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ");";
		return sql;
	}

	// ----------------------------
	// Setup
	// ---------------------------

	public String dropTable(String table) {
		var sql = "DROP TABLE IF EXISTS " + table + ";";
		return sql;
	}

	public String createTablePersonen() {
		var sql = "CREATE TABLE personen(" + "id INT NOT NULL AUTO_INCREMENT, " + "name VARCHAR(50), "
				+ "vorname VARCHAR(50), " + "geburtstag DATE, " + "abteilung VARCHAR(50), " + "standort_id INT, "
				+ "anstellungstag DATE, " + "PRIMARY KEY(id), " + "FOREIGN KEY (standort_id) REFERENCES standorte(id)"
				+ ");";
		return sql;
	}

	public String fillTablePersonen() {
		var sql = "INSERT INTO personen (" + personenColumns + ") VALUES"
				+ "('Mönkeberg', 'Petra', '1967-03-17', 'E1', 1, '2019-02-01'), "
				+ "('Hildebrandt', 'Louis', '1997-04-12', 'E1', 1, '2020-04-01'), "
				+ "('Kowalski', 'Benedikt', '1972-01-13', 'E2', 1, '2010-05-01'), "
				+ "('Mahd-Lehmann', 'Claudia', '1969-03-18', 'E2', 1, '2012-03-01'), "
				+ "('Saleh', 'Muhammad', '1987-03-01', 'E2', 1, '2021-03-01'), "
				+ "('Petersen', 'Petra', '1971-12-07', 'A1', 2, '2005-08-01'), "
				+ "('Kulik', 'Nikita', '1992-05-01', 'A2', 2, '2019-02-01'), "
				+ "('Hermann', 'Michelle', '1989-08-05', 'A4', 2, '2015-07-01'), "
				+ "('Nguyen', 'Sarah', '2001-10-17', 'A1', 2, '2020-08-01'), "
				+ "('Pilatzki', 'Tomasz', '1974-03-31', 'E2', 1, '2017-11-01'), "
				+ "('Michaelis', 'Ronald', '1972-07-12', 'E1', 1, '2009-02-01'), "
				+ "('Leew', 'Mareike', '1987-04-22', 'A1', 1, '2015-08-01'), "
				+ "('Schnieders', 'Martin', '1981-09-11', 'C1', 3, '2023-05-01'), "
				+ "('Meyer-Friedrichsen', 'Julian', '1990-06-18', 'A2', 1, '2022-10-01')" + ";";
		System.out.println(sql);
		return sql;
	}

	public String createTableStandorte() {
		return "CREATE TABLE standorte (" + "id INT NOT NULL AUTO_INCREMENT," + "strasse VARCHAR(50),"
				+ "hausnummer VARCHAR(6)," + "plz VARCHAR(6)," + "ort VARCHAR(50)," + "PRIMARY KEY(id)" + ");";
	}

	public String fillTableStandorte() {
		return "INSERT INTO standorte VALUES" + "(1, 'Lindenallee', '17-19', '24288', 'Duppelbach'),"
				+ "(2, 'Elisabethweg', '8', '24288', 'Duppelbach'),"
				+ "(3, 'Im Weißmoor', '27a', '24117', 'Ludwigsfehn')" + ";";
	}

	// -------------------------
	// Not needed for GUI:
	// -------------------------
	public String select(String table, String columns) {
		var sql = "SELECT " + columns + " FROM " + table + ";";
		return sql;
	}

	public String select(String table, String columns, String condition) {
		var sql = "SELECT " + columns + " FROM " + table + " WHERE " + condition + ";";
		return sql;
	}

	public String updateByCondition(String table, String columns, String values, String condition) {
		var colArr = columns.split(",");
		var valArr = values.split(",");
		var setStatement = "";
		for (int i = 0; i < colArr.length; i++) {
			setStatement += colArr[i];
			setStatement += " = ";
			setStatement += valArr[i];
			if (i < colArr.length - 1) {
				setStatement += ", ";
			}
		}

		var sql = "UPDATE " + table + " SET " + setStatement + " WHERE " + condition + ";";
		return sql;

	}

	public String insertInColumns(String table, String columns, String values) {
		var sql = "INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ");";
		return sql;
	}

	public String deleteRows(String table) {
		var sql = "DELETE FROM " + table + ";";
		return sql;
	}

	public String deleteRows(String table, String condition) {
		var sql = "DELETE FROM " + table + " WHERE " + condition + ";";
		return sql;
	}

}
