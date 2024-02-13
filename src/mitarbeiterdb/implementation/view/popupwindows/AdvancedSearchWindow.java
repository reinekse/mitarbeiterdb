package mitarbeiterdb.implementation.view.popupwindows;

import javax.swing.JButton;

import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.popupwindows.subcomponents.CancelButton;

public class AdvancedSearchWindow extends PopupWindow {

	public AdvancedSearchWindow(Table table) {
		super(table);
		heading.setText("Einträge durchsuchen: ");
	}

	@Override
	public void addButtonsToButtonPanel() {

		JButton searchButton = new JButton("Suchen");
		searchButton.addActionListener(e -> {
//					try {
//						var sql = new SQLBuilder().advancedSearch(table.getType(), inputFields.getInputString());
//						var selection = Connector.getInstance().sendSQLQuery(sql);
//						table.update(selection);
//					} catch (SQLException e1) {
//						e1.printStackTrace();
//					}

			dispose();
		});

		buttonPanel.add(searchButton);
		buttonPanel.add(new CancelButton(this));

	}

}
