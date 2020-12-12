package com.lighthouse.team03;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam; 

@Controller
public class DemoController {
	HashMap<String,String> db = new HashMap();
	
	@RequestMapping("/")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password, @ModelAttribute User user) {
		
		if (db.containsKey(username)) {
			if (db.get(username).equals(password)) {
			return"home";
			}else {
				return"failed";
			}
		}else {
			return"failed";
			}
		}

	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String registerSubmission(@RequestParam("userName") String userName, @RequestParam("password") String password) {
	db.put(userName,password);
	    return"/login";
	
	}
}
