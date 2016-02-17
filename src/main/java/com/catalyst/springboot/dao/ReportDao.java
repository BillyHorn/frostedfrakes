package com.catalyst.springboot.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import com.catalyst.springboot.entities.Report;

@Transactional
@Component
public class ReportDao {

	@PersistenceContext
	private EntityManager em;
	
	

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Report addReport(Report report) {
		em.persist(report);
		em.flush();
		return report;
	}
	
	public List<Report> getReport(){
		return em.createQuery("SELECT r FROM Report r", Report.class).getResultList();
	}
	
	public Report getReportById(Integer reportId){
		return em.createQuery("SELECT r FROM Report r WHERE r.reportId = :reportId", Report.class).setParameter("reportId", reportId).getSingleResult();
	}
	
	public List<Report> getTechLeadReport(String email){
		return em.createQuery("SELECT r FROM Report r WHERE r.project.techLeadId.email = :email", Report.class)
				.setParameter("email", email).getResultList();
	}
	
	/**
	 * This function is to update report object in db
	 * 
	 * @param report this is the report to be updated
	 */
	public Report update(Report report) {
		em.merge(report);
		em.flush();
		return report;
		
	}
	
	public List<Report> getReportByDevId(String email) {
		return em.createQuery("SELECT r FROM Report r WHERE r.dev.email = :email ORDER BY timeStamp DESC  ", Report.class)
				.setParameter("email", email).getResultList();

	}
/**
 * this will return all accepted and Rejected reports by a tech lead
 * SteffyJ
 * @param email
 * @return
 */
	public List<Report> getallPreviousReports(String email) {

		
		return em.createQuery("Select r FROM Report r WHERE r.project.techLeadId.email = :email  AND r.state IN ('3','4') ORDER BY timeStamp DESC  ",Report.class)   
		.setParameter("email", email).getResultList();


	}
}
