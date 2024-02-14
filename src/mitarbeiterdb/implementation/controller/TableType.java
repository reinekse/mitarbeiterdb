package mitarbeiterdb.implementation.controller;

public enum TableType {
	PERSONEN {
		@Override
		public String toString() {
			return "personen";
		}
	},
	STANDORTE {
		@Override
		public String toString() {
			return "standorte";
		}
	}

}
