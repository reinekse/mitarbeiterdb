package mitarbeiterdb.implementation.view.windows.subcomponents;

import java.util.Properties;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class DatePicker { // Builder Pattern

	public JDatePickerImpl setup(int year) {
		UtilDateModel model = new UtilDateModel();

		// set default year accoording to requirements (geburtstag vs anstellungsjahr)
		model.setDate(year, 6, 1); // month and day will be 1st of June (random choice)

		JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
		DateComponentFormatter formatter = new DateComponentFormatter(); // dd.MM.yyyy
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, formatter);
		return datePicker;
	}

}
