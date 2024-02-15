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
		fields.add(new JTextField());
		fields.add(new JTextField());
		fields.add(new JTextField());
		fields.add(new JTextField());

		var standortIDField = new JComboBox<String>();
		for (String id : standortIDs) {
			standortIDField.addItem(id);
		}
		fields.add(standortIDField);
		fields.add(new JTextField());
		addComponents();
	}

}
