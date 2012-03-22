package com.sociorespo.dto;

public class LoginDTO {

	private String validUser = null;
	private int userId = 0;
	private String password = null;
	private String emailId = null;
	
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getValidUser() {
		return validUser;
	}

	public void setValidUser(String validUser) {
		this.validUser = validUser;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

		
	
	
	
}
