package mitarbeiterdb.implementation.view.windows;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;

import mitarbeiterdb.contract.controller.IObservable;
import mitarbeiterdb.implementation.controller.InputPanelFactory;
import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.windows.subcomponents.Heading;
import mitarbeiterdb.implementation.view.windows.subcomponents.InputPanel;

//-----------------------------------------------------
// Popup Window with input fields and action buttons
//-----------------------------------------------------
public abstract class Window extends JDialog implements IObservable {
	private static final long serialVersionUID = 2100327441422231343L;
	protected Table table;
	protected InputPanel inputPanel;
	protected Heading heading = new Heading("Eintrag: ");
	protected JPanel buttonPanel = new JPanel();

	public Window(Table table) {
		this.table = table;
		setTitle("Mitarbeiter Datenbank");
		setLayout(new BorderLayout());

		// heading
		add(heading, BorderLayout.PAGE_START);

		// input fields
		this.inputPanel = new InputPanelFactory().createInputPanel(table);
		add(inputPanel, BorderLayout.CENTER);

		// buttons
		addButtonsToButtonPanel();
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // some padding
		add(buttonPanel, BorderLayout.PAGE_END);

		pack();
		setLocationRelativeTo(table); // appears in front of the table
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
		inputPanel.setValuesAccordingToSelectedRow();
	}

}
