package mitarbeiterdb.implementation.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.model.SQLBuilder;
import mitarbeiterdb.implementation.view.popupwindows.AdvancedSearchWindow;
import mitarbeiterdb.implementation.view.popupwindows.InsertWindow;

public class ControllPanel extends JPanel {

	private JTextField searchField;

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
		searchField = new JTextField(5);
		searchField.setToolTipText("Suche");
		add(searchField);

		JButton searchButton = new JButton("Suchen");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					search(table);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		var searchPanel = new JPanel();
		searchPanel.add(searchField);
		searchPanel.add(searchButton);
		add(searchPanel);

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
				new AdvancedSearchWindow(table);
			}
		});
		add(advancedSearchButton);
		setVisible(true);

		JButton resetButton = new JButton("Suche zurücksetzen");
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					table.update();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(resetButton);
		setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
	}

	public void search(Table table) throws SQLException {
		var sql = new SQLBuilder().search(table.getType(), searchField.getText());
		var selection = Connector.getInstance().sendSQLQuery(sql);
		table.update(selection);
	}

}
