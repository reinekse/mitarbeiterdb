package mitarbeiterdb.implementation.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;

import mitarbeiterdb.contract.view.ITable;
import mitarbeiterdb.implementation.controller.TableModel;
import mitarbeiterdb.implementation.controller.TableType;
import mitarbeiterdb.implementation.view.windows.OptionWindow;

public class Table extends JTable implements ITable {

	private static final long serialVersionUID = -5583810090162071749L;

	public Table(TableModel model) {
		super(model);
		getColumnModel().getColumn(0).setPreferredWidth(10);
		beautifyHeader(model);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				new OptionWindow(Table.this, mouseEvent);
			}
		});

	}

	// show user other column names than in DB
	private void beautifyHeader(TableModel model) {
		var header = getTableHeader();
		for (int i = 0; i < getColumnCount(); i++) {
			var column = header.getColumnModel().getColumn(i);
			var columnName = model.getColumnName(i);
			column.setHeaderValue(columnName.substring(0, 1).toUpperCase() + columnName.substring(1));
			if (columnName.equals("id") || columnName.equals("plz")) {
				column.setHeaderValue(columnName.toUpperCase());
			}
			if (columnName.equals("strasse")) {
				column.setHeaderValue("Straße");
			}
			if (columnName.equals("standort_id")) {
				column.setHeaderValue("Standort-ID");
			}

		}
	}

	// get displayed column names
	public ArrayList<String> getHeader() {
		var header = getTableHeader();
		var columnNames = new ArrayList<String>();
		for (int i = 0; i < getColumnCount(); i++) {
			var column = header.getColumnModel().getColumn(i);
			var name = column.getHeaderValue().toString();
			columnNames.add(name);
		}
		return columnNames;

	}

	@Override
	public String getSelectedID() {
		return getValueAt(getSelectedRow(), 0).toString();
	}

	@Override
	public TableType getType() {
		TableModel tableModel = (TableModel) getModel();
		return tableModel.getType();

	}

}
