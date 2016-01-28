package com.catalyst.springboot.entities;

public class Report {
	
	private String name;
	private String notes;
//	private LineItem[] items;
	private String rejectionNotes;
	private boolean rejected;
	private boolean submitted;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the items
	 */
//	public LineItem[] getItems() {
//		return items;
//	}
	
	/**
	 * @param items the items to set
	 */
//	public void setItems(LineItem[] items) {
//		this.items = items;
//	}
	
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
	 * @return the rejected
	 */
	public boolean isRejected() {
		return rejected;
	}
	
	/**
	 * @param rejected the rejected to set
	 */
	public void setRejected(boolean rejected) {
		this.rejected = rejected;
	}
	
	/**
	 * @return the submitted
	 */
	public boolean isSubmitted() {
		return submitted;
	}
	
	/**
	 * @param submitted the submitted to set
	 */
	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}
	
}
