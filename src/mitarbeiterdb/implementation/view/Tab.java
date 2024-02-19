package mitarbeiterdb.implementation.view;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mitarbeiterdb.implementation.controller.TableModel;

public class Tab extends JPanel {

	private static final long serialVersionUID = 6926303463198033690L;

	Tab(TableModel model) throws SQLException {
		setLayout(new BorderLayout());
		var table = new Table(model);
		add(new ControllPanel(table), BorderLayout.PAGE_START);
		var scrollTable = new JScrollPane(table);
		scrollTable.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
		add(scrollTable, BorderLayout.CENTER);
	}

}
