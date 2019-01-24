package model;

public class Putnik {

	private int idVoznje;
	private String ime;
	private String prezime;
	private int starost;
	private int brojPasosa;

	
	public int getIdVoznje() {
		return idVoznje;
	}

	public void setIdVoznje(int idVoznje) {
		this.idVoznje = idVoznje;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getStarost() {
		return starost;
	}

	public void setStarost(int starost) {
		this.starost = starost;
	}

	
	public int getBrojPasosa() {
		return brojPasosa;
	}

	public void setBrojPasosa(int brojPasosa) {
		this.brojPasosa = brojPasosa;
	}

	public String toString() {
	String output = this.getIdVoznje()+","+this.getIme()+","+this.getPrezime()+","+this.getStarost()+","+this.getBrojPasosa();
	return output;
	}

	
}
