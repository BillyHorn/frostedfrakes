package com.catalyst.springboot.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Entity
public class LineItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lineItemId;
	@ManyToOne
	@JoinColumn(name="reportId")
	private Integer reportId;
	private Date date;
	@OneToOne(fetch = FetchType.LAZY, mappedBy="lineitem", cascade = CascadeType.ALL)
	private Categories category;
	
	/**
	 * @return the lineItemId
	 */
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
	 * @return the category
	 */
	public Categories getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Categories category) {
		this.category = category;
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
