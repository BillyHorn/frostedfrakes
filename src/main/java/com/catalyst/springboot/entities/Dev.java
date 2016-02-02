package com.catalyst.springboot.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Models dev object
 * @author mKness
 *
 */
@Entity(name = "dev")
public class Dev {
		
	private Integer devId;
	private String email;
	private String password;
	private String role;
	private Set<Report> reports;
		
	
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
	 * @return the reports
	 */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="devId", nullable = true, insertable = false)
	public Set<Report> getReports() {
		return reports;
	}

	/**
	 * @param reports the reports to set
	 */
	public void setReports(Set<Report> reports) {
		this.reports = reports;
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
