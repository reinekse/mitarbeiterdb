package mitarbeiterdb.implementation.view.popupwindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import mitarbeiterdb.implementation.view.Table;

public class OptionWindow extends JPopupMenu {
	public OptionWindow(Table table, MouseEvent mouseEvent) {

		// Option "Edit"
		JMenuItem editItem = new JMenuItem("Bearbeiten");
		editItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditWindow(table);
			}
		});
		add(editItem);

		// Option "Delete"
		JMenuItem deleteItem = new JMenuItem("Löschen");
		deleteItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteWindow(table);
			}
		});
		add(deleteItem);
		show(table, mouseEvent.getX(), mouseEvent.getY());

	}

}
