package mitarbeiterdb.implementation.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.model.SQLBuilder;

public class SearchPanel extends JPanel {

	private JTextField searchField;

	public SearchPanel(Table table) {
		setLayout(new FlowLayout());

		searchField = new JTextField(20);
		searchField.setToolTipText("Suche");
		add(searchField);

		JButton searchButton = new JButton("Suchen");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					search(table);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		advancedSearchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdvancedSearchWindow(SearchPanel.this);
			}
		});
		add(advancedSearchButton);
		setVisible(true);
	}

	public void search(Table table) throws SQLException {
		var sql = new SQLBuilder().search("personen", searchField.getText());
		var selection = Connector.getInstance().sendSQLQuery(sql);
		table.update(selection);
	}

}
