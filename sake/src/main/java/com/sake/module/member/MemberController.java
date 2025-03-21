package com.sake.module.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value ="memberXdmList")
	public String memberXdmList(Model model, MemberVo vo) {
		vo.setParamsPaging(memberService.selectOneCount());	
		
		model.addAttribute("list", memberService.selectList(vo));
		model.addAttribute("vo",vo);
		return "xdm/member/MemberXdmList";
	}
	
	
	@RequestMapping(value = "memberXdmForm")
	public String memberXdmForm() {
		return "xdm/member/MemberXdmForm";
	}
	
	@RequestMapping(value ="memberXdmInst")
	public String requestMethodName(MemberDto memberdto) {
		memberService.insert(memberdto);
		return "redirect:/memberXdmList";
	}
	
	
	@RequestMapping(value = "memberXdmMform")
	public String memberXdmMform(Model model,MemberDto memberdto) {
		model.addAttribute("item",memberService.selectView(memberdto));
		return "xdm/member/MemberXdmMform";
	}
	
	@RequestMapping(value ="memberXdmUpdate")
	public String memberXdmInst(MemberDto memberdto) {
		memberService.update(memberdto);
		return "redirect:/memberXdmList";
	}
	
	
}
