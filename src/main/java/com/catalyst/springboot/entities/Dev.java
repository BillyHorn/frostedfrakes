package com.catalyst.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Models dev object
 * @author mKness
 *
 */

@Entity(name="dev")

public class Dev {
		
	private Integer devId;
	private String email;
	private String password;
	private String role;
	private Boolean isactive;
	private Long loginTime;
	private String authCode;
	private Boolean isvalid;
		
	
	/**
	 * @return the DevId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getdevId() {
		return devId;
	}

	/**
	 * @param DevId the DevId to set
	 */
	public void setDevId(Integer devId) {
		this.devId = devId;
	}

	/**
	 * @return the isactive
	 */
	public Boolean getIsactive() {
		return isactive;
	}

	/**
	 * @param isactive the isactive to set
	 */
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the loginTime
	 */
	public Long getLoginTime() {
		return loginTime;
	}

	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}
	

	/**
	 * @return the authCode
	 */
	public String getAuthCode() {
		return authCode;
	}

	/**
	 * @param authCode the authCode to set
	 */
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	/**
	 * @return the isvalid
	 */
	public Boolean getIsvalid() {
		return isvalid;
	}

	/**
	 * @param isvalid the isvalid to set
	 */
	public void setIsvalid(Boolean isvalid) {
		this.isvalid = isvalid;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(31, 17);
		builder.append(devId);
		return builder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Dev)){
			return false;
		}
		Dev Dev = (Dev) obj;
 
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(this.devId, Dev.devId);
		return builder.isEquals();
		
	}

}
