package com.catalyst.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * table contains the list of actions that can be taken on a report
 * @author mKness
 *
 */
@Entity(name="action")
public class Action {

	private Integer actionId;
	private String action;
	
	/**
	 * @return the actionId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getActionId() {
		return actionId;
	}
	/**
	 * @param actionId the actionId to set
	 */
	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * overrides objects hashCode function to provide one specific to action
	 */
	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(31, 17);
		builder.append(actionId);
		return builder.toHashCode();
	}

	/**
	 * overrides objects equals function to provide one specific to action
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Action)){
			return false;
		}
		Action category = (Action) obj;
 
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(this.actionId, category.actionId);
		return builder.isEquals();
		
	}
}
