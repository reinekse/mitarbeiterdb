package mitarbeiterdb.contract;

import java.sql.SQLException;
import java.util.List;

public interface IConnector {
	void setupDB() throws SQLException;

	void sendSQLExpression(String sql) throws SQLException;

	List<List<?>> sendSQLQuery(String sql) throws SQLException;

	List<String> getTableHeaders(String table) throws SQLException;

}
