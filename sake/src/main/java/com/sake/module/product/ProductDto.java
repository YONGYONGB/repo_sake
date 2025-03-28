package com.sake.module.product;

public class ProductDto {

	private String pd_id;
	private String name;
	private Integer local;
	private Integer local_detail;
	private Integer brand;
	private Integer type;
	private Integer capacity;
	private Integer liquor;
	private Integer fixed_price;
	private Integer discountNY;
	private Integer product_number;
	private String discount_dc_id;
	
	private String dc_id;
	private String discount_name;
	private Double discount_rate;
	private String discount_dateS;
	private String discount_dateF;

	
	//  - - - - -
	
	
	
	public String getPd_id() {
		return pd_id;
	}
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
	public String getDiscount_dc_id() {
		return discount_dc_id;
	}
	public void setDiscount_dc_id(String discount_dc_id) {
		this.discount_dc_id = discount_dc_id;
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
	public void setPd_id(String pd_id) {
		this.pd_id = pd_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLocal() {
		return local;
	}
	public void setLocal(Integer local) {
		this.local = local;
	}
	public Integer getLocal_detail() {
		return local_detail;
	}
	public void setLocal_detail(Integer local_detail) {
		this.local_detail = local_detail;
	}
	public Integer getBrand() {
		return brand;
	}
	public void setBrand(Integer brand) {
		this.brand = brand;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getLiquor() {
		return liquor;
	}
	public void setLiquor(Integer liquor) {
		this.liquor = liquor;
	}
	public Integer getFixed_price() {
		return fixed_price;
	}
	public void setFixed_price(Integer fixed_price) {
		this.fixed_price = fixed_price;
	}
	public Integer getDiscountNY() {
		return discountNY;
	}
	public void setDiscountNY(Integer discountNY) {
		this.discountNY = discountNY;
	}
	public Integer getProduct_number() {
		return product_number;
	}
	public void setProduct_number(Integer product_number) {
		this.product_number = product_number;
	}
	
	

	
}
