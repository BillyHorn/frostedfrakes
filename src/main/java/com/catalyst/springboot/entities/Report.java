package com.catalyst.springboot.entities;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * models a report filled with line items
 * has one user and one report associated with it
 * @author mKness
 *
 */
@Entity(name = "Report")
public class Report { 

	private Integer reportId;
	private String name;
	private String notes;
	private Dev dev;
	private Project project;
	private String rejectionNotes;
	private String state; /* SAVED: 1, SUBMITTED: 2, REJECTED: 3, APPROVED: 4 */
	private Timestamp timestamp;
	
	
	/**
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the reportId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getReportId() {
		return reportId;
	}
	
	/**
	 * @param reportId the reportId to set
	 */
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	
	/**
	 * @return the dev
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name="devId")
	public Dev getDev() {
		return dev;
	}
	/**
	 * @param dev the dev to set
	 */
	public void setDev(Dev dev) {
		this.dev = dev;
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
	 * @return the project
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name="projectId")
	public Project getProject() {
		return project;
	}
	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	/**
	 * @return the rejectionNotes
	 */
	public String getRejectionNotes() {
		return rejectionNotes;
	}

	
	/**
	 * @param rejectionNotes the rejectionNotes to set
	 */
	public void setRejectionNotes(String rejectionNotes) {
		this.rejectionNotes = rejectionNotes;
	}

	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}


	/**
	 * overrides objects hashCode to provide a code specific to the reportId
	 */
	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(31, 17);
		builder.append(reportId);
		return builder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Report)){
			return false;
		}
		Report report = (Report) obj;
 
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(this.reportId, report.reportId);
		return builder.isEquals();
		
	}
}
