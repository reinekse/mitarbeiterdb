package mitarbeiterdb.implementation.view;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import mitarbeiterdb.implementation.controller.TableModel;

public class StandorteTab extends JPanel {
	StandorteTab(TableModel standorteTableModel) throws SQLException {

		JTable table = new JTable(standorteTableModel);
		JScrollPane scrollPane = new JScrollPane(table);

		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
	}

}
