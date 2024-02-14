package mitarbeiterdb.implementation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import mitarbeiterdb.contract.controller.IObservable;
import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.model.SQLBuilder;
import mitarbeiterdb.implementation.view.Table;

public class Observer implements ActionListener {

	private ButtonPurpose purpose;
	private IObservable observable;
	private Table table;
	private String sql;

	public Observer(ButtonPurpose purpose, IObservable observable) {
		this.purpose = purpose;
		this.observable = observable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.table = observable.getTable();
		var input = observable.getInput();
		switch (purpose) {
		case DELETE:
			sql = new SQLBuilder().delete(table.getType(), table.getSelectedID());
			break;
		case INSERT:
			sql = new SQLBuilder().insert(table.getType(), input);
			break;
		case EDIT:
			sql = new SQLBuilder().update(table.getType(), table.getSelectedID(), input);
			break;
		case SIMPLE_SEARCH:
			sql = new SQLBuilder().simpleSearch(table.getType(), input);
			break;
		case ADVANCED_SEARCH:
			sql = new SQLBuilder().advancedSearch(table.getType(), input);
			break;
		case RESET:
			observable.resetInput();
		default:
			break;
		}

		List<List<String>> data = null;
		try {
			if (sql != null) {
				data = Connector.getInstance().sendSQLQuery(sql);
			}
			updateTable(data);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void updateTable(List<List<String>> data) throws SQLException {
		var tableModel = (TableModel) table.getModel();
		if (data == null) {
			var sql = new SQLBuilder().selectAll(table.getType());
			data = Connector.getInstance().sendSQLQuery(sql);
		}
		tableModel.setData(data);
		tableModel.fireTableDataChanged();
	}

}
