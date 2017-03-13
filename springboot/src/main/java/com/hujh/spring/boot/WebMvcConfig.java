package com.hujh.spring.boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
// @EnableJpaRepositories(repositoryFactoryBeanClass=CustomRepositoryFactoryBean.class)
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

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		super.addResourceHandlers(registry);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		super.addViewControllers(registry);
		registry.addViewController("/xx").setViewName("xx");
		registry.addViewController("/ws").setViewName("/ws");
	    registry.addViewController("/login").setViewName("/login");
	    registry.addViewController("/chat").setViewName("/chat");
	}

	/** 用fastjson做为json解析器 第一种方式
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		// 定义一个conver 转换消息的对象
		// 添加fastjson配置信息，如：是否要格式化返回的json
		// 在convert中添加配置信息
		// 将convert添加到converters中
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		converters.add(fastConverter);	
	}
	**/
	
	// 注册servlet
//	@Bean
//	public ServletRegistrationBean servletRegistrationBean(){
//		return new ServletRegistrationBean(new XxServlet(), "/xx/");
//	}
	
	// 注册Filter
//	@Bean
//	public FilterRegistrationBean filterRegistrationBean() {
//		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//		registrationBean.setFilter(new YyFilter());
//		registrationBean.setOrder(2);
//		return registrationBean;
//	}
	
	// 注册Listener
//	@Bean
//	public ServletListenerRegistrationBean<ZzListener> zzListenerServletRegistrationBean(){
//		return new ServletListenerRegistrationBean<ZzListener>(new ZzListener());
//	}
	
}
