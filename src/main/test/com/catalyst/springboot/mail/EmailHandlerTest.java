package com.catalyst.springboot.mail;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailHandlerTest {

	private JavaMailSenderImpl mailSender;
	private EmailHandler emailHandler;
	private SimpleMailMessage mail;
	
	@Before
	public void setup(){
		emailHandler = new EmailHandler();
		mailSender = mock(JavaMailSenderImpl.class);
		emailHandler.setJavaMailSender(mailSender);
		mail = new SimpleMailMessage();
	}
	
	/**
	 * @author kmatthiesen
	 */
	@Test
	public void youSubmittedTest(){
		
		mail.setTo("effpdx@gmail.com");
		mail.setFrom("effpdx@gmail.com");
		mail.setSubject("Report Submitted");
		mail.setText("Your expense report has been submitted to " + null + " for " + null + " for approval");
        		
		emailHandler.youSubmitted(null, null);
		verify(mailSender).send(mail);
	}
	
	/**
	 * @author kmatthiesen
	 */
	@Test
	public void reportSubmittedTest(){
		
		mail.setTo("effpdx@gmail.com");
		mail.setFrom("effpdx@gmail.com");
		mail.setSubject("A Report has been Submitted");
		mail.setText("An expense report has been submitted by " + null + " for " + null);
        
		emailHandler.reportSubmitted(null, null);
		mailSender.send(mail);
	}
	
	/**
	 * @author kmatthiesen
	 */
	@Test
	public void reportApprovedTest(){
		
		mail.setTo("effpdx@gmail.com");
		mail.setFrom("effpdx@gmail.com");
		mail.setSubject("Your Report was Approved");
		mail.setText("Your expense report for " + null + " has been approved by " + null);
        
		emailHandler.reportApproved(null, null);
		mailSender.send(mail);
	}
	
	/**
	 * @author kmatthiesen
	 */
	@Test
	public void reportRejectedTest(){
		
		mail.setTo("effpdx@gmail.com");
		mail.setFrom("effpdx@gmail.com");
		mail.setSubject("Your Report was Rejected");
        mail.setText("Your expense report for " + null + " has been rejected by " + null + ". Reason: " + null);
        
		emailHandler.reportRejected(null, null, null);
		mailSender.send(mail);
	}
	
	
}
