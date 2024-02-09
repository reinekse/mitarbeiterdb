package mitarbeiterdb.implementation.view.popupwindows;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.popupwindows.components.Heading;
import mitarbeiterdb.implementation.view.popupwindows.components.PersonenInput;

public class InsertWindow extends JDialog {

	public InsertWindow(Table table) {
		setTitle("Mitarbeiter Datenbank");
		setLayout(new BorderLayout());

		// heading
		add(new Heading("Neuen Eintrag anlegen:"), BorderLayout.PAGE_START);

		// text fields
		var inputFields = new PersonenInput();
		add(inputFields, BorderLayout.CENTER);
		var padding = new JPanel();
		add(padding, BorderLayout.LINE_START);
		add(padding, BorderLayout.LINE_END);

		// buttons
		JButton insertButton = new JButton("Hinzufügen");
		insertButton.addActionListener(e -> {
			// TODO move code to better place
			var inputString = inputFields.getInputString();

			var sql = "INSERT INTO "
					+ "personen (name, vorname, geburtstag, abteilung, standort_id, anstellungstag) VALUES("
					+ inputString + ");";
			try {
				Connector.getInstance().sendSQLExpression(sql);
				table.update();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			dispose();
		});
		JButton cancelButton = new JButton("Abbrechen");
		cancelButton.addActionListener(e -> {
			dispose();
		});
		var buttonPanel = new JPanel();
		buttonPanel.add(insertButton);
		buttonPanel.add(cancelButton);
		add(buttonPanel, BorderLayout.PAGE_END);
		setLocationRelativeTo(table);
		pack();
		setVisible(true);
	}

}
