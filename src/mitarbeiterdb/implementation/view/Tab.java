package mitarbeiterdb.implementation.view;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mitarbeiterdb.implementation.controller.TableModel;

public class Tab extends JPanel {

	Tab(TableModel model) throws SQLException {
		setLayout(new BorderLayout());
		var table = new Table(model);
		add(new ControllPanel(table), BorderLayout.PAGE_START);

		add(new JScrollPane(table), BorderLayout.CENTER);
	}

}
