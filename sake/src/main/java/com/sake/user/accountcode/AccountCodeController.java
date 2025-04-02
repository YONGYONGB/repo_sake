package com.sake.user.accountcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sake.module.code.CodeDto;
import com.sake.module.code.CodeVo;
import com.sake.module.member.MemberDto;
import com.sake.user.base.UserBaseController;


@Controller
@RequestMapping(value="/user/userAccountPage/")
public class AccountCodeController extends UserBaseController{

	@Autowired
	AccountCodeService accountCodeService;
	
	
	
	@RequestMapping(value ="signup")
	public String signup(Model model, CodeDto codeDto, CodeVo vo){

		return "/user/userAccountPage/signup";
	}
	
	
	
	@RequestMapping(value = "signupInst" )
	public String MemberXdmList(MemberDto memberdto){
		accountCodeService.insert(memberdto);
		return "redirect:/user/userAccountPage/signin";
	}

	
	
	@RequestMapping(value ="signin")
	public String signin(Model model, CodeDto codeDto, CodeVo vo){

		return "/user/userAccountPage/signin";
	}

}
