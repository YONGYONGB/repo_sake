package com.sake.module.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CodeController {

	
	@Autowired
	CodeService codeService;
	
	@RequestMapping( value = "codeXdmList")
	public String codeXdmList(Model model, CodeVo vo) {
		vo.setParamsPaging(codeService.selectOneCount());
		model.addAttribute("vo",vo);
		model.addAttribute("list", codeService.selectList(vo));
		
		return "xdm/code/CodeXdmList";
	}
	
	@RequestMapping( value = "codeXdmView")
	public String codeXdmView(Model model, CodeDto codeDto) {
		model.addAttribute("item", codeService.selectView(codeDto));
		return "xdm/code/CodeXdmView";
	}
	
	
	@RequestMapping(value = "codeXdmForm")
	public String codeXdmForm(Model model, CodeDto codeDto) {
		model.addAttribute("item", codeService.selectView(codeDto));
		return "xdm/code/CodeXdmForm";
	}
	
	
	@RequestMapping(value = "codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
		codeService.insert(codeDto);
		return "redirect:codeXdmList";
	}
	
	
	
}
