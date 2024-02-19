package mitarbeiterdb.implementation.controller;

import java.sql.SQLException;
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
		if (table.getType() == TableType.PERSONEN) {
			var sql = new SQLBuilder().getStandortIDs();
			var standortIDs = new ArrayList<String>();
			try {
				List<List<String>> result = Connector.getInstance().sendSQLQuery(sql);
				for (List<String> subList : result) {
					standortIDs.add(subList.get(0));
				}
				standortIDs.set(0, ""); // replace column name with empty String (= standort not specified")

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return new PersonenInputPanel(table, standortIDs);
		}
		if (table.getType() == TableType.STANDORTE) {
			return new StandorteInputPanel(table);
		}
		return null;

	}

}
