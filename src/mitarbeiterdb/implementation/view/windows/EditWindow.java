package mitarbeiterdb.implementation.view.windows;

import javax.swing.JButton;

import mitarbeiterdb.implementation.controller.ButtonPurpose;
import mitarbeiterdb.implementation.controller.Observer;
import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.windows.subcomponents.WindowCloseButton;

public class EditWindow extends Window {

	public EditWindow(Table table) {
		super(table);
		inputPanel.setTextAccordingToSelectedRow(table);
		heading.setText("Eintrag editieren: ");
	}

	@Override
	public void addButtonsToButtonPanel() {
		var saveButton = new WindowCloseButton("Speichern", this);
		saveButton.addActionListener(new Observer(ButtonPurpose.EDIT, this));
		buttonPanel.add(saveButton);

		var resetButton = new JButton("Zurücksetzen");
		resetButton.addActionListener(new Observer(ButtonPurpose.RESET, this));
		buttonPanel.add(resetButton);

		var cancelButton = new WindowCloseButton("Abbrechen", this);
		buttonPanel.add(cancelButton);

	}

}
