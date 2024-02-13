package mitarbeiterdb.implementation.view.popupwindows;

import javax.swing.JButton;

import mitarbeiterdb.implementation.controller.Observer;
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
		saveButton.addActionListener(new Observer(this));

		JButton resetButton = new JButton("Zurücksetzen");
		resetButton.addActionListener(e -> {
			inputPanel.setTextAccordingToSelectedRow(table);
		});

		buttonPanel.add(saveButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(new CancelButton(this));

	}

}
