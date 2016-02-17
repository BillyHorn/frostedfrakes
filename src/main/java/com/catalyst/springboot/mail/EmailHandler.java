package com.catalyst.springboot.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * Handles the sending of emails
 * 
 */
@Service
public class EmailHandler {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private TotpAuthentication totpGenerator;

	/**
	 * @param totpGenerator the totpGenerator to set
	 */
	public void setTotpGenerator(TotpAuthentication totpGenerator) {
		this.totpGenerator = totpGenerator;
	}


	/**
	 * @param javaMailSender the javaMailSender to set
	 */
	public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	

	/**
	 * Sends an email to the submitter of a report upon that report's submission.
	 * 
	 * @param email The email of the person submitting the report.
	 * @param project The project of the report that was submitted.
	 * @author kmatthiesen
	 */
	public void youSubmitted(String email, String project) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("effpdx@gmail.com");
		mail.setFrom("effpdx@gmail.com");
		mail.setSubject("Report Submitted");
		mail.setText("Your expense report has been submitted to " + email + " for " + project + " for approval");
        javaMailSender.send(mail);
    }
	
	/**
	 * Sends an email to the techlead when a report is submitted.
	 * 
	 * @param email The email of the techlead of the project.
	 * @param project The project of the report that was submitted.
	 * @author kmatthiesen
	 */
	public void reportSubmitted(String email, String project){
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("effpdx@gmail.com");
		mail.setFrom("effpdx@gmail.com");
		mail.setSubject("A Report has been Submitted");
		mail.setText("An expense report has been submitted by " + email + " for " + project);
        javaMailSender.send(mail);
	}
	
	/**
	 * Sends an email to the submitter when the report is approved.
	 * 
	 * @param email The email of the submitter.
	 * @param project The project of the report that was approved.
	 * @author kmatthiesen
	 */
	public void reportApproved(String email, String project){
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("effpdx@gmail.com");
		mail.setFrom("effpdx@gmail.com");
		mail.setSubject("Your Report was Approved");
		mail.setText("Your expense report for " + project + " has been approved by " + email);
        javaMailSender.send(mail);
	}
	
	/**
	 * Sends an email to the submitter when the report is rejected.
	 * 
	 * @param email The email of the submitter.
	 * @param project The project of the report that was rejected.
	 * @param rejection The reason the report was rejected.
	 * @author kmatthiesen
	 */
	public void reportRejected(String email, String project, String rejection){
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("effpdx@gmail.com");
		mail.setFrom("effpdx@gmail.com");
        mail.setSubject("Your Report was Rejected");
        mail.setText("Your expense report for " + project + " has been rejected by " + email + ". Reason: " + rejection);
        javaMailSender.send(mail);
	}
	
	
	/**
	 * generates a user specific totp code to be used
	 * attaches it to the email and sends to the user
	 * 
	 * @return totp code to db for storage
	 */
	public String totpAuthentication(){
		SimpleMailMessage mail = new SimpleMailMessage();
		String totp = totpGenerator.generateTotp();
		
		mail.setTo("effpdx@gmail.com");
		mail.setFrom("effpdx@gmail.com");
		mail.setSubject("Your Authentication Code");
		mail.setText("Code: " + totp);
       
        javaMailSender.send(mail);
        
        return totp;
	}

}