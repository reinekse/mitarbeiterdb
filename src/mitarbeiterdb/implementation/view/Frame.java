package mitarbeiterdb.implementation.view;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import mitarbeiterdb.implementation.controller.TableModel;

public class Frame extends JFrame {

	public Frame(TableModel personenTableModel, TableModel standorteTableModel) throws SQLException {

		var tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Personen", null, new PersonenTab(personenTableModel), "");
		tabbedPane.addTab("Standorte", null, new StandorteTab(standorteTableModel), "");
		add(tabbedPane);
		// setLayout(null);
		setSize(800, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
