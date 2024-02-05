package mitarbeiterdb.implementation.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Frame extends JFrame {

	public Frame() {

		var l = new JLabel("First Label.");
		l.setBounds(50, 100, 250, 20);
		add(l);

		final JTextField tf = new JTextField();
		tf.setBounds(50, 50, 150, 20);
		add(tf);

		JButton b = new JButton("click");// create button
		b.setBounds(130, 100, 100, 40);

		add(b);// adding button on frame
		setSize(400, 500);
		setLayout(null);
		setVisible(true);
	}

}
