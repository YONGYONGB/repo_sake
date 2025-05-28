package com.sake.user.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

	@Autowired
	CartDao dao;
	
	public List<CartDto> cartList(CartDto dto){
		return dao.cartList(dto);
	}
	
	public int cartInsert(CartDto dto) {
		return dao.cartInsert(dto);
	}
	
	public int cartDelete(String cart_id) {
		return dao.cartDelete(cart_id);
	}
	public int getCount(String user_user_id) {
		return dao.getCount(user_user_id);
	}
}
