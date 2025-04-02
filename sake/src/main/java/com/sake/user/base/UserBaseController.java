package com.sake.user.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserBaseController {

	@RequestMapping(value = "/user/index/UserIndex")
	public String home() {
		return "/user/index/UserIndex";
	}
}
