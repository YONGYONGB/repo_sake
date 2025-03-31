package com.sake.module.product;

import com.sake.module.share.Menu;

public class ProductVo extends Menu{

	private String pd_id;
	private String discount_dc_id;
	
	

	public String getDiscount_dc_id() {
		return discount_dc_id;
	}

	public void setDiscount_dc_id(String discount_dc_id) {
		this.discount_dc_id = discount_dc_id;
	}

	public String getPd_id() {
		return pd_id;
	}

	public void setPd_id(String pd_id) {
		this.pd_id = pd_id;
	}
	
	
}
