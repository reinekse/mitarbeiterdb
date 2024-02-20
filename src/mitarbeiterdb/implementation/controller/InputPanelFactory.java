package mitarbeiterdb.implementation.controller;

import java.util.ArrayList;
import java.util.List;

import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.model.SQLBuilder;
import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.windows.subcomponents.InputPanel;
import mitarbeiterdb.implementation.view.windows.subcomponents.PersonenInputPanel;
import mitarbeiterdb.implementation.view.windows.subcomponents.StandorteInputPanel;

public class InputPanelFactory {
	public InputPanel createInputPanel(Table table) {
		// ----------------------
		// PersonenInputPanel
		// ----------------------
		if (table.getType() == TableType.PERSONEN) {
			var sql = new SQLBuilder().getStandortIDs();
			var availableStandortIDs = new ArrayList<String>();
			List<List<String>> result = Connector.getInstance().sendSQLQuery(sql);
			for (List<String> subList : result) {
				availableStandortIDs.add(subList.get(0));
			}
			availableStandortIDs.set(0, ""); // replace column name with empty String (= standort not specified")

			return new PersonenInputPanel(table, availableStandortIDs);
		}
		// ----------------------
		// StandorteInputPanel
		// ----------------------
		if (table.getType() == TableType.STANDORTE) {
			return new StandorteInputPanel(table);
		}
		return null;

	}

}
