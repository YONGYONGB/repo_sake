package com.sake.module.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sake.module.codegroup.CodeGroupDto;



@Controller
public class CodeController {

	
	@Autowired
	CodeService codeService;
	
	@RequestMapping( value = "codeXdmList")
	public String codeXdmList( @ModelAttribute("vo") CodeVo vo,Model model) {
		
		vo.setParamsPaging(codeService.selectOneCount(vo));
		model.addAttribute("list", codeService.selectList(vo));
		return "xdm/code/CodeXdmList";
	}
	
	
	
	@RequestMapping(value = "codeXdmForm")
	public String codeXdmForm(@ModelAttribute("vo") CodeVo vo, CodeDto codeDto, Model model)throws Exception{
		model.addAttribute("lists", codeService.selectCg(codeDto));
		
		if (vo.getCd_id().equals("0") || vo.getCd_id().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", codeService.selectView(codeDto));
			System.out.println(codeDto);
		}
		
		return "xdm/code/CodeXdmForm";
	}
	
	
	
	@RequestMapping(value = "codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
		codeService.insert(codeDto);
		return "redirect:/codeXdmList";
	}
	
	@RequestMapping(value = "codeXdmUpdate")
	public String codeXdm(CodeDto codeDto) {
		codeService.update(codeDto);
		return "redirect:/codeXdmList";
	}
	
	
	
}
