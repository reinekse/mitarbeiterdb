package mitarbeiterdb.implementation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mitarbeiterdb.contract.view.IClient;
import mitarbeiterdb.implementation.controller.Observer;

public class SimpleSearchPanel extends JPanel implements IClient {
	private JTextField searchField;
	private Table table;

	public SimpleSearchPanel(Table table) {
		this.table = table;
		searchField = new JTextField(5);
		searchField.setToolTipText("Suche");
		add(searchField);

		JButton searchButton = new JButton("Suchen");
		searchButton.addActionListener(new Observer(this));

		// Press Enter instead of Search Button
		searchField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchButton.doClick();
			}
		});
		add(searchField);
		add(searchButton);
	}

	@Override
	public Table getTable() {
		return table;
	}

	@Override
	public String getInput() {
		return searchField.getText();
	}

	public void resetInput() {
		searchField.setText("");
	}
}
