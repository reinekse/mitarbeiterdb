package mitarbeiterdb.implementation.view.popupwindows;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import mitarbeiterdb.implementation.view.popupwindows.components.Heading;
import mitarbeiterdb.implementation.view.popupwindows.components.PersonenInput;

public class AdvancedSearchWindow extends JDialog {

	public AdvancedSearchWindow(JPanel parent) {
		setTitle("Mitarbeiter Datenbank");
		setLayout(new BorderLayout());

		// heading
		add(new Heading("Einträge durchsuchen:"), BorderLayout.PAGE_START);

		// text fields
		add(new PersonenInput(), BorderLayout.CENTER);
		var padding = new JPanel();
		add(padding, BorderLayout.LINE_START);
		add(padding, BorderLayout.LINE_END);

		// buttons
		JButton searchButton = new JButton("Suchen");
		searchButton.addActionListener(e -> {
			// TODO
			// String value1 = textField1.getText();
			// String value2 = textField2.getText();
			// ...

			// Update der JTable mit den bearbeiteten Werten hier durchführen
			// ...

			dispose(); // Bearbeiten-Fenster schließen
		});
		JButton cancelButton = new JButton("Abbrechen");
		cancelButton.addActionListener(e -> {
			dispose();
		});
		var buttonPanel = new JPanel();
		buttonPanel.add(searchButton);
		buttonPanel.add(cancelButton);
		add(buttonPanel, BorderLayout.PAGE_END);
		setLocationRelativeTo(parent);
		pack();
		setVisible(true);
	}

}
