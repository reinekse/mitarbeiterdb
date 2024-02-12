package mitarbeiterdb.contract.view;

import java.sql.SQLException;
import java.util.List;

public interface ITable {

	String getSelectedID();

	void update() throws SQLException;

	void update(List<List<String>> data) throws SQLException;

	String getType();

}