package mitarbeiterdb.implementation.view.popupwindows;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.popupwindows.subcomponents.Heading;
import mitarbeiterdb.implementation.view.popupwindows.subcomponents.PersonenInput;

public class EditWindow extends JDialog {

	private int rowIndex;

	public EditWindow(Table table) {

		setTitle("Mitarbeiter Datenbank");
		setLayout(new BorderLayout());

		// heading
		add(new Heading("Eintrag editieren:"), BorderLayout.PAGE_START);

		// text fields
		var inputFields = new PersonenInput();
		inputFields.setTextAccordingToSelectedRow(table);
		add(inputFields, BorderLayout.CENTER);

		// buttons
		JButton saveButton = new JButton("Speichern");
		saveButton.addActionListener(e -> {
			System.out.println("Editiere Zeile" + table.getSelectedRow());
			// String value1 = textField1.getText();
			// String value2 = textField2.getText();
			// ...

			// Update der JTable mit den bearbeiteten Werten hier durchführen
			// ...

			dispose();
		});
		JButton resetButton = new JButton("Zurücksetzen");
		resetButton.addActionListener(e -> {
			dispose();
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
