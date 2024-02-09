package mitarbeiterdb.implementation.view.popupwindows.components;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class PersonenInput_OLD extends JPanel {
	JTextField nachnameField;
	JTextField vornameField;
	JTextField geburtstagField;
	JTextField abteilungField;
	JTextField standortIDField;
	JTextField anstellungstagField;

	PersonenInput_OLD() {
		setLayout(new GridLayout(0, 2, 0, 5));
		var nachnameLabel = new TextFieldLabel("Nachname:");
		nachnameField = new JTextField();
		add(nachnameLabel);
		add(nachnameField);

		var vornameLabel = new TextFieldLabel("Vorname:");
		vornameField = new JTextField();
		add(vornameLabel);
		add(vornameField);

// TODO accept only YYYY-MM-DD input
		var geburtstagLabel = new TextFieldLabel("Geburtstag:");
		geburtstagField = new JTextField();
		add(geburtstagLabel);
		add(geburtstagField);

		var abteilungLabel = new TextFieldLabel("Abteilung:");
		abteilungField = new JTextField();
		add(abteilungLabel);
		add(abteilungField);

// TODO accept only existing IDs (foreign key)
		var standortIDLabel = new TextFieldLabel("Standort-ID:");
		standortIDField = new JTextField();
		add(standortIDLabel);
		add(standortIDField);

		// TODO accept only YYYY-MM-DD input
		var anstellungstagLabel = new TextFieldLabel("Anstellungstag:");
		anstellungstagField = new JTextField();
		add(anstellungstagLabel);
		add(anstellungstagField);

	}

	public void setTextAccordingToSelectedRow() {

	}

	public String getInputString() {
		return getNachname() + ", " + getVorname() + ", " + getGeburtstag() + ", " + getAbteilung() + ", "
				+ getStandortID() + ", " + getAnstellungstag();
	}

	public String getNachname() {
		if (nachnameField.getText().length() > 0) {
			return "'" + nachnameField.getText() + "'";
		} else {
			return null;
		}
	}

	public String getVorname() {
		if (vornameField.getText().length() > 0) {
			return "'" + vornameField.getText() + "'";
		} else {
			return null;
		}
	}

	public String getGeburtstag() {
		if (geburtstagField.getText().length() > 0) {
			return "'" + geburtstagField.getText() + "'";
		} else {
			return null;
		}
	}

	public String getAbteilung() {
		if (abteilungField.getText().length() > 0) {
			return "'" + abteilungField.getText() + "'";
		} else {
			return null;
		}
	}

	public String getStandortID() {
		if (standortIDField.getText().length() > 0) {
			return "'" + standortIDField.getText() + "'";
		} else {
			return null;
		}
	}

	public String getAnstellungstag() {
		if (anstellungstagField.getText().length() > 0) {
			return "'" + anstellungstagField.getText() + "'";
		} else {
			return null;
		}
	}

}
