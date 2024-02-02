package mitarbeiterdb.implementation;

public class Standort {
	private String strasse;
	private String hausnummer;
	private String plz;
	private String ort;

	Standort(String strasse, String hausnummer, String plz, String ort) {
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
	}

}
