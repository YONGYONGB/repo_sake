package com.sake.module.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sake.user.base.UserBaseController;

@Controller
@RequestMapping(value="/user/product/")
public class ProductUserController extends UserBaseController{

	@Autowired
	ProductUserService service;
	
	@RequestMapping(value="sakeType")
	public String sakeType(ProductVo vo, Model model){
		Integer seq = vo.getSeq();
		model.addAttribute("list", seq);
		model.addAttribute("items", service.typeList(seq.toString()));
		return "/user/product/sakeType";
	}
	
	@RequestMapping(value="sakeLocal")
	public String sakeLocal(ProductVo vo, Model model){
		Integer seq = vo.getSeq();
		System.out.println(seq);
		model.addAttribute("list", seq);
		
		model.addAttribute("items", service.localList(seq.toString()));
		
		return "/user/product/sakeLocal";
	}
	
	@RequestMapping(value="sakeLocalDetail")
	public String sakeLocalDetail(ProductVo vo, Model model){
		Integer seq = vo.getSeq();
		System.out.println(seq);
		model.addAttribute("list", seq);
		
		model.addAttribute("items", service.localDetailList(seq.toString()));
		
		return "/user/product/sakeLocalDetail";
	}
	
	
}
