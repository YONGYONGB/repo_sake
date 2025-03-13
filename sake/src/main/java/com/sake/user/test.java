package com.sake.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class test {

	@RequestMapping(value ="start")
	public String requestMethodName() {
		return "user/index/index";
	}
	
}
