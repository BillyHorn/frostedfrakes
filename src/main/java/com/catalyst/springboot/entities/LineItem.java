package com.catalyst.springboot.entities;

import java.sql.Date;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;

import javax.persistence.OneToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Models line item
 * Foreign keys - report and category
 * @author mKness
 *
 */
@Entity(name = "lineitem")
public class LineItem {
	
	
	private Integer lineItemId;
	private Report report;
	private Date date;

	private Integer value;
	private Category category;
	private Set<Receipt> receipts;

	
	/**
	 * @return the lineItemId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getLineItemId() {
		return lineItemId;
	}
	/**
	 * @param lineItemId the lineItemId to set
	 */
	public void setLineItemId(Integer lineItemId) {
		this.lineItemId = lineItemId;
	}
	/**
	 * @return the reportId
	 */
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="reportId")
	public Report getReport() {
		return report;
	}
	/**
	 * @param reportId the reportId to set
	 */
	public void setReport(Report report) {
		this.report = report;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;
	}
	/**
	 * @return the category
	 */
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="categoryId")
	public Category getCategory() {

		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	/**
	 * @return the receipts
	 */
	@OneToMany(cascade=CascadeType.MERGE, mappedBy="lineItem")
	public Set<Receipt> getReceipts() {
		return receipts;
	}
	/**
	 * @param receipts the receipts to set
	 */
	public void setReceipts(Set<Receipt> receipts) {
		this.receipts = receipts;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(31, 17);
		builder.append(lineItemId);
		return builder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof LineItem)){
			return false;
		}
		LineItem lineItem = (LineItem) obj;
 
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(this.lineItemId, lineItem.lineItemId);
		return builder.isEquals();
		
	}

}
