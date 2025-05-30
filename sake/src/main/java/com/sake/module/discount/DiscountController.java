package com.sake.module.discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sake.module.base.BaseController;
import com.sake.module.code.CodeDto;
import com.sake.module.code.CodeVo;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping(value="/xdm/discount/")
public class DiscountController extends BaseController{

	@Autowired
	DiscountService discountService;
	
	@RequestMapping(value = "DiscountXdmList")
	public String DiscountXdmList(@ModelAttribute("vo") DiscountVo vo,Model model) {
		addEnd(vo);
		model.addAttribute("vo", vo);
		vo.setParamsPaging(discountService.selectOneCount(vo));
		model.addAttribute("list", discountService.selectList(vo));
		return "xdm/discount/DiscountXdmList";
	}
	
	
	@RequestMapping(value = "DiscountXdmForm")
	public String DiscountXdmForm(@ModelAttribute("vo") DiscountVo vo, DiscountDto discountDto, Model model)throws Exception{
		
		if (vo.getDc_id().equals("0") || vo.getDc_id().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", discountService.selectView(discountDto));
		}
		
		return "xdm/discount/DiscountXdmForm";
	}
	
	@RequestMapping( value = "DiscountXdmInsert")
	public String DiscountXdmInsert(DiscountDto discountDto) {
		System.out.println(discountDto.getDc_id());
		discountService.insert(discountDto);
//		System.out.println(discountDto.getDc_id());
		return "redirect:/xdm/discount/DiscountXdmList";
	}
	
	@RequestMapping( value = "DiscountXdmUpdate")
	public String DiscountXdmUpdate(DiscountDto discountDto) {
		discountService.update(discountDto);
		return "redirect:/xdm/discount/DiscountXdmList";
	}
	
	
}
