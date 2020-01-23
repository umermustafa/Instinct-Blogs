package com.spring.instinctblogs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "com.spring.instinctblogs")
public class ApplicationConfig extends WebMvcConfigurationSupport{

	 @Override
	    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("css/**", "images/**")
	                .addResourceLocations("classpath:/static/css/", "classpath:/static/images/");
	    }

	    @Bean
	    public InternalResourceViewResolver jspViewResolver(){
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	        viewResolver.setViewClass(JstlView.class);
	        return viewResolver;
	    }
	    
	   
}
