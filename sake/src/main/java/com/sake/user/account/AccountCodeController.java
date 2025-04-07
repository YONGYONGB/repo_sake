package com.sake.user.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value="/user/account/")
public class AccountCodeController {

	@RequestMapping(value="UserAccountPassword")
	public String UserAccountPassword() {
		return "/user/account/UserAccountPassword";
	}
	
	@RequestMapping(value="UserAccountSettings")
	public String UserAccountSettings() {
		return "/user/account/UserAccountSettings";
	}
	
	@RequestMapping(value="UserOrderDetails")
	public String UserOrderDetails() {
		return "/user/account/UserOrderDetails";
	}
	
}
