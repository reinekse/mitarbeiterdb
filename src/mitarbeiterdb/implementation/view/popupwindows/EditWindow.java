package mitarbeiterdb.implementation.view.popupwindows;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.model.SQLBuilder;
import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.popupwindows.subcomponents.Heading;
import mitarbeiterdb.implementation.view.popupwindows.subcomponents.PersonenInput;

public class EditWindow extends JDialog {

	public EditWindow(Table table) {

		setTitle("Mitarbeiter Datenbank");
		setLayout(new BorderLayout());

		// heading
		add(new Heading("Eintrag editieren:"), BorderLayout.PAGE_START);

		// text fields
		var inputFields = new PersonenInput(table.getType());
		inputFields.setTextAccordingToSelectedRow(table);
		add(inputFields, BorderLayout.CENTER);

		// buttons
		JButton saveButton = new JButton("Speichern");
		saveButton.addActionListener(e -> {
			var sql = new SQLBuilder().update("personen", inputFields.getInputString(), table.getSelectedID());
			try {
				Connector.getInstance().sendSQLExpression(sql);
				table.update();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			dispose();
		});

		JButton resetButton = new JButton("Zurücksetzen");
		resetButton.addActionListener(e -> {
			inputFields.setTextAccordingToSelectedRow(table);
		});
		JButton cancelButton = new JButton("Abbrechen");
		cancelButton.addActionListener(e -> {
			dispose();
		});
		var buttonPanel = new JPanel();
		buttonPanel.add(saveButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(cancelButton);
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(buttonPanel, BorderLayout.PAGE_END);

		setLocationRelativeTo(table);
		pack();
		setVisible(true);
	}

}
