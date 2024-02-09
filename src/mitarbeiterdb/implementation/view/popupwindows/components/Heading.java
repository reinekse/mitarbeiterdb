package mitarbeiterdb.implementation.view.popupwindows.components;

import java.awt.Font;

import javax.swing.JLabel;

public class Heading extends JLabel {
	public Heading(String text) {
		super(text);
		setHorizontalAlignment(JLabel.CENTER);
		Font font = new Font("Arial", Font.BOLD, 15);
		setFont(font);
	}

}
