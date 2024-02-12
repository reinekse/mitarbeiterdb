package mitarbeiterdb.implementation.view.popupwindows.subcomponents;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class StandorteInput extends JPanel {

	StandorteInput() {
		setLayout(new GridLayout(0, 2, 0, 5));
		var strasseLabel = new TextFieldLabel("Straße:");
		var strasseField = new JTextField();
		add(strasseLabel);
		add(strasseField);

		var hausnummerLabel = new TextFieldLabel("Hausnummer:");
		var hausnummerField = new JTextField();
		add(hausnummerLabel);
		add(hausnummerField);

		var plzLabel = new TextFieldLabel("PLZ:");
		var plzField = new JTextField();
		add(plzLabel);
		add(plzField);

		var ortLabel = new TextFieldLabel("Ort:");
		var ortField = new JTextField();
		add(ortLabel);
		add(ortField);
	}

}
