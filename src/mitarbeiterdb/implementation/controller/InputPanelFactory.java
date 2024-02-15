package mitarbeiterdb.implementation.controller;

import mitarbeiterdb.implementation.view.windows.subcomponents.InputPanel;
import mitarbeiterdb.implementation.view.windows.subcomponents.PersonenInputPanel;
import mitarbeiterdb.implementation.view.windows.subcomponents.StandorteInputPanel;

public class InputPanelFactory {
	public InputPanel createPanel(TableType tableType) {
		if (tableType == TableType.PERSONEN) {
			return new PersonenInputPanel();
		}
		if (tableType == TableType.STANDORTE) {
			return new StandorteInputPanel();
		}
		return null;

	}

}
