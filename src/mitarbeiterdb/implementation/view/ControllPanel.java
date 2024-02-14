package mitarbeiterdb.implementation.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mitarbeiterdb.contract.controller.IObservable;
import mitarbeiterdb.implementation.controller.ButtonPurpose;
import mitarbeiterdb.implementation.controller.Observer;
import mitarbeiterdb.implementation.view.windows.subcomponents.WindowOpenButton;
import mitarbeiterdb.implementation.view.windows.subcomponents.WindowType;

public class ControllPanel extends JPanel implements IObservable {
	private Table table;
	private JTextField searchField;

	public ControllPanel(Table table) {
		this.table = table;
		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
		createInsertButton();
		createSimpleSearchPanel();
		createAdvancedSearchButton();
		createResetButton();
		setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
	}

	private void createInsertButton() {
		var insertButton = new WindowOpenButton("Neuer Eintrag", WindowType.INSERT, table); // TODO
		insertButton.setBackground(new Color(240, 248, 255));
		add(insertButton);

	}

	private void createSimpleSearchPanel() {
		var simpleSearchPanel = new JPanel();
		searchField = new JTextField(5);
		searchField.setToolTipText("Suche");
		simpleSearchPanel.add(searchField);

		var searchButton = new JButton("Suchen");
		searchButton.addActionListener(new Observer(ButtonPurpose.SIMPLE_SEARCH, this));
		simpleSearchPanel.add(searchButton);

		// Press Enter instead of Search Button
		searchField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchButton.doClick();
			}
		});

		add(simpleSearchPanel);

	}

	private void createAdvancedSearchButton() {
		var advancedSearchButton = new WindowOpenButton("Erweiterte Suche", WindowType.ADVANCED_SEARCH, table);
		add(advancedSearchButton);
	}

	private void createResetButton() {
		var resetButton = new JButton("Suche zurücksetzen");
		resetButton.addActionListener(new Observer(ButtonPurpose.RESET, this));
		add(resetButton);

	}

	@Override
	public Table getTable() {
		return table;
	}

	@Override
	public String getInput() {
		return searchField.getText();
	}

	@Override
	public void resetInput() {
		searchField.setText("");
	}

}
