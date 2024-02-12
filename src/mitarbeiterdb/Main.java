package mitarbeiterdb;

import java.sql.SQLException;

import com.formdev.flatlaf.FlatLightLaf;

import mitarbeiterdb.implementation.controller.TableModel;
import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.model.SQLBuilder;
import mitarbeiterdb.implementation.view.Frame;

public class Main {

	public static void main(String[] args) throws SQLException {

		FlatLightLaf.setup();
		var db = Connector.getInstance();
		db.setupDB();
		var sql = new SQLBuilder();
		var personen = db.sendSQLQuery(sql.selectAll("personen"));
		var personenTableModel = new TableModel(personen);
		var standorte = db.sendSQLQuery(sql.selectAll("standorte"));
		var standorteTableModel = new TableModel(standorte);
		new Frame(personenTableModel, standorteTableModel);
	}

}
