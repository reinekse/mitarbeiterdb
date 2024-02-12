package mitarbeiterdb.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mitarbeiterdb.implementation.model.Connector;

public class ConnectorTest {
	private Connector db;

	@BeforeEach
	public void setup() throws SQLException {
		db = Connector.getInstance("jdbc:mysql://localhost/mitarbeiter_test?");
		db.setupDB();
	}

	@Test
	public void setupDB_createsTablesPersonenAndStandorte() throws SQLException {
		var actual = db.sendSQLQuery("SHOW TABLES;").toString();
		var expected = "[[Tables_in_mitarbeiter_test], [personen], [standorte]]";
		assertEquals(expected, actual);

	}

	@Test
	public void setupDB_fillsTablePersonenAndTableStandorteWithData() throws SQLException {
		var nRowsPersonen = db.getNumberOfRows("personen");
		var nRowsStandorte = db.getNumberOfRows("standorte");
		assertTrue(nRowsPersonen > 0 && nRowsStandorte > 0);

	}

	@Test
	public void setupDB_connectsTablesPersonenAndStandorteViaId() throws SQLException {
		var actual = db.sendSQLQuery(
				"SELECT vorname, strasse FROM personen JOIN standorte ON standort_id = standorte.id WHERE standort_id > 1;")
				.toString();
		var expected = "[[vorname, strasse], [Petra, Elisabethweg], [Nikita, Elisabethweg], [Michelle, Elisabethweg], [Sarah, Elisabethweg], [Martin, Im Weißmoor]]";
		assertEquals(expected, actual);

	}

}
