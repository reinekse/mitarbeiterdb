package mitarbeiterdb.implementation.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.model.SQLBuilder;

public class TableModel extends AbstractTableModel {

	private static final long serialVersionUID = 3591503122834040375L;
	private List<List<String>> data;
	private List<String> columnNames;
	private TableType tableType;

	public TableModel(TableType tableType) throws SQLException {
		this.tableType = tableType;
		var sql = new SQLBuilder().selectAll(tableType);
		var dataWithColumnNames = Connector.getInstance().sendSQLQuery(sql);
		this.columnNames = dataWithColumnNames.get(0);
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
		return tableType;
	}

}
