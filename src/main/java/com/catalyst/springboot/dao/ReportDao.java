package com.catalyst.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.mail.EmailHandler;

@Transactional
@Component
public class ReportDao {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	EmailHandler emailHandler;

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * @param emailHandler the emailHandler to set
	 */
	public void setEmailHandler(EmailHandler emailHandler) {
		this.emailHandler = emailHandler;
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
	public void update(Report report) {
		try {
			em.merge(report);
			em.flush();
			if (report.getState().equals("2")){
				emailHandler.youSubmitted(report.getProject().getTechLeadId().getEmail(), report.getProject().getName());
				emailHandler.reportSubmitted(report.getDev().getEmail(), report.getProject().getName());
			}
			else if (report.getState().equals("3")){
				emailHandler.reportRejected(report.getProject().getTechLeadId().getEmail(), report.getProject().getName(), report.getRejectionNotes());
			}
			else if (report.getState().equals("4")){
				emailHandler.reportApproved(report.getProject().getTechLeadId().getEmail(), report.getProject().getName());
			}
		} catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
	}
	
	public List<Report> getReportByDevId(String email) {
		return em.createQuery("SELECT r FROM Report r WHERE r.dev.email = :email ", Report.class)
				.setParameter("email", email).getResultList();

	}
}
