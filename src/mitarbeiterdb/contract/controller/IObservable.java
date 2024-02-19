package mitarbeiterdb.contract.controller;

import mitarbeiterdb.implementation.view.Table;

//-----------------------------------------------------------------
// This interface is implemented by panels/windows
// with input fields/buttons for database interaction)
//----------------------------------------------------------------
public interface IObservable {
	public Table getTable();

	public String getInput();

	public void resetInput();

}
