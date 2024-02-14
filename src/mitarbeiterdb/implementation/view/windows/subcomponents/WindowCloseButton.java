package mitarbeiterdb.implementation.view.windows.subcomponents;

import javax.swing.JButton;

import mitarbeiterdb.implementation.view.windows.Window;

public class WindowCloseButton extends JButton {
	public WindowCloseButton(String label, Window window) {
		super(label);

		addActionListener(e -> {
			window.dispose();
		});
	}

}
