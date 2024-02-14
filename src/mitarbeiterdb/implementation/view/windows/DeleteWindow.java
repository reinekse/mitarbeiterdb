package mitarbeiterdb.implementation.view.windows;

import java.awt.Component;

import javax.swing.JTextField;

import mitarbeiterdb.implementation.controller.ButtonPurpose;
import mitarbeiterdb.implementation.controller.Observer;
import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.windows.subcomponents.WindowCloseButton;

public class DeleteWindow extends Window {

	public DeleteWindow(Table table) {
		super(table);
		inputPanel.setTextAccordingToSelectedRow(table);
		disableEditing();
		heading.setText("Eintrag löschen? ");
	}

	@Override
	public void addButtonsToButtonPanel() {
		var deleteButton = new WindowCloseButton("Löschen", this);
		deleteButton.addActionListener(new Observer(ButtonPurpose.DELETE, this));
		buttonPanel.add(deleteButton);

		var cancelButton = new WindowCloseButton("Abbrechen", this);
		buttonPanel.add(cancelButton);

	}

	private void disableEditing() {
		Component[] components = inputPanel.getComponents();

		for (Component component : components) {
			if (component instanceof JTextField) {
				JTextField textField = (JTextField) component;
				textField.setEditable(false);
			}
		}
	}

}
