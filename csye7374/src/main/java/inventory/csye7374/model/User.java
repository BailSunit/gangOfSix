package inventory.csye7374.model;

public class User {
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User() {}
	
	String username;
	String password;
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
	
}
