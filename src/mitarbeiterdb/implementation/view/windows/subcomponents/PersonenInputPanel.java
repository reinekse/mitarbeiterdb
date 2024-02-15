package mitarbeiterdb.implementation.view.windows.subcomponents;

import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class PersonenInputPanel extends InputPanel {

	private static final long serialVersionUID = 6282235112545942707L;

	public PersonenInputPanel(ArrayList<String> standortIDs) {
		labels = "Nachname,Vorname,Geburtstag,Abteilung,Standort-ID,Anstellungstag ".split(",");
		fields = new ArrayList<JComponent>();
		fields.add(new JTextField());
		fields.add(new JTextField());
		fields.add(new JTextField());
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		fields.add(datePicker);
		// fields.add(new JTextField());

		var standortIDField = new JComboBox<String>();
		for (String id : standortIDs) {
			standortIDField.addItem(id);
		}
		fields.add(standortIDField);
		fields.add(new JTextField());
		addComponents();
	}

}
