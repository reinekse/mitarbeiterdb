package mitarbeiterdb.implementation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicArrowButton;

public class Frame extends JFrame {

	public Frame() {
		JButton sortButton = new JButton("Sortiere!");
		sortButton.setBounds(50, 30, 90, 20);
		add(sortButton);

		var descAscButton2 = new BasicArrowButton(BasicArrowButton.NORTH);
		descAscButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				var initialDirection = descAscButton2.getDirection();
				if (initialDirection == BasicArrowButton.NORTH) {
					descAscButton2.setDirection(BasicArrowButton.SOUTH);
				} else {
					descAscButton2.setDirection(BasicArrowButton.NORTH);
				}
			}

		});

		descAscButton2.setBounds(140, 50, 20, 20);
		add(descAscButton2);

		String column[] = { "id", "name", "vorname", "geburtstag", "abteilung", "standort_id", "anstellungstag" };
		var columnChooser = new JComboBox(column);
		columnChooser.setBounds(50, 50, 90, 20);
		add(columnChooser);

		String data[][] = { { "101", "Amit", "670000" }, { "102", "Jai", "780000" }, { "101", "Sachin", "700000" } };
		String tablecolumn[] = { "ID", "NAME", "SALARY" };
		JTable jt = new JTable(data, tablecolumn);
		jt.setBounds(30, 120, 200, 300);
		// JScrollPane sp = new JScrollPane(jt);
		add(jt);

		setSize(400, 500);
		setLayout(null);
		setVisible(true);
	}

}
