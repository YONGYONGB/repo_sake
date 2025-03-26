package com.sake.module.codegroup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sake.module.code.CodeService;


@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;

	
	@Autowired
	CodeService codeService;
	
	
	
	
	@RequestMapping(value = "codeGroupList")
	public String codeGroupList(@ModelAttribute("vo") CodeGroupVo vo,Model model) throws Exception{
		
		
		vo.setParamsPaging(codeGroupService.selectOneCount(vo));
		model.addAttribute("lists", codeGroupService.selectList(vo));
		
		
		return "xdm/codegroup/CodeGroupXdmList";
	}
	
	
	
	@RequestMapping(value = "codeGroupForm")
	public String codeGroupForm(@ModelAttribute("vo") CodeGroupVo vo,CodeGroupDto codeGroupDto,Model model){
		// html에 있는 값을 자동으로 vo로 저장 dto 랑 vo.
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
	
	
	
	
	@RequestMapping(value = "/codeGroupUelete")
	public String codeGroupUelete(@RequestParam("cg_id") String seq) {
		   
		String[] cgIdArray = seq.split(",");
	    
	    List<Integer> cgIdList = new ArrayList<>();
	    for (String id : cgIdArray) {
	        cgIdList.add(Integer.parseInt(id));  // 각 cg_id를 Integer로 변환하여 리스트에 추가
	    }

	    // 리스트를 서비스로 전달하여 업데이트
	    codeGroupService.uelete(cgIdList);

	    return "redirect:/codeGroupList";
	}
	
	

	
	
	
	
}
