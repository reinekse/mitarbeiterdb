package mitarbeiterdb.implementation.view.popupwindows.subcomponents;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class StandorteInput_OLD extends JPanel {

	StandorteInput_OLD() {
		setLayout(new GridLayout(0, 2, 0, 5));
		var strasseLabel = new InputLabel("Straße:");
		var strasseField = new JTextField();
		add(strasseLabel);
		add(strasseField);

		var hausnummerLabel = new InputLabel("Hausnummer:");
		var hausnummerField = new JTextField();
		add(hausnummerLabel);
		add(hausnummerField);

		var plzLabel = new InputLabel("PLZ:");
		var plzField = new JTextField();
		add(plzLabel);
		add(plzField);

		var ortLabel = new InputLabel("Ort:");
		var ortField = new JTextField();
		add(ortLabel);
		add(ortField);
	}

}
