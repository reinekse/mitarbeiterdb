package mitarbeiterdb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class Main {

	public static void main(String[] args) throws SQLException {

		var f = new JFrame("Frame1");
		JButton sortButton = new JButton("Sortiere!");
		sortButton.setBounds(50, 30, 90, 20);
		// f.add(sortButton);
		String data[][] = { { "101", "Amit", "670000" }, { "102", "Jai", "780000" }, { "101", "Sachin", "700000" },
				{ "101", "Sachin", "700000" }, { "101", "Sachin", "700000" }, { "101", "Sachin", "700000" },
				{ "101", "Sachin", "700000" }, { "101", "Sachin", "700000" }, { "101", "Sachin", "700000" },
				{ "101", "Sachin", "700000" }, { "101", "Sachin", "700000" } };
		String column[] = { "ID", "NAME", "SALARY" };
		JTable jt = new JTable(data, column);
		// jt.setBounds(30, 60, 200, 300);
		JScrollPane scrollPane = new JScrollPane(jt);
		scrollPane.setMinimumSize(new Dimension(100, 100));
		// sp.setBounds(30, 60, 200, 300);
		JPanel panel1 = new JPanel();
		panel1.setMinimumSize(new Dimension(100, 100));
		panel1.setBackground(Color.green);
		JPanel panel2 = new JPanel();
		panel1.setMinimumSize(new Dimension(100, 100));
		panel1.setBackground(Color.red);
		var splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2);
		// var splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane,
		// scrollPane);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Tab 1", null, panel1, "Does nothing");
		tabbedPane.addTab("Tab 2", null, panel2, "Does nothing");
		// f.add(tabbedPane);

		JPanel panel = new JPanel();

		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		JButton button3 = new JButton("Button 3");

		panel.add(button1);
		panel.add(button2);
		panel.add(button3);

		f.add(panel, BorderLayout.NORTH);
		f.add(scrollPane, BorderLayout.CENTER);

		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.pack();
		// f.setSize(500, 500);
		f.setVisible(true);

		// new Frame();
	}

}

/*
 * var db = Connector.getInstance("jdbc:mysql://localhost/mitarbeiter?"); var
 * sql = new SQLBuilder(); try { db.setupDB();
 * db.sendSQLQuery("SELECT * FROM personen ORDER BY geburtstag;"); db.
 * sendSQLQuery("SELECT abteilung, COUNT(abteilung) FROM personen GROUP BY abteilung;"
 * ); db.
 * sendSQLQuery("SELECT vorname, strasse FROM personen JOIN standorte ON standort_id = standorte.id;"
 * ); db.sendSQLQuery(sql.select("personen", "name"));
 * db.sendSQLQuery(sql.select("standorte", "strasse, plz"));
 * db.sendSQLQuery(sql.select("standorte", "strasse, plz"));
 * db.sendSQLExpression(sql.insert("standorte", "strasse, hausnummer",
 * "'Bienenweg', '15'")); db.sendSQLQuery(sql.select("standorte"));
 * db.sendSQLExpression(sql.deleteRows("personen", "standort_id = 2"));
 * db.sendSQLExpression(sql.update("personen", "name, vorname",
 * "'Müller', 'Fenja'", "id = 4")); db.sendSQLExpression(sql.update("personen",
 * "vorname", "'Andreas'", "id > 5")); db.sendSQLQuery(sql.select("personen"));
 * } catch (Exception e) { e.printStackTrace(); }
 */