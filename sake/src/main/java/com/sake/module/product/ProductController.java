package com.sake.module.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ProductController {

	@Autowired
	ProductService productservice;
	
	@RequestMapping(value = "productXdmList")
	public String productXdmList(Model model, ProductVo productVo) {
		
		productVo.setParamsPaging(productservice.selectOneCount());
		model.addAttribute("list", productservice.selectList(productVo));
		model.addAttribute("vo",productVo);
		
		return "xdm/product/ProductXdmList";
	}
	
	
	@RequestMapping(value ="productXdmForm")
	public String productXdmForm() {
		return "xdm/product/ProductXdmForm";
	}
	
}
