package mitarbeiterdb.implementation;

import java.util.Date;

public class Person {

	private String name;
	private String vorname;
	private Date geburtstag;
	private Standort standort;
	private Date anstellungstag;

	Person(String name, String vorname, Date geburtstag, Standort standort, Date anstellungstag) {
		this.name = name;
		this.vorname = vorname;
		this.geburtstag = geburtstag;
		this.standort = standort;
		this.anstellungstag = anstellungstag;
	}

	public String getName() {
		return name;
	}

}
