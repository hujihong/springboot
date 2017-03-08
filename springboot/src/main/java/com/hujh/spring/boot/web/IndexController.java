package com.hujh.spring.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

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
	
}
