package mitarbeiterdb.implementation.view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mitarbeiterdb.implementation.controller.TableModel;

//---------------------------------------------------
// Tab contains controll panel and scrollable table
//---------------------------------------------------
public class Tab extends JPanel {

	private static final long serialVersionUID = 6926303463198033690L;

	Tab(TableModel model) {
		setLayout(new BorderLayout());
		var table = new Table(model);
		add(new ControllPanel(table), BorderLayout.PAGE_START);
		var scrollTable = new JScrollPane(table);
		scrollTable.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
		add(scrollTable, BorderLayout.CENTER);
	}

}
