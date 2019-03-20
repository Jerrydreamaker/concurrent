package com.iecas.concurrency;

import com.iecas.concurrency.example.threadLocal.HttpFilter;
import com.iecas.concurrency.example.threadLocal.HttpInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@SpringBootApplication
public class ConcurrencyApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(ConcurrencyApplication.class, args);
	}

	@Bean
	//注入 Filter Bean
	public FilterRegistrationBean httpFilter(){
		FilterRegistrationBean registrationBean=new FilterRegistrationBean();
		registrationBean.setFilter(new HttpFilter());
		registrationBean.addUrlPatterns("/threadLocal/*");
		return registrationBean;
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
	}
}
