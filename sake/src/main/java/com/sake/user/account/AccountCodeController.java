package com.sake.user.account;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sake.module.member.MemberDto;
import com.sake.module.member.MemberService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping(value="/user/account/")
public class AccountCodeController {
	
	@Autowired
	AccountCodeService accountCodeService;
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="ChangeUserPassword")
	public String ChangeUserPassword() {
		return "/user/account/ChangeUserPassword";
	}
	//////////////////////////////////////////////
	// 비밀번호 변경
	@RequestMapping(value="UserAccountPassword")
	public String UserAccountPassword(HttpSession httpSession,MemberDto dto,Model model) {
		dto.setUser_id(httpSession.getAttribute("sessSeqUser").toString());
		return "/user/account/UserAccountPassword";
	}
	
	@ResponseBody   //	json정보를  매핑시켜줌.
	@RequestMapping(value = "CheckPwProc")
	public Map<String, Object> CheckPwProc(MemberDto dto,Model model,HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		dto.setUser_id(httpSession.getAttribute("sessSeqUser").toString());
		MemberDto pw =  memberService.checkpw(dto);
		
		if(pw != null) {                             
			returnMap.put("pw", "success");	
		}else{
			returnMap.put("pw", "fail");	
		}		
			
		return returnMap;
	}
	
	@RequestMapping(value = "ChangePwProc")
	public String ChangePwProc(@RequestParam("nwpw") String password,MemberDto dto,HttpSession httpSession,RedirectAttributes redirectAttributes ){
		dto.setUser_id(httpSession.getAttribute("sessSeqUser").toString());
		
		System.out.println(dto.getPassword());
		if (dto.getPassword().equals(password)) {
	        return "redirect:/user/account/UserAccountPassword";
	    }else {
	    	dto.setPassword(password);
	    	accountCodeService.changepw(dto);
	    	return "redirect:/user/account/UserAccountPassword";
	    }
	}
	//////////////////////////////////////////////
	// 계정설정
	@RequestMapping(value="UserAccountSettings")
	public String UserAccountSettings(HttpSession httpSession,MemberDto dto,Model model) {

		dto.setUser_id(httpSession.getAttribute("sessSeqUser").toString());
		accountCodeService.accountSetting(dto.getUser_id());
		model.addAttribute("item", accountCodeService.accountSetting(dto.getUser_id()));
		return "/user/account/UserAccountSettings";
		
	}
	// 계정설정
	@RequestMapping(value="UserAccountUpdate")
	public String UserAccountUpdate(HttpSession httpSession, MemberDto dto) {
		dto.setUser_id(httpSession.getAttribute("sessSeqUser").toString());
		accountCodeService.accountUpdate(dto);
		return "redirect:/user/account/UserAccountSettings";
	}
	
	@ResponseBody   //	json정보를  매핑시켜줌.
	@RequestMapping(value = "SignupIdProc")
	public Map<String, Object> SignupUserProc(MemberDto dto,Model model) throws Exception {
		Map<String, Object> returnm = new HashMap<String, Object>();
		
		MemberDto id =  memberService.checkid(dto);

		if(id == null) {                             //혹시라도 데이터가 넘어오지않으면 null이 리턴됨. 그러면 만들어지지 않은 객체하고 != null 의 상황오류가 발생함.
			returnm.put("id", "success");	
		}else if(dto.getId().equals(id.getId())){
			returnm.put("id", "same");
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
		}else if(dto.getClearance().equals(clearance.getClearance())){
			returncl.put("cl", "same");
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
		}else if(dto.getEmail().equals(email.getEmail())){
			returnMap.put("rt", "same");
		}else{
			returnMap.put("rt", "fail");	
		}		
		
		return returnMap;
	}
	///////////////////////////////
	
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
