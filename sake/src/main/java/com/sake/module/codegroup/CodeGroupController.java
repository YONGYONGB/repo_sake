package com.sake.module.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sake.module.code.CodeService;
import com.sake.module.code.CodeVo;


@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;

	
	@Autowired
	CodeService codeService;
	
	
	
	
	@RequestMapping(value = "codeGroupList")
	public String codeGroupList(@ModelAttribute("vo") CodeGroupVo vo,Model model) throws Exception{
		
		
		vo.setParamsPaging(codeGroupService.selectOneCount(vo));
		model.addAttribute("list", codeGroupService.selectList(vo));
		
		
		return "xdm/codegroup/CodeGroupXdmList";
	}
	
	
	
	@RequestMapping(value = "codeGroupForm")
	public String codeGroupForm(@ModelAttribute("vo") CodeGroupVo vo,CodeGroupDto codeGroupDto,Model model){
		
		if(vo.getCg_id().equals("0") || vo.getCg_id().equals(" ")) {
		} else {
			model.addAttribute("item", codeGroupService.selectView(codeGroupDto));
		}
		
		return "xdm/codegroup/CodeGroupForm";
	}

	
	
	@RequestMapping(value = "codeGroupInst")
	public String codeGroupInst(CodeGroupDto codeGroupDto) {
	codeGroupService.insert(codeGroupDto);
		return "redirect:/codeGroupList";
	}
	
	

	
	@RequestMapping(value = "codeGroupUpdate")
	public String codeGroupUpdate(CodeGroupDto codeGroupDto) {
		codeGroupService.update(codeGroupDto);
	
		return "redirect:/codeGroupList";
	}
	
	
	
	
	@RequestMapping(value = "codeGroupDelete")
	public String codeGroupDelete(CodeGroupDto codeGroupDto) {
		codeGroupService.delete(codeGroupDto);
		return "redirect:/codeGroupController";
	}
	
	

	
	
	
	
}
