package com.sake.module.order;

import java.util.List;

import com.sake.module.base.BaseDto;

public class OrderDto extends BaseDto{
	private String paymentKey;
    private String orderId;
    private String status;
    
    private String od_id;
    private int all_payment;
    private int sum;
    private String od_date;
    private String user_user_id; 
    
    private String pd_id;
    private String op_id;
    
    private String name;
    
    private int product_quantity;
    
    private List<String> odIdList;
    
    
	public String getPaymentKey() {
		return paymentKey;
	}
	public void setPaymentKey(String paymentKey) {
		this.paymentKey = paymentKey;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOd_id() {
		return od_id;
	}
	public void setOd_id(String od_id) {
		this.od_id = od_id;
	}
	public int getAll_payment() {
		return all_payment;
	}
	public void setAll_payment(int all_payment) {
		this.all_payment = all_payment;
	}
	public String getOd_date() {
		return od_date;
	}
	public void setOd_date(String od_date) {
		this.od_date = od_date;
	}
	public String getUser_user_id() {
		return user_user_id;
	}
	public void setUser_user_id(String user_user_id) {
		this.user_user_id = user_user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getOdIdList() {
		return odIdList;
	}
	public void setOdIdList(List<String> odIdList) {
		this.odIdList = odIdList;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getPd_id() {
		return pd_id;
	}
	public void setPd_id(String pd_id) {
		this.pd_id = pd_id;
	}
	public String getOp_id() {
		return op_id;
	}
	public void setOp_id(String op_id) {
		this.op_id = op_id;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	
    
	
	
    
}
