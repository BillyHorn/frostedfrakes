package com.catalyst.springboot.entities;

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer receiptId;
	@ManyToOne
	@JoinColumn(name="lineItemId")
	private String lineItemId;
	private String images;
	
	
	/**
	 * @return the reciptId
	 */
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
	 * @return the lineItemId
	 */
	public String getLineItemId() {
		return lineItemId;
	}
	/**
	 * @param lineItemId the lineItemId to set
	 */
	public void setLineItemId(String lineItemId) {
		this.lineItemId = lineItemId;
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
