package com.sake.module.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;

	

	
	
	
	
	@RequestMapping(value = "codeGroupList")
	public String codeGroupList(Model model, CodeGroupVo vo) {
		
		vo.setParamsPaging(codeGroupService.selectOneCount());
		
		
		model.addAttribute("list", codeGroupService.selectList(vo));
		model.addAttribute("vo",vo);
		
		
		
		return "xdm/codegroup/CodeGroupXdmList";
	}
	
	@RequestMapping(value = "codeGroupView")
	public String codeGroupView(Model model, CodeGroupDto codeGroupDto) {
		model.addAttribute("item", codeGroupService.selectView(codeGroupDto));
		return "xdm/codegroup/CodeGroupXdmView";
	}
	
	@RequestMapping(value = "codeGroupForm")
	public String codeGroupForm() {
		return "xdm/codegroup/CodeGroupForm";
	}

	
	
	@RequestMapping(value = "codeGroupInst")
	public String codeGroupInst(CodeGroupDto codeGroupDto) {
	codeGroupService.insert(codeGroupDto);
		return "redirect:/codeGroupList";
	}
	
	
	@RequestMapping(value = "codeGroupMform")
	public String codeGroupMForm(Model model, CodeGroupDto codeGroupDto) {
		model.addAttribute("item", codeGroupService.selectView(codeGroupDto));
		return "xdm/codegroup/CodeGroupMform";
	}

	
	@RequestMapping(value = "codeGroupUpdate")
	public String codeGroupUpdate(CodeGroupDto codeGroupDto) {
		System.out.println(codeGroupDto.getCg_id());
		codeGroupService.update(codeGroupDto);
		System.out.println(codeGroupDto.getCg_id());
	
		return "redirect:/codeGroupList";
	}
	
	
	
	
	@RequestMapping(value = "codeGroupDelete")
	public String codeGroupDelete(CodeGroupDto codeGroupDto) {
		codeGroupService.delete(codeGroupDto);
		return "redirect:/codeGroupController";
	}
	
	

	
	
}
