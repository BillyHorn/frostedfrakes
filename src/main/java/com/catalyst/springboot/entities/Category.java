package com.catalyst.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * table to contain the list of categories a lineitem can have
 * @author mKness
 *
 */
@Entity(name = "category")
public class Category {

	
	private Integer categoryId;
	private String value;
	
	
	/**
	 * @return the categoryId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * overrides objects hashCode function to provide one specific to category
	 */
	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(31, 17);
		builder.append(categoryId);
		return builder.toHashCode();
	}

	/**
	 * overrides objects equals function to provide one specific to category
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Category)){
			return false;
		}
		Category category = (Category) obj;
 
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(this.categoryId, category.categoryId);
		return builder.isEquals();
		
	}
}
