package com.hujh.spring.boot;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	
	// SpringBoot默认已经为应用添加了以下Servlet/Filter 
	/**
	 * 	o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/] 
	   	o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*] 
		o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*] 
		o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*] 
		o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
	 */
	// 注册filter
//	@Bean  
//	  public FilterRegistrationBean filter1() {  
//	    FilterRegistrationBean bean = new FilterRegistrationBean();  
//	    bean.setFilter(new MultipleFilter1());  
//	    bean.setOrder(2);  
//	    return bean;  
//	  }  
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 可增加拦截器
		super.addInterceptors(registry);
	}
	
	
	
}
