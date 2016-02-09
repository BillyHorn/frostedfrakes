package com.catalyst.springboot.interceptor;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * intercepts responses that occur after changes to the report table, and logs those changes in reportHistory
 * @author mKness
 *
 */
@Component 
public class ReportLoggingInterceptor extends HandlerInterceptorAdapter{

	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object Handler) throws Exception {
		System.out.println("INTERCEPTED "+ response.getStatus()+" Post???????????????????????????????????????&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

		if(response.getStatus() >= 200 && response.getStatus() < 300){
			System.out.println("INTERCEPTED "+request.getMethod()+" Post???????????????????????????????????????&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			System.out.println(extractRequestBody(request));
		}
		return true;
	}
	
	/**
	 * helper function to extract the body of a put request
	 * @param request
	 * @return
	 * @author mKness
	 */
	static String extractRequestBody(HttpServletRequest request) {
	    if ("PUT".equalsIgnoreCase(request.getMethod())) {
	        Scanner s = null;
	        try {
	            s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return s.hasNext() ? s.next() : "";
	    }
	    return "";
	}
	
}
