package mitarbeiterdb.implementation.view.popupwindows.components;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mitarbeiterdb.implementation.view.Table;

public class PersonenInput extends JPanel {
	private ArrayList<JTextField> fields;

	public PersonenInput() {
		String labels[] = { "Nachname:", "Vorname:", "Geburtstag:", "Abteilung:", "Standort-ID:", "Anstellungstag:" };
		setLayout(new GridLayout(0, 2, 0, 5));
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
