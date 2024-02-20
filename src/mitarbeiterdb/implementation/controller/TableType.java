package mitarbeiterdb.implementation.controller;

public enum TableType {
	PERSONEN {
		@Override
		public String toString() { // actually not needed when same name as in DB (sql is not case sensitive)
			return "personen";
		}
	},
	STANDORTE {
		@Override
		public String toString() { // actually not needed when same name as in DB (sql is not case sensitive)
			return "standorte";
		}
	}

}
