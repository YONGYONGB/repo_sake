package com.sake.module.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;

	@RequestMapping(value = "codeGroupController")
	public String codeGroupController(Model model) {
		model.addAttribute("list", codeGroupService.selectList());
		return "xdm/codegroup/CodeGroupXdmList";
	}
	
	@RequestMapping(value = "codeGroupView")
	public String codeGroupView(Model model, CodeGroupDto codeGroupDto) {
		model.addAttribute("item", codeGroupService.selectView());
		return "xdm/codegroup/CodeGroupXdmView";
	}
	
	@RequestMapping(value = "codeGroupForm")
	public String codeGroupForm() {
		return "xdm/codegroup/CodeGroupForm";
	}
	
		
	
	@RequestMapping(value = "codeGroupInst")
	public String codeGroupInst(CodeGroupDto codeGroupDto) {
	codeGroupService.insert(codeGroupDto);
		return "redirect:/codeGroupController";
	}
	
	@RequestMapping(value = "codeGroupDelete")
	public String codeGroupDelete(CodeGroupDto codeGroupDto) {
		codeGroupService.delete(codeGroupDto);
		return "redirect:/codeGroupController";
	}
	
	
	
	
}
