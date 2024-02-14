package mitarbeiterdb.implementation.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
	private List<List<String>> data;
	private List<String> columnNames;
	private TableType type;

	public TableModel(List<List<String>> dataWithColumnNames) {
		this.columnNames = dataWithColumnNames.get(0);
		if (columnNames.get(1).equals("name")) {
			this.type = TableType.PERSONEN;
		}
		if (columnNames.get(1).equals("strasse")) {
			this.type = TableType.STANDORTE;
		}
		this.data = dataWithColumnNames;
		this.data.remove(0);
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public String getColumnName(int column) {
		return columnNames.get(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		return data.get(row).get(column);
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
		data.get(row).add(column, value.toString());
		fireTableCellUpdated(row, column);
	}

	public void setData(List<List<String>> dataWithColumnNames) {
		this.columnNames = dataWithColumnNames.get(0);
		this.data = dataWithColumnNames;
		this.data.remove(0);

	}

	public TableType getType() {
		return type;
	}

}
