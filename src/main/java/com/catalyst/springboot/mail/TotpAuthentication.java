package com.catalyst.springboot.mail;

import java.util.Random;
import org.springframework.stereotype.Service;

/**
 * creates a randomly generated alpha numberic code for login
 * 
 * @author blarsen
 *
 */

@Service
public class TotpAuthentication {
	final static String AB = "0123456789ABCDEFGHIJKLMNPQRSTUVWXYZ0123456789abcdefghijkmnopqrstuvwxyz0123456789";
	   
	   public String generateTotp(){
		   StringBuilder sb = new StringBuilder( 6 );
		   Random rnd = new Random();
		   for( int i = 0; i < 6; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   
		   return sb.toString();
	   }
}
