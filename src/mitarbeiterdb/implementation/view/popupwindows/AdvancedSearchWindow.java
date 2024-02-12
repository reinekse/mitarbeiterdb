package mitarbeiterdb.implementation.view.popupwindows;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.model.SQLBuilder;
import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.popupwindows.subcomponents.Heading;
import mitarbeiterdb.implementation.view.popupwindows.subcomponents.PersonenInput;

public class AdvancedSearchWindow extends JDialog {

	public AdvancedSearchWindow(Table table) {
		setTitle("Mitarbeiter Datenbank");
		setLayout(new BorderLayout());

		// heading
		add(new Heading("Einträge durchsuchen:"), BorderLayout.PAGE_START);

		// text fields
		var inputFields = new PersonenInput(table.getType());
		add(inputFields, BorderLayout.CENTER);

		// buttons
		JButton searchButton = new JButton("Suchen");
		searchButton.addActionListener(e -> {
			try {
				var sql = new SQLBuilder().advancedSearch(table.getType(), inputFields.getInputString());
				var selection = Connector.getInstance().sendSQLQuery(sql);
				table.update(selection);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			dispose();
		});
		JButton cancelButton = new JButton("Abbrechen");
		cancelButton.addActionListener(e -> {
			dispose();
		});
		var buttonPanel = new JPanel();
		buttonPanel.add(searchButton);
		buttonPanel.add(cancelButton);
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(buttonPanel, BorderLayout.PAGE_END);
		setLocationRelativeTo(table);
		pack();
		setVisible(true);
	}

}
