package com.training.bean;

public class LoginBean {
	//private String userName;
	//private String password;
	private String FirstName;
	private String LastName;
	private String email_id;
	private String userName;

	public LoginBean() {
	}

	public LoginBean(String FirstName, String LastName, String email_id, String userName ) {
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.email_id = email_id;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	/*@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", password=" + password + "]";
	}*/

}
