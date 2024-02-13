package mitarbeiterdb.implementation.view.popupwindows;

import java.sql.SQLException;

import javax.swing.JButton;

import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.model.SQLBuilder;
import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.popupwindows.subcomponents.CancelButton;

public class EditWindow extends PopupWindow {

	public EditWindow(Table table) {
		super(table);
		inputPanel.setTextAccordingToSelectedRow(table);
		heading.setText("Eintrag editieren: ");
	}

	@Override
	public void addButtonsToButtonPanel() {
		JButton saveButton = new JButton("Speichern");
		saveButton.addActionListener(e -> {
			var sql = new SQLBuilder().update(table.getType(), inputPanel.getInputString(), table.getSelectedID());
			try {
				Connector.getInstance().sendSQLExpression(sql);
				table.update();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			dispose();
		});

		JButton resetButton = new JButton("Zurücksetzen");
		resetButton.addActionListener(e -> {
			inputPanel.setTextAccordingToSelectedRow(table);
		});

		buttonPanel.add(saveButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(new CancelButton(this));

	}

}
