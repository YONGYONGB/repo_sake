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
	
	@Autowired
	ProductService productservice;
	
	///////
	// 메뉴
	///////
	@RequestMapping(value="sakeMenu")
	public String sakeMenu(ProductVo vo, Model model){
		Integer seq = vo.getSeq();
		model.addAttribute("list", seq);
		model.addAttribute("items", service.typeList(seq.toString()));
		if(seq>= 3 && seq<=10) {
			model.addAttribute("items", service.localList(seq.toString()));
		}else if(seq>= 11 && seq<=19) {
			model.addAttribute("items", service.typeList(seq.toString()));
		}else if(seq>=81 && seq <=129) {
			model.addAttribute("items", service.localDetailList(seq.toString()));
		}	
		return "/user/product/sakeMenu";
	}
	///////
	// 사케제품
	///////
	@RequestMapping(value="sakeProduct")
	public String sakeProduct(ProductDto dto,ProductVo vo,Model model){
		dto.setPd_id(vo.getPd_id());
		model.addAttribute("item", productservice.selectView(dto));
		
		return "/user/product/sakeProduct";
	}
}
