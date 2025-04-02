package com.sake.user.accountcode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sake.module.code.CodeDto;
import com.sake.module.code.CodeVo;
import com.sake.module.member.MemberDto;
import com.sake.module.member.MemberService;
import com.sake.user.base.UserBaseController;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping(value="/user/userAccountPage/")
public class AccountCodeController extends UserBaseController{

	@Autowired
	AccountCodeService accountCodeService;
	
	@Autowired
	MemberService memberService;
	
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

	
	
	@ResponseBody   //	json정보를  매핑시켜줌.
	@RequestMapping(value = "SigninUserProc")
	public Map<String, Object> SigninUserProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto member = memberService.selectOneLogin(dto);

		if(member != null) {                             //혹시라도 데이터가 넘어오지않으면 null이 리턴됨. 그러면 만들어지지 않은 객체하고 != null 의 상황오류가 발생함.
			returnMap.put("rt", "success");	
			System.out.println(member);
			httpSession.setAttribute("sessSeqUser", member.getUser_id());
			httpSession.setAttribute("sessIdUser", member.getId());
			httpSession.setAttribute("sessNameUser", member.getName());
		}else{
			returnMap.put("rt", "fail");	
		}		
			
		return returnMap;
	}
	
	
}
