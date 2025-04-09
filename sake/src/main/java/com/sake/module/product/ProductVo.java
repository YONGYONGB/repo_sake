package com.sake.module.product;

import com.sake.module.base.BaseVo;

public class ProductVo extends BaseVo{

	private String pd_id;
	private String discount_dc_id;
	private Integer seq;
	
	
	private String shlocal;
	private String shbrand;
	private String shtype;
	

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

	public String getShlocal() {
		return shlocal;
	}

	public void setShlocal(String shlocal) {
		this.shlocal = shlocal;
	}

	public String getShbrand() {
		return shbrand;
	}

	public void setShbrand(String shbrand) {
		this.shbrand = shbrand;
	}

	public String getShtype() {
		return shtype;
	}

	public void setShtype(String shtype) {
		this.shtype = shtype;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	
	
	
	
	
}
