package com.sake.module.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	

	
	@RequestMapping(value ="memberXdmList")
	public String memberXdmList(@ModelAttribute("vo") MemberVo vo,Model model) {
		vo.setParamsPaging(memberService.selectOneCount(vo));		
		model.addAttribute("list", memberService.selectList(vo));
		return "xdm/member/MemberXdmList";
	}
	
	
	@RequestMapping(value = "memberXdmForm")
	public String memberXdmForm(@ModelAttribute("vo") MemberVo vo,MemberDto memberdto,Model model) {
		if (vo.getUser_id().equals("0") || vo.getUser_id().equals("")) {
//			insert mode
		} else {
			model.addAttribute("item",memberService.selectView(memberdto));
		}
		
		return "xdm/member/MemberXdmForm";
	}
	
	@RequestMapping(value ="memberXdmInst")
	public String requestMethodName(MemberDto memberdto) {
		memberService.insert(memberdto);
		return "redirect:/memberXdmList";
	}
	
	
	@RequestMapping(value ="memberXdmUpdate")
	public String memberXdmInst(MemberDto memberdto) {
		memberService.update(memberdto);
		return "redirect:/memberXdmList";
	}
	
	@RequestMapping(value ="login")
	public String login() {
		return "xdm/member/MemberLogin";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/signinXdmProc")
	public Map<String, Object> signinXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto member = memberService.selectOneLogin(dto);
		System.out.println(member);
//		혹시라도 데이터가 넘어오지않으면 null이 되어버림.
		if(member != null) {
			returnMap.put("rt", "success");	
			httpSession.setAttribute("sessSeqXdm", member.getUser_id());
			httpSession.setAttribute("sessIdXdm", member.getId());
			httpSession.setAttribute("sessNameXdm", member.getPassword());
		}else{
			returnMap.put("rt", "false");	
		}
		
	        
			
			return returnMap;
		}
		

@ResponseBody
@RequestMapping(value = "/signlogoutXdmProc")
public Map<String, Object> signlogoutXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
	Map<String, Object> returnMap = new HashMap<String, Object>();
	
	
		returnMap.put("rt", "false");	

		
		return returnMap;
	}
	
}


//  List<MemberDto> members = memberService.selectList(vo);
//
//	boolean isValidUser = false;
//	for (MemberDto member : members) {
//    if (member.getId().equals(dto.getId()) && member.getPassword().equals(dto.getPassword())) {
//        isValidUser = true;
//        break;
//    	}
//	}
//
//	if (isValidUser) {
//		returnMap.put("rt", "success");
//		System.out.println("성공");
//	} else {
//		returnMap.put("rt", "false");
//		System.out.println("실패");
//	}
