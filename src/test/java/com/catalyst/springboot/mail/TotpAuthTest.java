package com.catalyst.springboot.mail;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TotpAuthTest {
	private TotpAuthentication auth;
	
	@Before
	public void setup(){
		auth = new TotpAuthentication();
	}
	
	@Test 
	public void randomTest(){
		assertTrue(auth.generateTotp().matches("[A-N P-Z a-k m-z 0-9]{6}"));
	}
}
//[A-N P-Z a-k m-z 0-9]{6}