package mitarbeiterdb.implementation.view.windows;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;

import mitarbeiterdb.contract.controller.IObservable;
import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.windows.subcomponents.Heading;
import mitarbeiterdb.implementation.view.windows.subcomponents.InputPanel;

public abstract class Window extends JDialog implements IObservable {
	protected Table table;
	protected InputPanel inputPanel;
	protected Heading heading = new Heading("Eintrag: ");
	protected JPanel buttonPanel = new JPanel();

	public Window(Table table) {
		this.table = table;
		setTitle("Mitarbeiter Datenbank");
		setLayout(new BorderLayout());
		add(heading, BorderLayout.PAGE_START);
		this.inputPanel = new InputPanel(table.getType());
		add(inputPanel, BorderLayout.CENTER);
		addButtonsToButtonPanel();
		add(buttonPanel, BorderLayout.PAGE_END);
		pack();
		setLocationRelativeTo(table);
		setVisible(true);
	}

	public abstract void addButtonsToButtonPanel();

	@Override
	public Table getTable() {
		return table;
	}

	@Override
	public String getInput() {
		return inputPanel.getInputString();
	}

	@Override
	public void resetInput() {
		inputPanel.setTextAccordingToSelectedRow(table);
	}

}
