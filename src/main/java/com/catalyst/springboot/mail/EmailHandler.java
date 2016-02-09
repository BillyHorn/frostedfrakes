package com.catalyst.springboot.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailHandler {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/**
	 * 
	 * @param email
	 * @param project
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
	 * 
	 * @param email
	 * @param project
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
	 * 
	 * @param email
	 * @param project
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
	 * 
	 * @param email
	 * @param project
	 * @param rejection
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

}