package mitarbeiterdb.contract.view;

import mitarbeiterdb.implementation.view.Table;

public interface IClient {
	public Table getTable();

	public String getInput();

}
