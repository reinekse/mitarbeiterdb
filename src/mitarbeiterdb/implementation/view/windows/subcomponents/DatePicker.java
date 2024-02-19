package mitarbeiterdb.implementation.view.windows.subcomponents;

import java.util.Properties;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class DatePicker { // Builder Pattern

	public JDatePickerImpl setup(int year) {
		UtilDateModel model = new UtilDateModel();
		model.setDate(year, 6, 1);
		JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
		DateComponentFormatter formatter = new DateComponentFormatter();
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, formatter);
		return datePicker;
	}

}
