package mitarbeiterdb.implementation.view.popupwindows.subcomponents;

import javax.swing.JLabel;

public class InputLabel extends JLabel {
	InputLabel(String text) {
		super(text + "    ");
		setHorizontalAlignment(JLabel.RIGHT);
	}
}
