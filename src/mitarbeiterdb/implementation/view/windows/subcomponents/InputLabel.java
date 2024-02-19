package mitarbeiterdb.implementation.view.windows.subcomponents;

import javax.swing.JLabel;

public class InputLabel extends JLabel {

	private static final long serialVersionUID = -2259322407081297361L;

	InputLabel(String text) {
		super(text + "    ");
		setHorizontalAlignment(JLabel.RIGHT);
	}
}
