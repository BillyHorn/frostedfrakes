package com.catalyst.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Models reporthistory
 * Foreign Keys - report and editingDev
 * 
 * @author mKness
 *
 * action -
 * 	0 - created
 *  1 - saved
 *  2 - submitted
 *  3 - rejected
 *  4 - approved
 */
@Entity(name="reporthistory")
public class ReportHistory {

	private Integer reportHistoryId;	
	private Report report;
	private Dev editingDev;
	private String action; 
	private Timestamp timeStamp; 
	
	/**
	 * empty constructor for autowired
	 * @author mKness
	 */
	public ReportHistory() {}
	
	/**
	 * constructor to be used by the reportHistoryFactory
	 * @param report
	 * @param editingDev
	 * @param action
	 * @param timestamp
	 * @author mKness
	 */
	public ReportHistory( Report report, Dev editingDev, String action, Timestamp timestamp) {
		this.report = report;
		this.editingDev = editingDev;
		this.action = action;
		this.timeStamp = timestamp;
	}
	
	/**
	 * @return the reportHistoryId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getReportHistoryId() {
		return reportHistoryId;
	}

	/**
	 * @param reportHistoryId the reportHistoryId to set
	 */
	public void setReportHistoryId(Integer reportHistoryId) {
		this.reportHistoryId = reportHistoryId;
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
	 * @return the editingDev
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name="devId")
	public Dev getEditingDev() {
		return editingDev;
	}

	/**
	 * @param editingDev the editingDev to set
	 */
	public void setEditingDev(Dev editingDev) {
		this.editingDev = editingDev;
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
	 * @return the timeStamp
	 */
	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * overrides objects hashCode to provide a code specific to the reportHistory
	 */
	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(31, 17);
		builder.append(reportHistoryId);
		return builder.toHashCode();
	}

	/**
	 * overrides objects equals method to provide one specific to the reportHistory
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ReportHistory)){
			return false;
		}
		ReportHistory lineItem = (ReportHistory) obj;
 
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(this.reportHistoryId, lineItem.reportHistoryId);
		return builder.isEquals();
		
	}
}
