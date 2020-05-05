package com.qa.hubspor.util;

public class CredentialsUtil {
	
	String appUsername;
	String appPassword;
	
	public CredentialsUtil(String appUsername,String appPassword) {
		this.appUsername = appUsername;
		this.appPassword = appPassword;		
	}
	
	//Getter and Setter for username and password
	
    public String getAppUsername() {
    	return appUsername;
    }
	public String getAppPassword() {
		return appPassword;
	}

	public void setAppPassword(String appPassword) {
		this.appPassword = appPassword;
	}

	public void setAppUsername(String appUsername) {
		this.appUsername = appUsername;
	}

}
