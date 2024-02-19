package mitarbeiterdb.implementation.view.windows.subcomponents;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class PersonenInputPanel extends InputPanel {

	private static final long serialVersionUID = 6282235112545942707L;

	public PersonenInputPanel(ArrayList<String> standortIDs) {
		labels = "Nachname,Vorname,Geburtstag,Abteilung,Standort-ID,Anstellungstag ".split(",");
		fields = new ArrayList<JComponent>();

		// Nachname
		fields.add(new JTextField());

		// Vorname
		fields.add(new JTextField());

		// Geburtstag
		fields.add(new DatePicker().setup(1985));

		// Abteilung
		fields.add(new JTextField());

		// Standort-ID
		var standortIDField = new JComboBox<String>();
		for (String id : standortIDs) {
			standortIDField.addItem(id);
		}
		fields.add(standortIDField);

		// Anstellungstag
		fields.add(new DatePicker().setup(2020));

		addComponents();
	}

}
