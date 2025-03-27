package com.sake.module.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




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
	public String productXdmForm(@ModelAttribute("vo") ProductVo vo, ProductDto dto, Model model)throws Exception{
	
		model.addAttribute("lists", productservice.dcView());
	
		if (vo.getPd_id().equals("0") || vo.getPd_id().equals("")) {
//			insert mode
		
		} else {
//			update mode
			model.addAttribute("item", productservice.selectView(dto));
		}
		return "xdm/product/ProductXdmForm";
	}
	
	@RequestMapping(value="productXdmInsert")
	public String productXdmInsert(ProductDto dto) {
		productservice.insert(dto);
		return "redirect:/productXdmList";
	}
	
	
}
