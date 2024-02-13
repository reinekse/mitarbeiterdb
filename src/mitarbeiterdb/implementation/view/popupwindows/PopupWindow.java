package mitarbeiterdb.implementation.view.popupwindows;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;

import mitarbeiterdb.contract.view.IClient;
import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.popupwindows.subcomponents.Heading;
import mitarbeiterdb.implementation.view.popupwindows.subcomponents.InputPanel;

public abstract class PopupWindow extends JDialog implements IClient {
	protected Table table;
	protected InputPanel inputPanel;
	protected Heading heading = new Heading("Eintrag: ");
	protected JPanel buttonPanel = new JPanel();

	public PopupWindow(Table table) {
		this.table = table;
		setTitle("Mitarbeiter Datenbank");
		setLayout(new BorderLayout());
		add(heading, BorderLayout.PAGE_START);
		this.inputPanel = new InputPanel(table.getType());
		add(inputPanel, BorderLayout.CENTER);
		addButtonsToButtonPanel();
		add(buttonPanel, BorderLayout.PAGE_END);
		setLocationRelativeTo(table);
		pack();
		setVisible(true);
	}

	public abstract void addButtonsToButtonPanel();

	@Override
	public Table getTable() {
		return table;
	}

	@Override
	public String getInput() {
		return this.inputPanel.getInputString();
	}

}
