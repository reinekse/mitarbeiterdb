package mitarbeiterdb.implementation.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchPanel extends JPanel {

	private JTextField searchField;

	public SearchPanel() {
		setLayout(new FlowLayout());

		searchField = new JTextField(20);
		searchField.setToolTipText("Suche");
		add(searchField);

		JButton searchButton = new JButton("Suchen");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String searchText = searchField.getText();
				System.out.println("Suchbegriff: " + searchText);
			}
		});
		add(searchButton);

		// Press Enter instead of Search Button
		searchField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchButton.doClick();
			}
		});

		JButton advancedSearchButton = new JButton("Erweiterte Suche");
		add(advancedSearchButton);
		setVisible(true);
	}

}
