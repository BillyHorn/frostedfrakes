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

	public void youSubmitted(String email, String project) {

		MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("effpdx@gmail.com");
            helper.setFrom("effpdx@gmail.com");
            helper.setSubject("Report Submitted");
            helper.setText("Your expense report has been submitted to " + email + " for " + project + " for approval");
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {}
        javaMailSender.send(mail);
    }
	
	public void reportSubmitted(String email, String project){
		MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("effpdx@gmail.com");
            helper.setFrom("effpdx@gmail.com");
            helper.setSubject("A Report has been Submitted");
            helper.setText("An expense report has been submitted by " + email + " for " + project);
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {}
        javaMailSender.send(mail);
	}
	
	public void reportApproved(String email, String project){
		MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("effpdx@gmail.com");
            helper.setFrom("effpdx@gmail.com");
            helper.setSubject("Your Report was Approved");
            helper.setText("Your expense report for " + project + " has been approved by " + email);
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {}
        javaMailSender.send(mail);
	}
	
	public void reportRejected(String email, String project, String rejection){
		MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("effpdx@gmail.com");
            helper.setFrom("effpdx@gmail.com");
            helper.setSubject("Your Report was Rejected");
            helper.setText("Your expense report for " + project + " has been rejected by " + email + ". Reason: " + rejection);
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {}
        javaMailSender.send(mail);
	}

}