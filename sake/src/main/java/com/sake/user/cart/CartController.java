package com.sake.user.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sake.user.base.UserBaseController;


@Controller
@RequestMapping(value="/user/cart/")
public class CartController extends UserBaseController{

	@RequestMapping(value="Wishlist")
	public String Wishlist() {
		return "/user/cart/Wishlist";
	}
	
	
	
	@RequestMapping(value="ShoppingCart")
	public String ShoppingCart() {
		return "/user/cart/ShoppingCart";
	}
	
	
	@RequestMapping(value="cartInsert")
	public String cartInsert(@RequestParam String seq) {
		String[] values = seq.split(",");
		String pdId = values[0]; 
		int productQuality = Integer.parseInt(values[1]);
		int price= Integer.parseInt(values[2]);
		
		return new String();
	}
	
	
	
}
