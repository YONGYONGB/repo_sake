package com.sake.module.codegroup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sake.module.base.BaseController;
import com.sake.module.base.BaseVo;
import com.sake.module.code.CodeService;


@Controller
@RequestMapping(value="/xdm/codegroup/")
public class CodeGroupController extends BaseController{
	
	@Autowired
	CodeGroupService codeGroupService;

	
	@Autowired
	CodeService codeService;
	
	
	
	
	@RequestMapping(value = "CodeGroupXdmList")
	public String CodeGroupList(@ModelAttribute("vo") CodeGroupVo vo,Model model) throws Exception{
		
		addEnd(vo);
		model.addAttribute("vo", vo);
		vo.setParamsPaging(codeGroupService.selectOneCount(vo));
		model.addAttribute("lists", codeGroupService.selectList(vo));
		
		
		return "xdm/codegroup/CodeGroupXdmList";
	}
	
	
	
	@RequestMapping(value = "CodeGroupXdmForm")
	public String codeGroupForm(@ModelAttribute("vo") CodeGroupVo vo,CodeGroupDto codeGroupDto,Model model){
		// html에 있는 값을 자동으로 vo로 저장 dto 랑 vo.
		if(vo.getCg_id().equals("0") || vo.getCg_id().equals(" ")) {
		} else {
			model.addAttribute("item", codeGroupService.selectView(codeGroupDto));
		}
		
		return "xdm/codegroup/CodeGroupForm";
	}

	
	
	@RequestMapping(value = "CodeGroupXdmInst")
	public String codeGroupInst(CodeGroupDto codeGroupDto) {
	codeGroupService.insert(codeGroupDto);
		return "redirect:/xdm/codegroup/CodeGroupXdmList";
	}
	
	

	
	@RequestMapping(value = "CodeGroupXdmUpdate")
	public String codeGroupUpdate(CodeGroupDto codeGroupDto) {
		codeGroupService.update(codeGroupDto);
	
		return "redirect:/xdm/codegroup/CodeGroupXdmList";
	}
	
	
	
	
	@RequestMapping(value = "CodeGroupXdmUelete")
	public String codeGroupUelete(@RequestParam("cg_id") String seq) {
		   
		String[] cgIdArray = seq.split(",");
	    
	    List<Integer> cgIdList = new ArrayList<>();
	    for (String id : cgIdArray) {
	        cgIdList.add(Integer.parseInt(id));  // 각 cg_id를 Integer로 변환하여 리스트에 추가
	    }

	    // 리스트를 서비스로 전달하여 업데이트
	    codeGroupService.uelete(cgIdList);

	    return "redirect:/xdm/codegroup/CodeGroupXdmList";
	}
	
	

	
	
	
	
}
