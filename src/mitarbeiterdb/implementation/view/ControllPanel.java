package mitarbeiterdb.implementation.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import mitarbeiterdb.implementation.view.popupwindows.AdvancedSearchWindow;
import mitarbeiterdb.implementation.view.popupwindows.InsertWindow;

public class ControllPanel extends JPanel {

	public ControllPanel(Table table) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));

		JButton insertButton = new JButton("Neuer Eintrag");
		insertButton.setBackground(new Color(240, 248, 255));
		insertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InsertWindow(table);
			}
		});
		add(insertButton);
		add(new SimpleSearchPanel(table));

		JButton advancedSearchButton = new JButton("Erweiterte Suche");
		advancedSearchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdvancedSearchWindow(table);
			}
		});
		add(advancedSearchButton);
		setVisible(true);

//		JButton resetButton = new JButton("Suche zurücksetzen");
//		resetButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//					table.update();
//					searchField.setText("");
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//			}
//		});
//		add(resetButton);
		setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
	}

}
