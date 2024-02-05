package mitarbeiterdb.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mitarbeiterdb.implementation.model.SQLBuilder;

public class SQLBuilderTest {
	private SQLBuilder sqlBuilder;

	@BeforeEach
	public void setup() {
		sqlBuilder = new SQLBuilder();
	}

	@Test
	public void insert_validInput_returnSQLStatement() {
		var actual = sqlBuilder.insert("table", "col1, col2, col3", "val1, val2, val3");
		var expected = "INSERT INTO table (col1, col2, col3) VALUES (val1, val2, val3);";
		assertEquals(expected, actual);

	}

	@Test
	public void update_validInput_returnSQLStatement() {
		var actual = sqlBuilder.update("table", "col1,col2,col3", "val1,val2,val3", "col4 = 'foo'");
		var expected = "UPDATE table SET col1 = val1, col2 = val2, col3 = val3 WHERE col4 = 'foo';";
		assertEquals(expected, actual);

	}

	@Test
	public void deleteRows_validInput_returnSQLStatement() {
		var actual = sqlBuilder.deleteRows("table", "col1 = 'foo'");
		var expected = "DELETE FROM table WHERE col1 = 'foo';";
		assertEquals(expected, actual);

	}

	@Test
	public void dropTable_validInput_returnSQLStatement() {
		var actual = sqlBuilder.dropTable("table");
		var expected = "DROP TABLE IF EXISTS table;";
		assertEquals(expected, actual);

	}

}
