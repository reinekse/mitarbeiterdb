package mitarbeiterdb.implementation.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import mitarbeiterdb.implementation.controller.TableModel;

public abstract class Tab extends JPanel {

	Tab(TableModel model) throws SQLException {
		setLayout(new BorderLayout());
		add(new SearchPanel(), BorderLayout.PAGE_START);

		var table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showPopup(e, table.getSelectedRow());
			}
		});

		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	private void showPopup(MouseEvent evt, int selectedRow) {

		JPopupMenu popup = new JPopupMenu();

		// Option "Edit"
		JMenuItem editItem = new JMenuItem("Bearbeiten");
		editItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showEditDialog(selectedRow);
			}
		});
		popup.add(editItem);

		// Option "Delete"
		JMenuItem deleteItem = new JMenuItem("Löschen");
		deleteItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showDeleteDialog(selectedRow);
			}
		});
		popup.add(deleteItem);

		popup.show(this, evt.getX(), evt.getY());
	}

	private void showEditDialog(int row) {
		var editWindow = new EditWindow(this, row);
		System.out.println("Bearbeiten: Zeile " + row);
	}

	private void showDeleteDialog(int row) {
		int result = JOptionPane.showConfirmDialog(Tab.this, "Unwiderruflich löschen?", "Löschen bestätigen",
				JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			System.out.println("Löschen: Zeile " + row);
		}
	}

}
