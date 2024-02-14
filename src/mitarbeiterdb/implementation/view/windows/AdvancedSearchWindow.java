package mitarbeiterdb.implementation.view.windows;

import mitarbeiterdb.implementation.controller.ButtonPurpose;
import mitarbeiterdb.implementation.controller.Observer;
import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.windows.subcomponents.WindowCloseButton;

public class AdvancedSearchWindow extends Window {

	public AdvancedSearchWindow(Table table) {
		super(table);
		heading.setText("Einträge durchsuchen: ");
	}

	@Override
	public void addButtonsToButtonPanel() {

		var searchButton = new WindowCloseButton("Suchen", this);
		searchButton.addActionListener(new Observer(ButtonPurpose.ADVANCED_SEARCH, this));
		buttonPanel.add(searchButton);

		var cancelButton = new WindowCloseButton("Abbrechen", this);
		buttonPanel.add(cancelButton);

	}

}
