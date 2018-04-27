package com.ziv.springboot.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ziv.springboot.interceptor.WebInterceptor;

@Configuration
@EnableAutoConfiguration
public class WebAppConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new WebInterceptor()).addPathPatterns("/**");
	}
	
}
