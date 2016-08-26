package springass1.onlineshopping.model;

public class UserDetailsClass {
	private String username;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean authenticate(String a,String b)
	{
		if(a.equals("Dipika") && b.equals("123"))
		{
			return true;
		}
		else return false;
	}
}
