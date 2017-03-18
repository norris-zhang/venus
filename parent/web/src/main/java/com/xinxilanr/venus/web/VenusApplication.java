package com.xinxilanr.venus.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
@ComponentScan("com.xinxilanr.venus")
public class VenusApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(VenusApplication.class, args);
	}
	
	@Bean
	public MessageSource messageSource(@Value("${spring.thymeleaf.messages.cache.seconds}") int messageSourceCacheSeconds) {
		final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:/templates/user/register",
								   "classpath:/messages");
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(messageSourceCacheSeconds);
		return messageSource;
	}

}
