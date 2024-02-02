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
		this.setGeburtstag(geburtstag);
		this.setStandort(standort);
		this.setAnstellungstag(anstellungstag);
	}

	public String getName() {
		return name;
	}

	public String getVorname() {
		return vorname;
	}

	public Date getGeburtstag() {
		return geburtstag;
	}

	private void setGeburtstag(Date geburtstag) {
		this.geburtstag = geburtstag;

	}

	public Standort getStandort() {
		return standort;
	}

	public void setStandort(Standort standort) {
		this.standort = standort;
	}

	public Date getAnstellungstag() {
		return anstellungstag;
	}

	public void setAnstellungstag(Date anstellungstag) {
		this.anstellungstag = anstellungstag;
	}

}
