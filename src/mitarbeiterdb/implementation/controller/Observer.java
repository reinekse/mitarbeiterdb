package mitarbeiterdb.implementation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import mitarbeiterdb.contract.view.IClient;
import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.model.SQLBuilder;
import mitarbeiterdb.implementation.view.SimpleSearchPanel;
import mitarbeiterdb.implementation.view.popupwindows.AdvancedSearchWindow;
import mitarbeiterdb.implementation.view.popupwindows.EditWindow;
import mitarbeiterdb.implementation.view.popupwindows.InsertWindow;
import mitarbeiterdb.implementation.view.popupwindows.PopupWindow;

public class Observer implements ActionListener {

	private IClient client;
	private String sql;

	public Observer(IClient client) {
		this.client = client;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var table = client.getTable();
		if (client instanceof EditWindow) {
			sql = new SQLBuilder().update(table.getType(), client.getInput(), table.getSelectedID());
		}

		if (client instanceof InsertWindow) {
			sql = new SQLBuilder().insert(table.getType(), client.getInput());
		}

		if (client instanceof AdvancedSearchWindow) {
			sql = new SQLBuilder().advancedSearch(table.getType(), client.getInput());
		}

		if (client instanceof SimpleSearchPanel) {
			sql = new SQLBuilder().search(table.getType(), client.getInput());
		}

		try {
			var result = Connector.getInstance().sendSQLQuery(sql);
			if (result == null) {
				table.update();
			} else {
				table.update(result);
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		if (client instanceof PopupWindow) {
			((PopupWindow) client).dispose();
		}

//			// new SQLBuilder().delete(table.getType(), table.getSelectedID());
//			// new SQLBuilder().advancedSearch(table.getType(), client.getInput());
//			// new SQLBuilder().search(table.getType(), searchField.getText());
//
//			Connector.getInstance().sendSQLExpression(sql);
//			table.update();
//			// window.dispose();
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		}
	}

}
