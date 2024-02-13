package mitarbeiterdb.implementation.view.popupwindows.subcomponents;

import javax.swing.JButton;

import mitarbeiterdb.implementation.view.popupwindows.PopupWindow;

public class CancelButton extends JButton {
	public CancelButton(PopupWindow window) {
		super("Abbrechen");
		addActionListener(e -> {
			window.dispose();
		});
	}

}
