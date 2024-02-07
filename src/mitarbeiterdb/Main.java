package mitarbeiterdb;

import java.sql.SQLException;

import mitarbeiterdb.implementation.controller.TableModel;
import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.view.Frame;

public class Main {

	public static void main(String[] args) throws SQLException {
		var db = Connector.getInstance("jdbc:mysql://localhost/mitarbeiter?");
		db.setupDB();
		var personen = db.sendSQLQuery("SELECT * FROM personen");
		var PersonenTableModel = new TableModel(personen);
		var standorte = db.sendSQLQuery("SELECT * FROM standorte");
		var StandorteTableModel = new TableModel(standorte);
		new Frame(PersonenTableModel, StandorteTableModel);
	}

}
