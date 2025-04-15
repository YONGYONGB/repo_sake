package com.sake.module.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sake.user.base.UserBaseController;

@Controller
@RequestMapping(value="/user/product/")
public class ProductUserController extends UserBaseController{

	@RequestMapping(value="sakeType")
	public String sakeType(ProductVo vo, Model model){
		Integer seq = vo.getSeq();
		model.addAttribute("list", seq);
		return "/user/product/sakeType";
	}
	
	@RequestMapping(value="sakeLocal")
	public String sakeLocal(ProductVo vo, Model model){
		Integer seq = vo.getSeq();
		model.addAttribute("list", seq);
		return "/user/product/sakeLocal";
	}
	
	
}
