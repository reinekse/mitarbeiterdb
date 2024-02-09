package mitarbeiterdb.implementation.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.model.SQLBuilder;
import mitarbeiterdb.implementation.view.popupwindows.AdvancedSearchWindow;
import mitarbeiterdb.implementation.view.popupwindows.InsertWindow;

public class ControllPanel extends JPanel {

	private JTextField searchField;

	public ControllPanel(Table table) {
		setLayout(new FlowLayout());

		JButton insertButton = new JButton("Neuer Eintrag");
		insertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InsertWindow(table);
			}
		});
		add(insertButton);

		var padding = new JLabel("                                       ");
		add(padding); // TODO: better solution?

		searchField = new JTextField(10);
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
		padding = new JLabel("   ");
		add(padding);

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
				new AdvancedSearchWindow(ControllPanel.this);
			}
		});
		add(advancedSearchButton);
		setVisible(true);

		add(padding);

		JButton resetButton = new JButton("Zurücksetzen");
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					table.update();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add(resetButton);
	}

	public void search(Table table) throws SQLException {
		var sql = new SQLBuilder().search("personen", searchField.getText());
		var selection = Connector.getInstance().sendSQLQuery(sql);
		table.update(selection);
	}

}
