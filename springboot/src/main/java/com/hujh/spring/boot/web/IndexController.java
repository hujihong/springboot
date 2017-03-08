package com.hujh.spring.boot.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private MessageSource messageSource;  // 国际化
	
	@RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        map.addAttribute("msg", "中文");
        // 国际化
        String welcome = messageSource.getMessage("home.welcome", null, LocaleContextHolder.getLocale());
       //RequestContextUtils.getLocale(request)
        map.addAttribute("welcome", welcome);
        return "index";  
    }
	
	@RequestMapping("/log")
	@ResponseBody
    public String log() {  
        log.debug("debug level log");  
        log.info("info level log");  
        log.warn("warn level log");  
        log.error("error level log");  
        return "Hello world from Spring Boot!";  
    }  
	
}
