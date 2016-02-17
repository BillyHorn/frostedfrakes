package com.catalyst.springboot.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private Date date;
	private Double value;
	private Category category;
	private Report report;
	
	
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
	public Double getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Double value) {
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
	 * @return the report
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name="reportId")
	public Report getReport() {
		return report;
	}
	/**
	 * @param report the report to set
	 */
	public void setReport(Report report) {
		this.report = report;
	}
	
	/**
	 * overrides objects hashCode to provide a code specific to the lineItemId
	 */
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
	
	/**
	 * overrides objects toString method for error logging
	 */
	@Override
	public String toString() {
		String rtn = "ID: " + lineItemId + 
					"  Date:  " + date + 
					"  Value: " + value +
					"  Category: " + category +
					"  ReportId: " + report.getReportId();
				
		return rtn;
	}
}
