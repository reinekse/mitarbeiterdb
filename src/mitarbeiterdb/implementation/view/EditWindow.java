package mitarbeiterdb.implementation.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditWindow extends JFrame {

	private int rowIndex;

	public EditWindow(JPanel parent, int rowIndex) {
		this.rowIndex = rowIndex;

		// Fenstergröße und Layout initialisieren
		setSize(200, 200);
		setLayout(new FlowLayout());

		// Texteingabefelder hinzufügen
		JTextField textField1 = new JTextField();
		JTextField textField2 = new JTextField();
		// ...

		add(textField1);
		add(textField2);
		// ...

		// Beispielhaft: Speichern Button hinzufügen
		JButton speichernButton = new JButton("Speichern");
		speichernButton.addActionListener(e -> {
			// Code für das Speichern der Bearbeitungen hier einfügen
			String value1 = textField1.getText();
			String value2 = textField2.getText();
			// ...

			// Update der JTable mit den bearbeiteten Werten hier durchführen
			// ...

			dispose(); // Bearbeiten-Fenster schließen
		});
		add(speichernButton);
	}

}
