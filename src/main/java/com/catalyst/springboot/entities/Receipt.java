package com.catalyst.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.catalyst.springboot.services.LineItemService;

/**
 * an image associated with a line item
 * @author mKness
 *
 */
@Entity
public class Receipt {

	private Integer receiptId;
	private String name;
	private byte[] image;
	private LineItem lineItem;
	
	/**
	 * this constructor is used by the Receipt Service to build a receipt out
	 * of its requisite peices.
	 * 
	 * @param byteArray the associated image
	 * @param receiptName the associated name
	 * @param lineItem the associated lineitem
	 */
	public Receipt(byte[] byteArray, String receiptName, LineItem lineItem) {
		this.name = receiptName;
		this.lineItem = lineItem;
		this.image = byteArray;
	}
	
	public Receipt(){
		
	}
	
	/**
	 * @return the receiptId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getReceiptId() {
		return receiptId;
	}
	/**
	 * @param receiptId the receiptId to set
	 */
	public void setReceiptId(Integer receiptId) {
		this.receiptId = receiptId;
	}
	
	/**
	 * @return the lineItem
	 * (optional = false)
	 */
	@ManyToOne
	@JoinColumn(name="lineItemId")
	public LineItem getLineItem() {
		return lineItem;
	}
	/**
	 * @param lineItem the lineItem to set
	 */
	public void setLineItem(LineItem lineItem) {
		this.lineItem = lineItem;
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
	
	/**
	 * 
	 * @return byte array containing image data
	 */
	@Lob
	public byte[] getImage() {
		return image;
	}
	
	/**
	 * 
	 * @param image image to be set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	/**
	 * 
	 * @return name of receipt
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name name to be set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
