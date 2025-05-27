package com.sake.user.cart;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sake.user.account.AccountCodeDto;
import com.sake.user.account.AccountCodeService;
import com.sake.user.base.UserBaseController;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping(value="/user/cart/")
public class CartController extends UserBaseController{
	
	@Autowired
	CartService service;
	
	@Autowired
	AccountCodeService accountCodeService;
	
	

	
	
	// 화면
	@RequestMapping(value="ShoppingCart")
	public String ShoppingCart(HttpSession httpSession,CartDto dto,AccountCodeDto accountdto,Model model) {
		dto.setUser_user_id(httpSession.getAttribute("sessSeqUser").toString());
		accountdto.setUser_user_id(httpSession.getAttribute("sessSeqUser").toString());
		model.addAttribute("lists", service.cartList(dto));
		model.addAttribute("address",accountCodeService.addressList(accountdto));
		return "/user/cart/ShoppingCart";
	}
	
	// 물품 seq, 수량,가격, 정보 넘겨주기
	@RequestMapping(value="cartInsert")
	public String cartInsert(@RequestParam("seq") String seq, HttpSession httpSession, CartDto dto) {
		String[] values = seq.split(",");
		
		String pdId = values[0]; 
		int cartQuality = Integer.parseInt(values[1]);
		int price= Integer.parseInt(values[2]);
		
		dto.setProduct_pd_id(pdId);
		dto.setCart_quantity(cartQuality);
		dto.setCart_price(price);
		dto.setUser_user_id(httpSession.getAttribute("sessSeqUser").toString());
		
		service.cartInsert(dto);
		
		return "redirect:/user/cart/ShoppingCart";
	}
	
	
	//지우기s
	@RequestMapping(value="cartDelete")
	public String cartDelete(@RequestParam("cart_id") String seq, CartDto dto) {
		dto.setCart_id(seq);
		service.cartDelete(dto.getCart_id());
		return "redirect:/user/cart/ShoppingCart";
	}
	
}
