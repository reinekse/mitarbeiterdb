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
import mitarbeiterdb.implementation.view.popupwindows.subcomponents.InputPanel;

public class InsertWindow extends JDialog {

	public InsertWindow(Table table) {
		setTitle("Mitarbeiter Datenbank");
		setLayout(new BorderLayout());

		// heading
		add(new Heading("Neuen Eintrag anlegen:"), BorderLayout.PAGE_START);

		// text fields
		var inputFields = new InputPanel(table.getType());
		add(inputFields, BorderLayout.CENTER);

		// buttons
		JButton insertButton = new JButton("Hinzufügen");
		insertButton.addActionListener(e -> {
			// TODO move code to better place
			try {
				var sql = new SQLBuilder().insert(table.getType(), inputFields.getInputString());

				Connector.getInstance().sendSQLExpression(sql);
				table.update();
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
		buttonPanel.add(insertButton);
		buttonPanel.add(cancelButton);
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(buttonPanel, BorderLayout.PAGE_END);
		setLocationRelativeTo(table);
		pack();
		setVisible(true);
	}

}
