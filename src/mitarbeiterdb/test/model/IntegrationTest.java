package mitarbeiterdb.test.model;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.model.SQLBuilder;

public class IntegrationTest {
	private Connector db;
	private SQLBuilder sql;

	@BeforeEach
	public void setup() throws SQLException {
		db = Connector.getInstance("jdbc:mysql://localhost/mitarbeiter_test?");
		db.setupDB();
		sql = new SQLBuilder();
	}

	@Test
	public void selectSingleColumn() throws SQLException {
		var actual = db.sendSQLQuery(sql.select("standorte", "plz")).toString();
		var expected = db.sendSQLQuery("SELECT plz FROM standorte;").toString();
		// var expected = "[[plz], [24288], [24288], [24117]]";
		assertEquals(expected, actual);
	}

	@Test
	public void selectMultipleColumnsByCondition() throws SQLException {
		var actual = db.sendSQLQuery(sql.select("personen", "name, vorname", "id < 3")).toString();
		var expected = db.sendSQLQuery("SELECT name, vorname FROM personen WHERE id < 3;").toString();
		// var expected = "[[name, vorname], [Mönkeberg, Petra], [Hildebrandt, Louis]]";
		assertEquals(expected, actual);
	}

	@Test
	public void updateColumnsByCondition() throws SQLException {
		db.sendSQLExpression(sql.updateByCondition("personen", "name, vorname", "'Müller', 'Fenja'", "id = 4"));
		var actual = db.sendSQLQuery(sql.select("personen", "name, vorname", "id = 4")).toString();
		var expected = "[[name, vorname], [Müller, Fenja]]";
		assertEquals(expected, actual);
	}

	@Test
	public void insert_increasesRowCount() throws SQLException {
		var initialNumberOfRows = db.getNumberOfRows("standorte");
		db.sendSQLExpression(sql.insertInColumns("standorte", "strasse, hausnummer", "'Bienenweg', '15'"));
		var actual = db.getNumberOfRows("standorte");
		var expected = initialNumberOfRows + 1;
		assertEquals(expected, actual);
	}

	@Test
	public void deleteRows_decreasesRowCount() throws SQLException {
		var initialNumberOfRows = db.getNumberOfRows("personen");
		db.sendSQLExpression(sql.deleteRows("personen", "id = 2"));
		var actual = db.getNumberOfRows("personen");
		var expected = initialNumberOfRows - 1;
		assertEquals(expected, actual);
	}

}
