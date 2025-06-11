package com.sake.module.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		String shValue = vo.getShValue();
		model.addAttribute("list", seq);
		model.addAttribute("seq", seq);
		model.addAttribute("shValue", shValue);
		return "user/product/sakeMenu";
	}
	
	
	
	//처음 값 보여주기
	@GetMapping("filter")
	public String sakefilter(ProductVo vo, Model model){
		Integer seq = vo.getSeq();
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
		return "user/product/_productlist :: productFragment";  // 상품 리스트만 업데이트
	}
	
	//필터링
	@RequestMapping(value="addfilter")
	public String filterProduct(
	    @RequestParam(name = "shValue", required = false) String shValue,
	    @RequestParam(name = "seq", required = false) Integer seq,
	    @RequestParam(name = "local_detail", required = false) Integer localDetail,
	    @RequestParam(name = "local", required = false) Integer local,
	    @RequestParam(name = "type", required = false) Integer type,
	    @RequestParam(name = "minPrice", required = false) Integer minPrice,
	    @RequestParam(name = "maxPrice", required = false) Integer maxPrice,
	    @RequestParam(name = "thisPage", required = false, defaultValue = "1") int thisPage,
	    Model model
	) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2");
		System.out.println("local param: " + local);
		System.out.println("local_detail param: " + localDetail);

		FilterDto filterDTO = new FilterDto(local, localDetail, type, minPrice, maxPrice);
		System.out.println("FilterDTO local: " + filterDTO.getLocal());
		System.out.println("FilterDTO localDetail: " + filterDTO.getLocal_detail());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2");
	    filterDTO.setThisPage(thisPage);

	    if (shValue != null && !shValue.isEmpty()) {
	        filterDTO.setKeyword(shValue);
	    }
	    
	    if (seq != null) {
	    	if(seq >= 3 && seq <= 10 && filterDTO.getLocal() == null) {
	            filterDTO.setLocal(seq);
	        } else if(seq >= 80 && seq <= 129 && filterDTO.getLocal_detail() == null) {
	            filterDTO.setLocal_detail(seq);
	        } else if(seq >= 11 && seq <= 19 && filterDTO.getType() == null) {
	            filterDTO.setType(seq);
	        }
	    }
	    

	    
	    filterDTO.setMinPrice(minPrice);
	    filterDTO.setMaxPrice(maxPrice);
	    
	    int totalCount = service.filterProductCount(filterDTO);
	    filterDTO.setParamsPaging(totalCount);

	    List<ProductDto> items = service.filterProducts(filterDTO);
	    


	    System.out.println("  minPrice: " + minPrice);
	    System.out.println("  maxPrice: " + maxPrice);
	    System.out.println("  thisPage: " + thisPage);
	    System.out.println("");
	    System.out.println("FilterDto State After Setting:");
	    System.out.println(filterDTO.toString()); // FilterDto의 toString() 메서드 출력
	    System.out.println("-------------------------------------");

	    model.addAttribute("items", items);
	    model.addAttribute("ProductVo", filterDTO);
	    
	    return "user/product/_productlist :: productFragment";
	}
	
	
	
	

	
	///////
	// 사케제품
	///////
	@RequestMapping(value="sakeProduct")
	public String sakeProduct(ProductDto dto,ProductVo vo,Model model){
		dto.setPd_id(vo.getPd_id());
		model.addAttribute("item", productservice.selectView(dto));
		
		return "user/product/sakeProduct";
	}
}
