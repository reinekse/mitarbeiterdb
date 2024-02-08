package mitarbeiterdb.implementation.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class AdvancedSearchWindow extends JDialog {

	AdvancedSearchWindow(JPanel parent) {
		setSize(400, 500);
		setLayout(new FlowLayout());
		add(new JPanel());
		add(new PersonenTextFields());

		JButton searchButton = new JButton("Suchen");
		searchButton.addActionListener(e -> {
			// String value1 = textField1.getText();
			// String value2 = textField2.getText();
			// ...

			// Update der JTable mit den bearbeiteten Werten hier durchführen
			// ...

			dispose(); // Bearbeiten-Fenster schließen
		});
		add(searchButton);
		setVisible(true);
	}

}
