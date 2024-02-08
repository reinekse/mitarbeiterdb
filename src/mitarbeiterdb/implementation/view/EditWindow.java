package mitarbeiterdb.implementation.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class EditWindow extends JDialog {

	private int rowIndex;

	public EditWindow(JPanel parent, int rowIndex) {
		this.rowIndex = rowIndex;

		setSize(400, 500);
		setLayout(new FlowLayout());
		add(new PersonenTextFields());

		JButton saveButton = new JButton("Speichern");
		saveButton.addActionListener(e -> {
			// String value1 = textField1.getText();
			// String value2 = textField2.getText();
			// ...

			// Update der JTable mit den bearbeiteten Werten hier durchführen
			// ...

			dispose(); // Bearbeiten-Fenster schließen
		});
		add(saveButton);
		setVisible(true);
	}

}
