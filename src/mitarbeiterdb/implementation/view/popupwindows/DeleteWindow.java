package mitarbeiterdb.implementation.view.popupwindows;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import mitarbeiterdb.contract.view.ITable;
import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.model.SQLBuilder;
import mitarbeiterdb.implementation.view.Table;

public class DeleteWindow {

	public DeleteWindow(Table table) {
		var choice = JOptionPane.showConfirmDialog(table, "Diesen Eintrag unwiderruflich löschen?",
				"Löschen bestätigen", JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			try {
				deleteSelectedRow(table);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void deleteSelectedRow(ITable table) throws SQLException {
		var sql = new SQLBuilder().delete(table.getType(), table.getSelectedID());
		Connector.getInstance().sendSQLQuery(sql);
		table.update();
	}

}
