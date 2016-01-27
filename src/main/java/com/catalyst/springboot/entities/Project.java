package com.catalyst.springboot.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer projectId;
	private String name;
	@OneToOne
	@JoinColumn(name="userId")
	private String techLeadId;
	@ManyToMany
	@JoinTable(name="projectuser", joinColumns = {
			@JoinColumn(name="projectId", nullable=false) },
			inverseJoinColumns = { @JoinColumn(name = "userId", 
					nullable = false)})
	private Set<User> users;
	
	
	/**
	 * @return the projectId
	 */
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
	public String getTechLeadId() {
		return techLeadId;
	}
	/**
	 * @param techLeadId the techLeadId to set
	 */
	public void setTechLeadId(String techLeadId) {
		this.techLeadId = techLeadId;
	}
	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(31, 17);
		builder.append(projectId);
		return builder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof User)){
			return false;
		}
		Project project = (Project) obj;
 
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(this.projectId, project.projectId);
		return builder.isEquals();
		
	}
}
