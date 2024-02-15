package mitarbeiterdb.implementation.view.windows.subcomponents;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.model.SQLBuilder;

public class PersonenInputPanel extends InputPanel {

	private static final long serialVersionUID = 6282235112545942707L;

	public PersonenInputPanel() {
		labels = "Nachname,Vorname,Geburtstag,Abteilung,Standort-ID,Anstellungstag ".split(",");
		fields = new ArrayList<JComponent>();
		fields.add(new JTextField());
		fields.add(new JTextField());
		fields.add(new JTextField());
		fields.add(new JTextField());

		var sql = new SQLBuilder().getStandortIDs();
		var standortIDs = new ArrayList<String>();
		try {
			List<List<String>> result = Connector.getInstance().sendSQLQuery(sql);
			for (List<String> subList : result) {
				standortIDs.add(subList.get(0));
			}
			standortIDs.remove(0); // remove column name

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		var standortIDField = new JComboBox<String>();
		for (String id : standortIDs) {
			standortIDField.addItem(id);
		}
		fields.add(standortIDField);
		fields.add(new JTextField());
		addComponents();
	}

}
