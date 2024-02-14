package mitarbeiterdb.implementation.view.windows.subcomponents;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Heading extends JLabel {
	public Heading(String text) {
		super(text);
		setHorizontalAlignment(JLabel.CENTER);
		Font font = new Font("Arial", Font.BOLD, 15);
		setFont(font);
		setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
	}

}
