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
	        registry.addResourceHandler("css/**", "img/**")
	                .addResourceLocations("classpath:/static/css/", "classpath:/static/img/");
	    }

	    @Bean
	    public InternalResourceViewResolver jspViewResolver(){
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	        viewResolver.setViewClass(JstlView.class);
	        return viewResolver;
	    }
	    @Bean
	    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {

	        RequestMappingHandlerAdapter rmha = new RequestMappingHandlerAdapter();
	        rmha.setCacheSeconds(0);
	        return rmha;
	    }
	    @Bean
	    public CommonsMultipartResolver multipartResolver() {
	        CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	        resolver.setDefaultEncoding("utf-8");
	        return resolver;
	    }
	   
}
