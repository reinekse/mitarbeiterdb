package mitarbeiterdb.implementation.view.windows.subcomponents;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class StandorteInputPanel extends InputPanel {

	private static final long serialVersionUID = 2431465125410667545L;

	public StandorteInputPanel() {
		labels = "Straße,Hausnr.,PLZ,Ort".split(",");
		fields = new ArrayList<JComponent>();

		// Straße
		fields.add(new JTextField());

		// Hausnr.
		fields.add(new JTextField());

		// PLZ
		fields.add(new JTextField());

		// Ort
		fields.add(new JTextField());

		addComponents();
	}

}
