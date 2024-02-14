package mitarbeiterdb.contract.controller;

import mitarbeiterdb.implementation.view.Table;

public interface IObservable {
	public Table getTable();

	public String getInput();

	public void resetInput();

}
