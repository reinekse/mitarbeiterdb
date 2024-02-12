package mitarbeiterdb.implementation.view.popupwindows.subcomponents;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mitarbeiterdb.implementation.view.Table;

public class InputPanel extends JPanel {
	private ArrayList<JTextField> fields;
	private String[] labels;

	public InputPanel(String tableType) {
		if (tableType.equals("personen")) {

			labels = "Nachname, Vorname, Geburtstag, Abteilung, Standort-ID, Anstellungstag ".split(",");
		}
		if (tableType.equals("standorte")) {
			labels = "Straße, Hausnummer, PLZ, Ort".split(",");
		}

		setLayout(new GridLayout(0, 2, 0, 5));
		setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		fields = new ArrayList<JTextField>();
		for (String label : labels) {
			add(new JLabel(label));
			var field = new JTextField();
			fields.add(field);
			add(field);
		}
	}

	public String getInputString() {
		var inputString = "";
		for (JTextField field : fields) {
			inputString += "," + getText(field);
		}
		return inputString.substring(1);
	}

	// TODO: some TextFields should take only Dates or existing IDs..
	private String getText(JTextField field) {

		if (field.getText().length() > 0) {
			return "'" + field.getText() + "'";
		} else {
			return null;
		}
	}

	public void setTextAccordingToSelectedRow(Table table) {

		for (int col = 0; col < fields.size(); col++) {
			var row = table.getSelectedRow();
			fields.get(col).setText(table.getValueAt(row, col + 1).toString());
		}

	}

}
