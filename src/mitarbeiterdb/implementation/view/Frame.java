package mitarbeiterdb.implementation.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import mitarbeiterdb.implementation.controller.TableModel;

//-----------------------------------------------------
// Top level GUI component, contains everything else
//-----------------------------------------------------
public class Frame extends JFrame {

	private static final long serialVersionUID = -5368259921477768764L;

	public Frame(TableModel personenTableModel, TableModel standorteTableModel) {
		super("Mitarbeiter Datenbank");
		// one Tab for Personen, one Tab for Standorte
		var tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Personen", null, new Tab(personenTableModel), "");
		tabbedPane.addTab("Standorte", null, new Tab(standorteTableModel), "");
		add(tabbedPane);
		setSize(800, 400);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
