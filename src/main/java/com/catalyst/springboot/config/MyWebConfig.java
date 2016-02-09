package com.catalyst.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.catalyst.springboot.interceptor.ReportLoggingInterceptor;

/**
 * adds interceptors to the spring registry and tells them what paths to act on
 * @author mKness
 *
 */
@Configuration
public class MyWebConfig extends WebMvcConfigurerAdapter{

	/** adds the report logging intercepter to the report paths
	 * @author mKness
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ReportLoggingInterceptor())
				.addPathPatterns("/repor**/**", "/report");
	}
}
