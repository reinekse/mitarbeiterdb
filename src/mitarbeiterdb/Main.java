package mitarbeiterdb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.formdev.flatlaf.FlatLightLaf;

import mitarbeiterdb.implementation.controller.TableModel;
import mitarbeiterdb.implementation.controller.TableType;
import mitarbeiterdb.implementation.model.Connector;
import mitarbeiterdb.implementation.view.Frame;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		FlatLightLaf.setup(); // improve 'Look & Feel'
		logger.info("\nStart der Anwendung.\n");
		Connector.getInstance().setupDB();
		var personenTableModel = new TableModel(TableType.PERSONEN);
		var standorteTableModel = new TableModel(TableType.STANDORTE);
		new Frame(personenTableModel, standorteTableModel);

	}

}
