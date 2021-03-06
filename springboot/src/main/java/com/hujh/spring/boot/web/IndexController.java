package com.hujh.spring.boot.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hujh.spring.boot.entity.User;
import com.hujh.spring.boot.vo.Person;

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
	
	
	@RequestMapping("/entity")
	@ResponseBody
    public User entity() {  
		return new User(1, "name2", new Date(), "remark");
    }  

	@RequestMapping("/hot")
	@ResponseBody
    public User hot() {  
		return new User(1, "name3", new Date(), "remark");
    } 
	
	
	@RequestMapping("/th")
	public String index(Model model){
		Person single = new Person("aa",11);
		
		List<Person> people = new ArrayList<Person>();
		Person p1 = new Person("xx",11);
		Person p2 = new Person("yy",22);
		Person p3 = new Person("zz",33);
		people.add(p1);
		people.add(p2);
		people.add(p3);
		
		model.addAttribute("singlePerson", single);
		model.addAttribute("people", people);
		
		return "index7";
	}
	
	@RequestMapping(value="/search",produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Person search(String personName){
		Person p = new Person(personName, 32);
		p.setAddress("hefei");
		return p;
	}
	
	
}
