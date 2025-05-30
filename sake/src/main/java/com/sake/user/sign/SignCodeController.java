package com.sake.user.sign;

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
import com.sake.user.email.EmailService;
import com.sake.user.email.TemplateVo;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping(value="/user/sign/")
public class SignCodeController extends UserBaseController{

	@Autowired
	SignCodeService signCodeService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	EmailService emailService;
	
	@RequestMapping(value ="signup")
	public String signup(Model model, CodeDto codeDto, CodeVo vo){

		return "user/sign/signup";
	}
	
	
	
	
	
	@RequestMapping(value ="signin")
	public String signin(Model model, CodeDto codeDto, CodeVo vo){

		return "user/sign/signin";
	}

	
	//계정설정 파트
	
	
	@ResponseBody   //	json정보를  매핑시켜줌.
	@RequestMapping(value = "SignupIdProc")
	public Map<String, Object> SignupUserProc(MemberDto dto,Model model) throws Exception {
		Map<String, Object> returnm = new HashMap<String, Object>();
		
		MemberDto id =  memberService.checkid(dto);

		if(id == null) {                             //혹시라도 데이터가 넘어오지않으면 null이 리턴됨. 그러면 만들어지지 않은 객체하고 != null 의 상황오류가 발생함.
			returnm.put("id", "success");	
		}else{
			returnm.put("id", "fail");	
		}		
			
		return returnm;
	}
	@ResponseBody   //	json정보를  매핑시켜줌.
	@RequestMapping(value = "SignupClProc")
	public Map<String, Object> SignupClProc(MemberDto dto,Model model) throws Exception {
		Map<String, Object> returncl = new HashMap<String, Object>();
		MemberDto clearance = memberService.checkclearance(dto);
		if(clearance == null) {                          
			returncl.put("cl", "success");	
		}else{
			returncl.put("cl", "fail");	
		}		
		
		return returncl;
	}
	
	@ResponseBody   //	json정보를  매핑시켜줌.
	@RequestMapping(value = "SignupEmProc")
	public Map<String, Object> SignupEmProc(MemberDto dto,Model model) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto email = memberService.checkem(dto);
		
		if(email == null) {                          
			returnMap.put("rt", "success");	
		}else{
			returnMap.put("rt", "fail");	
		}		
		
		return returnMap;
	}
	
	//회원가입 및 암호화 하는법
	// 회원가입
	@RequestMapping(value = "signupInst" )
	public String MemberXdmList(MemberDto memberDto, TemplateVo templateVo) throws Exception{
		System.out.println(memberDto.getPassword());
		memberDto.setPassword(encodeBcrypt(memberDto.getPassword(),10));
		
		signCodeService.insert(memberDto);
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
				// TODO Auto-generated method stub
					emailService.sendMailWelcome(memberDto, templateVo);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
			
		thread.start();
		
		
		
		
		return "redirect:/user/sign/signin";
	}

	
	//로그인 파트
	@ResponseBody   //	json정보를  매핑시켜줌.
	@RequestMapping(value = "SigninUserProc")
	public Map<String, Object> SigninUserProc(MemberDto dto, HttpSession httpSession,Model model) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		
		MemberDto member = memberService.selectOneLogin(dto);
				
		if(member != null && matchesBcrypt(dto.getPassword(),member.getPassword(),10)){                             //혹시라도 데이터가 넘어오지않으면 null이 리턴됨. 그러면 만들어지지 않은 객체하고 != null 의 상황오류가 발생함.
//			dto.setPassword(encodeBcrypt(member.getPassword(),10));
			returnMap.put("rt", "success");	
				System.out.println(member);
				httpSession.setAttribute("sessSeqUser", member.getUser_id());
				httpSession.setAttribute("sessIdUser", member.getId());
				httpSession.setAttribute("sessNameUser", member.getName());
			} else {
				returnMap.put("rt", "fail");
			}
					
		return returnMap;
	}
	
	//로그아웃 파트
	@ResponseBody
	@RequestMapping(value = "SignoutUserProc")
	public Map<String, Object> SignoutUserProc(MemberDto dto, HttpSession httpSession) throws Exception {
			Map<String, Object> returnMap = new HashMap<String, Object>();
		
			httpSession.setAttribute("sessSeqUser", null);
			httpSession.setAttribute("sessIdUser", null);
			httpSession.setAttribute("sessNameUser", null);
			returnMap.put("rt", "success");
			return returnMap;
		}
}
