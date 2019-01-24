package model;

public class log {
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		/* Implement toString method for this class */
		String output = this.getUsername()+","+this.getPassword();
		return output;
	}
}
