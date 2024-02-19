package mitarbeiterdb.implementation.view.windows.subcomponents;

import javax.swing.JButton;

import mitarbeiterdb.implementation.view.windows.Window;

public class WindowCloseButton extends JButton {

	private static final long serialVersionUID = -5086089945796455916L;

	public WindowCloseButton(String label, Window window) {
		super(label);

		addActionListener(e -> {
			window.dispose();
		});
	}

}
