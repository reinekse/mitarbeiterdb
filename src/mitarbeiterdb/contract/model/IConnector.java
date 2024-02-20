package mitarbeiterdb.contract.model;

import java.util.List;

public interface IConnector {
	void setupDB();

	List<List<String>> sendSQLQuery(String sql);

}
