package com.catalyst.springboot.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * an image associated with a line item
 * @author mKness
 *
 */
@Entity
public class Receipt {

	
	private Integer receiptId;
	private LineItem lineItem;
	private String images;
	
	
	/**
	 * @return the reciptId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getReciptId() {
		return receiptId;
	}
	/**
	 * @param reciptId the reciptId to set
	 */
	public void setReciptId(Integer reciptId) {
		this.receiptId = reciptId;
	}
	/**
	 * @return the lineItem
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="lineItemId")
	public LineItem getLineItem() {
		return lineItem;
	}
	/**
	 * @param lineItemId the lineItem to set
	 */
	public void setLineItem(LineItem lineItem) {
		this.lineItem = lineItem;
	}
	/**
	 * @return the images
	 */
	public String getImages() {
		return images;
	}
	/**
	 * @param images the images to set
	 */
	public void setImages(String images) {
		this.images = images;
	}
	
	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(31, 17);
		builder.append(receiptId);
		return builder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Receipt)){
			return false;
		}
		Receipt receipt = (Receipt) obj;
 
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(this.receiptId, receipt.receiptId);
		return builder.isEquals();
		
	}
}
