package com.catalyst.springboot.selenium.modal;

public class InputbeanList {

	String SNO;
	String UserName;
	String Password;
	String verifyPassword;
	String scenarioname;
	

	/**
	 * @return the verifyPassword
	 */
	public String getVerifyPassword() {
		return verifyPassword;
	}
	/**
	 * @param verifyPassword the verifyPassword to set
	 */
	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}
	
	public void setSNO(String SNO) {
		this.SNO = SNO;
	}
	public String getSNO() {
		return SNO;
	}
	public void setScenarioname(String scenarioname) {
		this.scenarioname = scenarioname;
	}
	public String getScenarioname() {
		return scenarioname;
	}
	public void setUsername(String Username) {
		this.UserName = Username;
	}
	public String getUsername() {
		return UserName;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public String getPassword() {
		return Password;
	}

}