package com.sake.user.cart;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CartDao {
	
	public List<CartDto> cartList(CartDto dto);
	
	public int cartInsert(CartDto dto);
	
	public int cartDelete(String cart_id);
	
	public int getCount(String user_user_id);
}
