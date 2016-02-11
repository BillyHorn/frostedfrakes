package com.catalyst.springboot.config;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * This class provides important configuration overrides necessary for our image
 * handling.
 * 
 * @author atatro
 *
 */
@Configuration
public class AllResources extends WebMvcConfigurerAdapter {

	/**
	 * this method allows us to send raw image data and retrieve it on the
	 * client side as an image file.
	 * 
	 * @author atatro
	 */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new BufferedImageHttpMessageConverter());
    }
    
    /**
     * leaving these here just in case they're needed. please don't delete them yet.
     */
//    @Override
//    public void configurePathMatch(PathMatchConfigurer matcher) {
//        matcher.setUseRegisteredSuffixPatternMatch(true);
//    }
	
//    @Bean
//    public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter(){
//        ByteArrayHttpMessageConverter bam = new ByteArrayHttpMessageConverter();
//        List<org.springframework.http.MediaType> mediaTypes = new LinkedList<MediaType>();
//        mediaTypes.add(org.springframework.http.MediaType.APPLICATION_JSON);
//        mediaTypes.add(org.springframework.http.MediaType.IMAGE_JPEG);
//        mediaTypes.add(org.springframework.http.MediaType.IMAGE_PNG);
//        mediaTypes.add(org.springframework.http.MediaType.IMAGE_GIF);
//        mediaTypes.add(org.springframework.http.MediaType.TEXT_PLAIN);
//        bam.setSupportedMediaTypes(mediaTypes);
//        return bam;
//    }
    
//    @Bean
//    public ContentNegotiatingViewResolver contentViewResolver() throws Exception {
//        ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
//        ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
//        contentNegotiationManager.addMediaType("json", MediaType.APPLICATION_JSON);
//        contentViewResolver.setContentNegotiationManager(contentNegotiationManager.getObject());
//        contentViewResolver.setDefaultViews(Arrays.<View> asList(new MappingJackson2JsonView()));
//        return contentViewResolver;
//    }

}