package mitarbeiterdb.implementation.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import mitarbeiterdb.contract.view.ITable;
import mitarbeiterdb.implementation.controller.TableModel;
import mitarbeiterdb.implementation.controller.TableType;
import mitarbeiterdb.implementation.view.windows.OptionWindow;

public class Table extends JTable implements ITable {

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
