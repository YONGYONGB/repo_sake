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
	public Map<String, Object> signinXdmProc(MemberVo vo,MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		

	    List<MemberDto> members = memberService.selectList(vo);
		
	    boolean isValidUser = false;
	    for (MemberDto member : members) {
	        if (member.getId().equals(dto.getId()) && member.getPassword().equals(dto.getPassword())) {
	            isValidUser = true;
	            break;
	        }
	    }
	    
	    if (isValidUser) {
	        returnMap.put("rt", "success");
	        System.out.println("성공");
	    } else {
	        returnMap.put("rt", "false");
	        System.out.println("실패");
	    }
	    
	    
		return returnMap;
	}
	
	
}
