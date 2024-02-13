package mitarbeiterdb.implementation.view.popupwindows;

import javax.swing.JButton;

import mitarbeiterdb.implementation.controller.Observer;
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
		searchButton.addActionListener(new Observer(this));

		buttonPanel.add(searchButton);
		buttonPanel.add(new CancelButton(this));

	}

}
