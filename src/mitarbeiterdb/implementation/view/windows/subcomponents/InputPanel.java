package mitarbeiterdb.implementation.view.windows.subcomponents;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mitarbeiterdb.implementation.view.Table;

public abstract class InputPanel extends JPanel {
	private static final long serialVersionUID = 7195968973418823368L;
	protected ArrayList<JComponent> fields;
	protected String[] labels;

	public InputPanel() {
		setLayout(new GridLayout(0, 2, 0, 5));
		setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
	}

	protected void addComponents() {
		for (int i = 0; i < fields.size(); i++) {
			add(new JLabel(labels[i]));
			add(fields.get(i));
		}
	}

	public String getInputString() {
		var inputString = "";
		for (JComponent field : fields) {
			var value = getValue(field);
			if (value.length() > 0) {
				value = "'" + value + "'";
			} else {
				value = "null";
			}
			inputString += "," + value;
		}
		return inputString.substring(1); // remove extra comma
	}

	protected String getValue(JComponent field) {
		if (field instanceof JTextField) {
			return ((JTextField) field).getText();
		}
		if (field instanceof JComboBox) {
			return ((JComboBox<?>) field).getSelectedItem().toString();
		}
		return null;
	}

	protected void setValue(JComponent field, String text) {
		if (field instanceof JTextField) {
			((JTextField) field).setText(text);
		}
		if (field instanceof JComboBox) {
			((JComboBox<?>) field).setSelectedItem(text);
		}

	}

	public void setValuesAccordingToSelectedRow(Table table) {

		for (int col = 0; col < fields.size(); col++) {
			var row = table.getSelectedRow();
			var value = table.getValueAt(row, col + 1).toString();
			var field = fields.get(col);
			setValue(field, value);
		}

	}

}
