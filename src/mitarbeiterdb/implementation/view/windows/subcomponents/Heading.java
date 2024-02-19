package mitarbeiterdb.implementation.view.windows.subcomponents;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

//----------------------------
// heading for popup windows
//----------------------------
public class Heading extends JLabel {

	private static final long serialVersionUID = -7557826603662802918L;

	public Heading(String text) {
		super(text);
		setHorizontalAlignment(JLabel.CENTER);
		Font font = new Font("Arial", Font.BOLD, 15);
		setFont(font);
		setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
	}

}
