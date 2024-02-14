package mitarbeiterdb.contract.view;

import mitarbeiterdb.implementation.controller.TableType;

public interface ITable {

	String getSelectedID();

	TableType getType();

}