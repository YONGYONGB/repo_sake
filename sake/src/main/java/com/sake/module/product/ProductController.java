package com.sake.module.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sake.module.base.BaseController;





@Controller
@RequestMapping(value="/xdm/product/")
public class ProductController extends BaseController{

	@Autowired
	ProductService productservice;
	
	
	
	@RequestMapping(value = "ProductXdmList")
	public String productXdmList(@ModelAttribute("vo") ProductVo vo,Model model) {
		
		addEnd(vo);
		
		vo.setParamsPaging(productservice.selectOneCount(vo));
		model.addAttribute("list", productservice.selectList(vo));
		return "/xdm/product/ProductXdmList";
	}
	
	
	@RequestMapping(value ="ProductXdmForm")
	public String productXdmForm(@ModelAttribute("vo") ProductVo vo, ProductDto dto, Model model)throws Exception{
	
		model.addAttribute("lists", productservice.dcView());
	
		if (vo.getPd_id().equals("0") || vo.getPd_id().equals("")) {
//			insert mode
		
		} else {
//			update mode
			model.addAttribute("item", productservice.selectView(dto));
		}
		return "/xdm/product/ProductXdmForm";
	}
	
	@RequestMapping(value="ProductXdmInsert")
	public String productXdmInsert(ProductDto dto) throws Exception{
		productservice.insert(dto);
		return "redirect:/xdm/product/ProductXdmList";
	}
	
	@RequestMapping(value="ProductXdmUpdate")
	public String productXdmUpdate(@RequestParam("ld") Integer ld,ProductDto dto) throws Exception{
		if(dto.getLocal_detail()== null){
			dto.setLocal_detail(ld);
		}
		productservice.update(dto);
		return "redirect:/xdm/product/ProductXdmList";
	}
	
	@RequestMapping(value="ProductXdmUelete")
	public String ProductXdmUelete(@RequestParam("pd_id") List<Integer>pdIdList) {
		productservice.uelete(pdIdList);
		return "redirect:/xdm/product/ProductXdmList";
	}
	
	
	// 자바스크립트 local_detail을 위한
	@ResponseBody
	@RequestMapping(value="Productlocaldetail")
    public List<ProductDto> getChildCodes(@RequestParam("cd_id") String cd_id) {
        return productservice.localcheck(cd_id);
    }
	
	
	
}
