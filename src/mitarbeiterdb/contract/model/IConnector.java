package mitarbeiterdb.contract.model;

import java.sql.SQLException;
import java.util.List;

public interface IConnector {
	void setupDB() throws SQLException;

	List<List<String>> sendSQLQuery(String sql) throws SQLException;

}
