package mitarbeiterdb.implementation.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import mitarbeiterdb.implementation.controller.TableModel;

public class PersonenTab extends JPanel {

	PersonenTab(TableModel personenTableModel) throws SQLException {

		var table = new JTable(personenTableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setMinimumSize(new Dimension(100, 500));

		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
	}

}
