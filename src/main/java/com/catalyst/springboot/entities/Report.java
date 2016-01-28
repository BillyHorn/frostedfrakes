package com.catalyst.springboot.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * models a report filled with line items
 * has one user and one report associated with it
 * @author mKness
 *
 */
@Entity
public class Report {

	
	private Integer reportId;
	private Set<LineItem> lineItems;
	private Dev dev;
	private String notes;
	private String rejectionNotes;
	private String state;
	
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
	 * @return the lineItems
	 */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="report")
	public Set<LineItem> getLineItems() {
		return lineItems;
	}
	/**
	 * @param lineItems the lineItems to set
	 */
	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	/**
	 * @return the userId
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	public Dev getDev() {
		return dev;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setDev(Dev dev) {
		this.dev = dev;
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
