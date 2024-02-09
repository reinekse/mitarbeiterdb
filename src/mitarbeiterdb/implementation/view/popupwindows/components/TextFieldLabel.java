package mitarbeiterdb.implementation.view.popupwindows.components;

import javax.swing.JLabel;

public class TextFieldLabel extends JLabel {
	TextFieldLabel(String text) {
		super(text + "    ");
		setHorizontalAlignment(JLabel.RIGHT);
	}
}
