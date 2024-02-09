package mitarbeiterdb.implementation.view;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class PersonenTextFields extends JPanel {
	PersonenTextFields() {
		setLayout(new GridLayout(0, 2, 0, 5));
		var nachnameLabel = new TextFieldLabel("Nachname:");
		var nachnameField = new JTextField();
		add(nachnameLabel);
		add(nachnameField);

		var vornameLabel = new TextFieldLabel("Vorname:");
		var vornameField = new JTextField();
		add(vornameLabel);
		add(vornameField);

		var geburtstagLabel = new TextFieldLabel("Geburtstag:");
		var geburtstagField = new JTextField();
		add(geburtstagLabel);
		add(geburtstagField);

		var abteilungLabel = new TextFieldLabel("Abteilung:");
		var abteilungField = new JTextField();
		add(abteilungLabel);
		add(abteilungField);

		var standortIDLabel = new TextFieldLabel("Standort-ID:");
		var standortIDField = new JTextField();
		add(standortIDLabel);
		add(standortIDField);

		var anstellungstagLabel = new TextFieldLabel("Anstellungstag:");
		var anstellungstagField = new JTextField();
		add(anstellungstagLabel);
		add(anstellungstagField);

	}

}
