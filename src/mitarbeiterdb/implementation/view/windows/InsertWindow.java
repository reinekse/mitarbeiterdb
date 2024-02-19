package mitarbeiterdb.implementation.view.windows;

import mitarbeiterdb.implementation.controller.ButtonPurpose;
import mitarbeiterdb.implementation.controller.Observer;
import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.windows.subcomponents.WindowCloseButton;

public class InsertWindow extends Window {
	private static final long serialVersionUID = 4174979247808594995L;

	public InsertWindow(Table table) {
		super(table);
		heading.setText("Eintrag hinzufügen: ");
	}

	@Override
	public void addButtonsToButtonPanel() {
		var insertButton = new WindowCloseButton("Hinzufügen", this);
		insertButton.addActionListener(new Observer(ButtonPurpose.INSERT, this));
		buttonPanel.add(insertButton);

		var cancelButton = new WindowCloseButton("Abbrechen", this);
		buttonPanel.add(cancelButton);
		// buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	}

}
