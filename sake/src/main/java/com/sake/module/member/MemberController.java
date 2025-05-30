package com.sake.module.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sake.module.base.BaseController;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping(value="/xdm/member/")
public class MemberController extends BaseController{
	
	@Autowired
	MemberService memberService;
	

	
	@RequestMapping(value ="MemberXdmList")
	public String memberXdmList(@ModelAttribute("vo") MemberVo vo,HttpSession httpSession,Model model) {
		
		addEnd(vo);
		model.addAttribute("vo", vo);
		vo.setParamsPaging(memberService.selectOneCount(vo));		
		model.addAttribute("list", memberService.selectList(vo));
		
		return "xdm/member/MemberXdmList";
	}
	
	
	@RequestMapping(value = "MemberXdmForm")
	public String memberXdmForm(@ModelAttribute("vo") MemberVo vo,MemberDto memberdto,Model model) {
		if (vo.getUser_id().equals("0") || vo.getUser_id().equals("")) {
//			insert mode
		} else {
			model.addAttribute("item",memberService.selectView(memberdto));
		}
		
		return "xdm/member/MemberXdmForm";
	}
	
	@RequestMapping(value ="MemberXdmInst")
	public String requestMethodName(MemberDto memberdto) {
		memberService.insert(memberdto);
		return "redirect:/xdm/member/MemberXdmList";
	}
	
	
	@RequestMapping(value ="MemberXdmUpdate")
	public String memberXdmInst(MemberDto memberdto) {
		memberService.update(memberdto);
		return "redirect:/xdm/member/MemberXdmList";
	}
	
	@RequestMapping(value = "MemberXdmUelete")
	public String MemberXdmUelete(@RequestParam("user_id")List<Integer> userIdList){
		memberService.uelete(userIdList);
		return "redirect:/xdm/member/MemberXdmList";
	}
		
	
	
	@RequestMapping(value ="SigninXdmForm")
	public String login() {
		return "xdm/member/SigninXdmForm";
	}
	
	
		
	
	@ResponseBody   //	json정보를  매핑시켜줌.
	@RequestMapping(value = "SigninXdmProc")
	public Map<String, Object> signinXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto member = memberService.selectOneLogin(dto);

		if(member != null) {                             //혹시라도 데이터가 넘어오지않으면 null이 리턴됨. 그러면 만들어지지 않은 객체하고 != null 의 상황오류가 발생함.
			returnMap.put("rt", "success");	
			System.out.println(member);
			httpSession.setAttribute("sessSeqXdm", member.getUser_id());
			httpSession.setAttribute("sessIdXdm", member.getId());
			httpSession.setAttribute("sessNameXdm", member.getName());
		}else{
			returnMap.put("rt", "fail");	
		}		
			
		return returnMap;
	}
		

@ResponseBody
@RequestMapping(value = "SignoutXdmProc")
public Map<String, Object> signlogoutXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
	
		httpSession.setAttribute("sessSeqXdm", null);
		httpSession.setAttribute("sessIdXdm", null);
		httpSession.setAttribute("sessNameXdm", null);
		returnMap.put("rt", "success");
		return returnMap;
	}
	
}



