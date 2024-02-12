package mitarbeiterdb.implementation.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;

import mitarbeiterdb.implementation.controller.TableModel;
import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.model.SQLBuilder;
import mitarbeiterdb.implementation.view.popupwindows.OptionWindow;

public class Table extends JTable {

	public Table(TableModel model) {
		super(model);
		getColumnModel().getColumn(0).setPreferredWidth(10);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				new OptionWindow(Table.this, mouseEvent);
			}
		});

	}

	public String getSelectedID() {
		return getValueAt(getSelectedRow(), 0).toString();
	}

	public void update() throws SQLException {
		TableModel tableModel = (TableModel) getModel();
		var sql = new SQLBuilder().selectAll(getType());
		List<List<String>> data = Connector.getInstance().sendSQLQuery(sql);
		tableModel.setData(data);
		tableModel.fireTableDataChanged();
	}

	public void update(List<List<String>> data) throws SQLException {
		TableModel tableModel = (TableModel) getModel();
		tableModel.setData(data);
		tableModel.fireTableDataChanged();
	}

	public String getType() {
		TableModel tableModel = (TableModel) getModel();
		System.out.println(tableModel.getType());
		return tableModel.getType();

	}

}
