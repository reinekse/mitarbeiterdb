package mitarbeiterdb.implementation.view.windows.subcomponents;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;

import mitarbeiterdb.implementation.view.Table;

//-----------------------------------------------------
// Panel with different kinds of labeled input fields
//-----------------------------------------------------
public abstract class InputPanel extends JPanel {
	private static final long serialVersionUID = 7195968973418823368L;
	protected ArrayList<JComponent> fields;
	protected ArrayList<String> labels;
	protected Table table;

	public InputPanel(Table table) {
		this.table = table;
		labels = table.getHeader();
		labels.remove(0); // remove ID -> ID is auto-generated, users shouldn't be able to set ID
		setLayout(new GridLayout(0, 2, 0, 5));
		setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
	}

	// add labels and input fields to panel
	protected void addComponents() {
		for (int i = 0; i < fields.size(); i++) {
			add(new JLabel(labels.get(i)));
			fields.get(i).setPreferredSize(new Dimension(100, 22));
			add(fields.get(i));
		}
	}

	// get comma-separated String with values from all input fields
	public String getInputString() {
		var inputString = "";
		for (JComponent field : fields) {
			var value = getValue(field);
			if (value.equals("")) {
				value = "null";
			} else {
				value = "'" + value + "'";
			}
			inputString += "," + value;
		}
		return inputString.substring(1); // remove extra comma
	}

	// get value from one specific input field
	// (may be text field, combo box or date picker)
	protected String getValue(JComponent field) {
		if (field instanceof JTextField) {
			var value = ((JTextField) field).getText();
			return value;
		}
		if (field instanceof JComboBox) {
			var value = ((JComboBox<?>) field).getSelectedItem().toString();
			return value;
		}
		if (field instanceof JDatePickerImpl) {
			var rawValue = ((JDatePickerImpl) field).getModel().getValue();
			if (rawValue != null) {
				var value = new SimpleDateFormat("yyyy-MM-dd").format(rawValue);
				return value;
			}
		}
		return "";
	}

	// set value of one specific input field
	protected void setValue(JComponent field, String text) {
		if (field instanceof JTextField) {
			((JTextField) field).setText(text);
		}
		if (field instanceof JComboBox) {
			((JComboBox<?>) field).setSelectedItem(text);
		}

		if (field instanceof JDatePickerImpl) {

			String[] dateParts = text.split("-");
			int year = Integer.parseInt(dateParts[0]);
			int month = Integer.parseInt(dateParts[1]) - 1; // months start at 0
			int day = Integer.parseInt(dateParts[2]);
			((JDatePickerImpl) field).getModel().setDate(year, month, day);
			((JDatePickerImpl) field).getModel().setSelected(true); // display choosen date
		}

	}

	// set values of all input fields based on displayed table
	public void setValuesAccordingToSelectedRow() {

		for (int col = 0; col < fields.size(); col++) {
			var row = table.getSelectedRow();
			var value = table.getValueAt(row, col + 1).toString(); // + 1 because there's no input field for ID
			var field = fields.get(col);
			setValue(field, value);
		}

	}

}
