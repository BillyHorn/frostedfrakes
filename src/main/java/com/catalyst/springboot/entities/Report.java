package com.catalyst.springboot.entities;

import java.util.Set;

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reportId;
	@OneToMany(mappedBy="report")
	private Set<LineItem> lineItems;
	@ManyToOne
	@JoinColumn(name="userId")
	private Integer userId;
	private String notes;
	private String rejectionNotes;
	private String state;
	
	/**
	 * @return the reportId
	 */
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
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
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
