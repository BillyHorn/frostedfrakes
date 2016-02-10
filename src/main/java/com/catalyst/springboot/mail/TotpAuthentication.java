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
	final static String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz0123456789";
	Random rnd = new Random();
	   
	   public String generateTotp(){
		   StringBuilder sb = new StringBuilder( 6 );
		   for( int i = 0; i < 6; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   //System.out.println(sb.toString());
		   //System.out.println(Math.abs(epoch - epoch2));
		   
		   return sb.toString();
	   }
}
