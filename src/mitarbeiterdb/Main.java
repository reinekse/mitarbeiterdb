package mitarbeiterdb;

import java.sql.SQLException;

import mitarbeiterdb.implementation.controller.TableModel;
import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.view.Frame;

public class Main {

	public static void main(String[] args) throws SQLException {
		var db = Connector.getInstance();
		db.setupDB();
		var personen = db.sendSQLQuery("SELECT * FROM personen");
		var personenTableModel = new TableModel(personen);
		var standorte = db.sendSQLQuery("SELECT * FROM standorte");
		var standorteTableModel = new TableModel(standorte);
		new Frame(personenTableModel, standorteTableModel);
	}

}
