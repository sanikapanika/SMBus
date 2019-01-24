package model;

public class sensorInfo {
	
	private int id;
	private String prtljaznik;
	private String motor;
	private String kabina;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrtljaznik() {
		return prtljaznik;
	}
	public void setPrtljaznik(String prtljaznik) {
		this.prtljaznik = prtljaznik;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public String getKabina() {
		return kabina;
	}
	public void setKabina(String kabina) {
		this.kabina = kabina;
	}
	
	public String toString() {
		/* Implement toString method for this class */
		String output = this.getId() + "," + this.getPrtljaznik() + ","
				+ this.getMotor() + "," + this.getKabina() + ",";
		return output;
	}

}
