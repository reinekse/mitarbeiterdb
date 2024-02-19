package mitarbeiterdb.implementation.view;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import mitarbeiterdb.implementation.controller.TableModel;

public class Frame extends JFrame {

	private static final long serialVersionUID = -5368259921477768764L;

	public Frame(TableModel personenTableModel, TableModel standorteTableModel) throws SQLException {
		super("Mitarbeiter Datenbank");
		var tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Personen", null, new Tab(personenTableModel), "");
		tabbedPane.addTab("Standorte", null, new Tab(standorteTableModel), "");
		add(tabbedPane);
		setSize(800, 400);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
