package com.sake.user.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sake.module.member.MemberDto;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping(value="/user/account/")
public class AccountCodeController {
	
	@Autowired
	AccountCodeService accountCodeService;
	
	
	@RequestMapping(value="ChangeUserPassword")
	public String ChangeUserPassword() {
		return "/user/account/ChangeUserPassword";
	}
	// 비밀번호 변경
	@RequestMapping(value="UserAccountPassword")
	public String UserAccountPassword() {
		return "/user/account/UserAccountPassword";
	}
	// 계정설정
	@RequestMapping(value="UserAccountSettings")
	public String UserAccountSettings(HttpSession httpSession,MemberDto dto,Model model) {
		String user_id = (String) httpSession.getAttribute("sessSeqUser");
		accountCodeService.accountSetting(user_id);
		model.addAttribute("item", accountCodeService.accountSetting(user_id));
		return "/user/account/UserAccountSettings";
	}
	//계정탈퇴
	@RequestMapping(value="UserAccountWithdraw")
	public String UserAccountWithdraw() {
		return "/user/account/UserAccountWithdraw";
	}
	//주문내역
	@RequestMapping(value="UserOrderDetails")
	public String UserOrderDetails() {
		return "/user/account/UserOrderDetails";
	}
	
	@RequestMapping(value="UserAccountAddress")
	public String UserAccountAddress() {
		return "/user/account/UserAccountAddress";
	}
	
}
