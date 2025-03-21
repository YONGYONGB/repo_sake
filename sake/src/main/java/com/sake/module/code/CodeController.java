package com.sake.module.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class CodeController {

	
	@Autowired
	CodeService codeService;
	
	@RequestMapping( value = "codeXdmList")
	public String codeXdmList(Model model, CodeVo vo) {
		
		vo.setParamsPaging(codeService.selectOneCount());
		model.addAttribute("list", codeService.selectList(vo));
		model.addAttribute("vo",vo);
		return "xdm/code/CodeXdmList";
	}
	
	
	
	@RequestMapping(value = "codeXdmForm")
	public String codeXdmForm(@ModelAttribute("vo") CodeVo vo, CodeDto codeDto, Model model)throws Exception{
		
		model.addAttribute("item", codeService.selectCg(codeDto));		
		
		return "xdm/code/CodeXdmForm";
	}
	
	
	@RequestMapping(value = "codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
		codeService.insert(codeDto);
		return "redirect:/codeXdmList";
	}
	
	
	
}
