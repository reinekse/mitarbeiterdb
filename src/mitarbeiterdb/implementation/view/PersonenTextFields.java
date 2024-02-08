package mitarbeiterdb.implementation.view;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PersonenTextFields extends JPanel {
	PersonenTextFields() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		var size = 20;
		var lastnameLabel = new JLabel("Nachname: ");
		var lastnameField = new JTextField(size);
		add(createInputRow(lastnameLabel, lastnameField));

		var firstnameLabel = new JLabel("Vorname: ");
		var firstnameField = new JTextField(size);
		add(createInputRow(firstnameLabel, firstnameField));

		var birthdayLabel = new JLabel("Geburtstag: ");
		var birthdayField = new JTextField(size);
		add(createInputRow(birthdayLabel, birthdayField));

		var departmentLabel = new JLabel("Abteilung: ");
		var departmentField = new JTextField(size);
		add(createInputRow(departmentLabel, departmentField));

		var locationIDLabel = new JLabel("Standort-ID: ");
		var locationIDField = new JTextField(size);
		add(createInputRow(locationIDLabel, locationIDField));
	}

	private JPanel createInputRow(JLabel label, JTextField textField) {
		JPanel inputRowPanel = new JPanel();
		inputRowPanel.add(label);
		inputRowPanel.add(textField);
		return inputRowPanel;
	}

}
