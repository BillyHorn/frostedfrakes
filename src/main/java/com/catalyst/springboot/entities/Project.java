package com.catalyst.springboot.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Models a project
 * foriegn key of userId for tech lead
 * join table with user for list of devs
 * @author mKness
 *
 */
@Entity
public class Project {

	
	private Integer projectId;
	private String name;
	private Dev techLeadId;
	private Set<Dev> devs;
	private Set<Report> reports;
	
	
	/**
	 * @return the projectId
	 */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Integer getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the techLeadId
	 */
	@OneToOne
	@JoinColumn(name="techleadId")
	public Dev getTechLeadId() {
		return techLeadId;
	}
	/**
	 * @param techLeadId the techLeadId to set
	 */
	public void setTechLeadId(Dev techLeadId) {
		this.techLeadId = techLeadId;
	}
	/**
	 * @return the users
	 */
	@ManyToMany
	@JoinTable(name="projectuser", joinColumns = {
			@JoinColumn(name="projectId", nullable=false) },
			inverseJoinColumns = { @JoinColumn(name = "userId", 
					nullable = false)})
	public Set<Dev> getUsers() {
		return devs;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<Dev> devs) {
		this.devs = devs;
	}
	
	/**
	 * @return the reports
	 */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="project")
	public Set<Report> getReports() {
		return reports;
	}
	/**
	 * @param reports the reports to set
	 */
	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}
	
	/**
	 * overrides objects hashCode to provide a code specific to the projectId
	 */
	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(31, 17);
		builder.append(projectId);
		return builder.toHashCode();
	}

	/**
	 * overrides objects equals to provide one specific to project
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Project)){
			return false;
		}
		Project project = (Project) obj;
 
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(this.projectId, project.projectId);
		return builder.isEquals();
		
	}
}
