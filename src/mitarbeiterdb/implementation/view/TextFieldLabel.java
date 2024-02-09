package mitarbeiterdb.implementation.view;

import javax.swing.JLabel;

public class TextFieldLabel extends JLabel {
	TextFieldLabel(String text) {
		super(text + "    ");
		setHorizontalAlignment(JLabel.RIGHT);
	}
}
