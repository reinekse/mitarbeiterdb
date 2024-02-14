package mitarbeiterdb.implementation.view.windows.subcomponents;

import javax.swing.JButton;

import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.windows.AdvancedSearchWindow;
import mitarbeiterdb.implementation.view.windows.DeleteWindow;
import mitarbeiterdb.implementation.view.windows.EditWindow;
import mitarbeiterdb.implementation.view.windows.InsertWindow;

public class WindowOpenButton extends JButton {
	public WindowOpenButton(String label, WindowType type, Table table) {
		super(label);
		addActionListener(e -> {
			switch (type) {
			case INSERT:
				new InsertWindow(table);
				break;
			case ADVANCED_SEARCH:
				new AdvancedSearchWindow(table);
				break;
			case EDIT:
				new EditWindow(table);
				break;
			case DELETE:
				new DeleteWindow(table);
				break;
			default:
				break;

			}

		});
	}

}
