package model;

public class Voznja {
	private int id;
	private String polaziste;
	private String odrediste;
	private String trajanjePutovanja;
	private String prevoznik;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPolaziste() {
		return polaziste;
	}

	public void setPolaziste(String polaziste) {
		this.polaziste = polaziste;
	}

	public String getOdrediste() {
		return odrediste;
	}

	public void setOdrediste(String odrediste) {
		this.odrediste = odrediste;
	}

	public String getTrajanjePutovanja() {
		return trajanjePutovanja;
	}

	public void setTrajanjePutovanja(String trajanjePutovanja) {
		this.trajanjePutovanja = trajanjePutovanja;
	}

	public String getPrevoznik() {
		return prevoznik;
	}

	public void setPrevoznik(String prevoznik) {
		this.prevoznik = prevoznik;
	}

	public String toString() {
		/* Implement toString method for this class */
		String output = "Polazak: " + this.getPolaziste() + " Odrediste:"
				+ this.getOdrediste() + " Trajanje voznje:"
				+ this.getTrajanjePutovanja() + " Prevoznik:"
				+ this.getPrevoznik() + "/n";

		return output;
	}

}
