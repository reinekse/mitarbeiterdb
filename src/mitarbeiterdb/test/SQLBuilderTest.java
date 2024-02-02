package mitarbeiterdb.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mitarbeiterdb.implementation.SQLBuilder;

public class SQLBuilderTest {
	private SQLBuilder sqlBuilder;

	@BeforeEach
	public void setup() {
		sqlBuilder = new SQLBuilder();
	}

	@Test
	public void dropTable_validInput_returnSQLStatement() {
		var actual = sqlBuilder.dropTable("test");
		var expected = "DROP TABLE IF EXISTS test;";
		assertEquals(expected, actual);

	}

}
