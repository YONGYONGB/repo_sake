package com.sake.module.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class ProductController {

	@Autowired
	ProductService productservice;
	
	@RequestMapping(value = "productXdmList")
	public String productXdmList(@ModelAttribute("vo") ProductVo vo,Model model) {
		
		vo.setParamsPaging(productservice.selectOneCount(vo));
		model.addAttribute("list", productservice.selectList(vo));
		return "xdm/product/ProductXdmList";
	}
	
	
	@RequestMapping(value ="productXdmForm")
	public String productXdmForm() {
		return "xdm/product/ProductXdmForm";
	}
	
}
