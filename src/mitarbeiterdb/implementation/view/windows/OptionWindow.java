package mitarbeiterdb.implementation.view.windows;

import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

import mitarbeiterdb.implementation.view.Table;
import mitarbeiterdb.implementation.view.windows.subcomponents.WindowOpenButton;
import mitarbeiterdb.implementation.view.windows.subcomponents.WindowType;

public class OptionWindow extends JPopupMenu {

	private static final long serialVersionUID = -1014334368999345648L;

	public OptionWindow(Table table, MouseEvent mouseEvent) {

		// Option "Edit"
		var editButton = new WindowOpenButton("Bearbeiten", WindowType.EDIT, table);
		editButton.setBorderPainted(false);
		add(editButton);

		// Option "Delete"
		var deleteButton = new WindowOpenButton("Löschen", WindowType.DELETE, table);
		deleteButton.setBorderPainted(false);
		add(deleteButton);
		show(table, mouseEvent.getX(), mouseEvent.getY());
	}

}
