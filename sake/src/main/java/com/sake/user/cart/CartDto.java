package com.sake.user.cart;

import com.sake.module.base.BaseDto;

public class CartDto extends BaseDto{

	private String cart_id;
	private Integer cart_price;
	private Integer cart_quantity;
	private String product_pd_id;
	private String user_user_id;
	private String cart_regDate;
	
	
	private String pd_id;
	private String name;
	private Integer pd_quantity;
	
	private String user_id;
	

	public String getCart_id() {
		return cart_id;
	}


	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}


	public Integer getCart_price() {
		return cart_price;
	}


	public void setCart_price(Integer cart_price) {
		this.cart_price = cart_price;
	}


	public Integer getCart_quantity() {
		return cart_quantity;
	}


	public void setCart_quantity(Integer cart_quantity) {
		this.cart_quantity = cart_quantity;
	}


	public String getProduct_pd_id() {
		return product_pd_id;
	}


	public void setProduct_pd_id(String product_pd_id) {
		this.product_pd_id = product_pd_id;
	}


	public String getUser_user_id() {
		return user_user_id;
	}


	public void setUser_user_id(String user_user_id) {
		this.user_user_id = user_user_id;
	}


	public String getPd_id() {
		return pd_id;
	}


	public void setPd_id(String pd_id) {
		this.pd_id = pd_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getCart_regDate() {
		return cart_regDate;
	}


	public void setCart_regDate(String cart_regDate) {
		this.cart_regDate = cart_regDate;
	}


	public Integer getPd_quantity() {
		return pd_quantity;
	}


	public void setPd_quantity(Integer pd_quantity) {
		this.pd_quantity = pd_quantity;
	}
	
	
	
	
	
	
	
	
}
