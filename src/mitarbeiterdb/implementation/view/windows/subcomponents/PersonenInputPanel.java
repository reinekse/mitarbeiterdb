package mitarbeiterdb.implementation.view.windows.subcomponents;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class PersonenInputPanel extends InputPanel {

	private static final long serialVersionUID = 6282235112545942707L;

	public PersonenInputPanel() {
		labels = "Nachname,Vorname,Geburtstag,Abteilung,Standort-ID,Anstellungstag ".split(",");
		fields = new ArrayList<JComponent>();
		fields.add(new JTextField());
		fields.add(new JTextField());
		fields.add(new JTextField());
		fields.add(new JTextField());
		fields.add(new JTextField());
		fields.add(new JTextField());
		addComponents();
	}

}
