package mitarbeiterdb.implementation.view.windows.subcomponents;

import javax.swing.JLabel;

public class InputLabel extends JLabel {
	InputLabel(String text) {
		super(text + "    ");
		setHorizontalAlignment(JLabel.RIGHT);
	}
}
