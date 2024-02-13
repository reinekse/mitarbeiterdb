package mitarbeiterdb.implementation.view.popupwindows;

import javax.swing.JButton;

import mitarbeiterdb.implementation.controller.InsertObserver;
import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.popupwindows.subcomponents.CancelButton;

public class InsertWindow extends PopupWindow {

	public InsertWindow(Table table) {
		super(table);
		heading.setText("Eintrag hinzufügen: ");
	}

	@Override
	public void addButtonsToButtonPanel() {
		JButton insertButton = new JButton("Hinzufügen");
		insertButton.addActionListener(new InsertObserver(this));

		JButton cancelButton = new JButton("Abbrechen");
		cancelButton.addActionListener(e -> {
			dispose();
		});
		buttonPanel.add(insertButton);
		buttonPanel.add(new CancelButton(this));
		// buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	}

}
