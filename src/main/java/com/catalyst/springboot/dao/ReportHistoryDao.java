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
		return em.createQuery("SECLECT r from reporthistory r WHERE r.report.reportId = :reportId", ReportHistory.class)
					.setParameter("reportId", reportId).getResultList();
	}
}
