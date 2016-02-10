package com.catalyst.springboot.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.entities.ReportHistory;

/**
 * Communicates with the database concerning report history
 * @author mKness
 *
 */
@Transactional
@Component
public class ReportHistoryDao {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * simple setter for the Entity Manager
	 * 
	 * @param em
	 * @author mKness
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

	/**
	 * querys the database to get the list of report histories corresponding to given reportId
	 * 
	 * @param reportId
	 * @return
	 */
	public List<ReportHistory> getReportHistory(Integer reportId) {
		return em.createQuery("SELECT r from reporthistory r WHERE r.report.reportId = :reportId", ReportHistory.class)
					.setParameter("reportId", reportId).getResultList();
	}

	/**
	 * add an entry in report history for the creation of the given report
	 * 		
	 * @param rtnReport the report being logged
	 * @author mKness
	 */
	public void createLog(ReportHistory reportHistory) {	
		em.persist(reportHistory);
		em.flush();
	}

	/**
	 * add an entry in report history for an edit of the given report
	 * 
	 * @param reportHistory
	 * @author mKness
	 */
	public void updateLog(ReportHistory reportHistory) {
		em.persist(reportHistory);
		em.flush();
	}
	
	
}
