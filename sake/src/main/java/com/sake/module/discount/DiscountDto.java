package com.sake.module.discount;

import java.time.LocalDateTime;

public class DiscountDto {
	
	private String dc_id;
	private Integer dc_use;
	private String discount_name;
	private Double discount_rate;
	private	String discount_dateS;
	private String discount_dateF;
	
	
	public String getDc_id() {
		return dc_id;
	}
	public void setDc_id(String dc_id) {
		this.dc_id = dc_id;
	}
	public String getDiscount_name() {
		return discount_name;
	}
	public void setDiscount_name(String discount_name) {
		this.discount_name = discount_name;
	}
	public Double getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(Double discount_rate) {
		this.discount_rate = discount_rate;
	}
	public String getDiscount_dateS() {
		return discount_dateS;
	}
	public void setDiscount_dateS(String discount_dateS) {
		this.discount_dateS = discount_dateS;
	}
	public String getDiscount_dateF() {
		return discount_dateF;
	}
	public void setDiscount_dateF(String discount_dateF) {
		this.discount_dateF = discount_dateF;
	}
	public Integer getDc_use() {
		return dc_use;
	}
	public void setDc_use(Integer dc_use) {
		this.dc_use = dc_use;
	}
	
	
	
}
