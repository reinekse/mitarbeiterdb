package mitarbeiterdb;

import java.sql.SQLException;

import com.formdev.flatlaf.FlatLightLaf;

import mitarbeiterdb.implementation.controller.TableModel;
import mitarbeiterdb.implementation.controller.TableType;
import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.view.Frame;

public class Main {

	public static void main(String[] args) {

		FlatLightLaf.setup();
		try {
			Connector.getInstance().setupDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			var personenTableModel = new TableModel(TableType.PERSONEN);
			var standorteTableModel = new TableModel(TableType.STANDORTE);
			new Frame(personenTableModel, standorteTableModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
