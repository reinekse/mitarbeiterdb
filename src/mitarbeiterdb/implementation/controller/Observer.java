package mitarbeiterdb.implementation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mitarbeiterdb.contract.controller.IObservable;
import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.model.SQLBuilder;
import mitarbeiterdb.implementation.view.Table;

//-------------------------------------------------------
// This class listens, whether any buttons where clicked
// that should cause some kind of DB interaction
//------------------------------------------------------
public class Observer implements ActionListener {
	private static final Logger logger = LogManager.getLogger(Observer.class);
	private ButtonPurpose purpose;
	private IObservable observable;
	private Table table;
	private String sql;

	public Observer(ButtonPurpose purpose, IObservable observable) {
		this.purpose = purpose;
		this.observable = observable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.table = observable.getTable();
		var input = observable.getInput();

		// create sql statement and add logger info
		switch (purpose) {
		case DELETE:
			logger.info("\nLöschen des gewählten Datenbankeintrags:\n");
			sql = new SQLBuilder().delete(table.getType(), table.getSelectedID());
			break;
		case INSERT:
			logger.info("\nHinzufügen eines neuen Datenbankeintrags:\n");
			sql = new SQLBuilder().insert(table.getType(), input);
			break;
		case EDIT:
			logger.info("\nÄnderung des gewählten Datenbankeintrags:\n");
			sql = new SQLBuilder().update(table.getType(), table.getSelectedID(), input);
			break;
		case SIMPLE_SEARCH:
			logger.info("\nEinfache Suche eines Datenbankeintrags:\n");
			sql = new SQLBuilder().simpleSearch(table.getType(), input);
			break;
		case ADVANCED_SEARCH:
			logger.info("\nErweiterte Suche eines Datenbankeintrags:\n");
			sql = new SQLBuilder().advancedSearch(table.getType(), input);
			break;
		case RESET:
			observable.resetInput();
		default:
			break;
		}

		List<List<String>> data = null;

		if (sql != null) { // there's no sql for RESET!
			data = Connector.getInstance().sendSQLQuery(sql);
		}
		updateTable(data);
	}

	public void updateTable(List<List<String>> data) {
		var tableModel = (TableModel) table.getModel();
		if (data == null) { // no new data? Just get original data from DB!
			var sql = new SQLBuilder().selectAll(table.getType());
			data = Connector.getInstance().sendSQLQuery(sql);
		}
		tableModel.setData(data); // update table model
		tableModel.fireTableDataChanged(); // update table
	}

}
