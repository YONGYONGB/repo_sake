package com.sake.user.accountcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sake.module.code.CodeDto;
import com.sake.module.code.CodeService;
import com.sake.module.code.CodeVo;


@Controller
public class AccountCodeController {

	@Autowired
	AccountCodeService accountCodeService;
	
	@Autowired
	CodeService codeService;
	
	@RequestMapping(value ="signupForm")
	public String signupForm(Model model, CodeDto codeDto, CodeVo vo){
		model.addAttribute("list", codeService.selectList(vo));
		return "user/userAccountPage/signup";
	}
	
	
	
	@RequestMapping(value = "signupInst" )
	public String MemberXdmList(AccountCodeDto accountCodeDto){
		accountCodeService.insert(accountCodeDto);
		return "redirect:/signupForm";
	}


}
