package com.sake.module.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping(value="/xdm/code/")
public class CodeController {

	
	@Autowired
	CodeService codeService;
	
	@RequestMapping( value = "/CodeXdmList")
	public String codeXdmList( @ModelAttribute("vo") CodeVo vo,Model model) {
		System.out.println(vo.getShDateStart());
		System.out.println(vo.getShDateEnd());
	
		
		model.addAttribute("vo", vo);
		vo.setParamsPaging(codeService.selectOneCount(vo));
		model.addAttribute("list", codeService.selectList(vo));
		return "/xdm/code/CodeXdmList";
	}
	
	
	
	@RequestMapping(value = "/CodeXdmForm")
	public String codeXdmForm(@ModelAttribute("vo") CodeVo vo, CodeDto codeDto, Model model)throws Exception{
		model.addAttribute("lists", codeService.selectCg(codeDto));
		
		if (vo.getCd_id().equals("0") || vo.getCd_id().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", codeService.selectView(codeDto));
			System.out.println(codeDto);
		}
		
		return "/xdm/code/CodeXdmForm";
	}
	
	
	
	@RequestMapping(value = "/CodeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
		codeService.insert(codeDto);
		return "redirect:/xdm/code/CodeXdmList";
	}
	
	@RequestMapping(value = "/CodeXdmUpdate")
	public String codeXdm(CodeDto codeDto) {
		codeService.update(codeDto);
		return "redirect:/xdm/code/CodeXdmList";
	}
	
	@RequestMapping(value = "/CodeXdmUelete")
	public String codeXdmUelete(@RequestParam("cd_id") List<Integer> cdIdList) {
		codeService.uelete(cdIdList);
		return "redirect:/xdm/code/CodeXdmList";
	}
	
	
	
}
