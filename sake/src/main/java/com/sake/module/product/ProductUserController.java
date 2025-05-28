package com.sake.module.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("seq", seq);
		
		if(seq>= 3 && seq<=10) {
			vo.setParamsPaging(service.countlocalList(seq, vo));
			model.addAttribute("ProductVo", vo);
			model.addAttribute("items", service.localList(seq,vo));
		}else if(seq>= 11 && seq<=19) {
			vo.setParamsPaging(service.counttypeList(seq, vo));
			model.addAttribute("ProductVo", vo);
			model.addAttribute("items", service.typeList(seq,vo));
		}else if(seq>=80 && seq <=129) {
			vo.setParamsPaging(service.countlocalDetailList(seq,vo));
			model.addAttribute("ProductVo", vo);
			model.addAttribute("items", service.localDetailList(seq,vo));
		}	
		return "/user/product/sakeMenu";
	}
	/////
	//필터링
	@RequestMapping(value="filter")
	public String filterProducts(
			@RequestParam(name = "seq", required = false) Integer seq,
	        @RequestParam(name = "local_detail", required = false) Integer localDetail,
	        @RequestParam(name = "type", required = false) Integer type,
	        @RequestParam(name = "minPrice", required = false) Integer minPrice,
	        @RequestParam(name = "maxPrice", required = false) Integer maxPrice,
	        ProductVo vo,
	        Model model) {
//		model.addAttribute("ProductVo", vo);
	    // FilterDTO에 필터 조건을 묶어 서비스로 전달
		FilterDto filterDTO = new FilterDto(localDetail, type, minPrice, maxPrice);
		if (seq != null) {
			if(seq>= 3 && seq<=10){
				filterDTO.setLocal(seq);
			}else if(seq>=80 && seq <=129){
				filterDTO.setLocal_detail(seq);
			}else if(seq>= 11 && seq<=19) {
				filterDTO.setType(seq);
			}
		}
	    // 필터링된 상품 리스트 가져오기
	    List<ProductDto> items = service.filterProducts(filterDTO);

	    model.addAttribute("items", items);

	    return "user/product/_productList :: #product-list";  // 상품 리스트만 업데이트
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
