package com.sake.module.product;

public class ProductDto {

	private String product_id;
	private String name;
	private Integer local;
	private Integer detail_local;
	private Integer brand;
	private Integer type;
	private Boolean capacity;
	private Integer liquor;
	private Integer fixed_price;
	private Boolean discountNY;
	private Integer product_number;
	
	private Double discount_rate;
	private String discount_dateS;
	private String discount_dateF;

	
	//  - - - - -
	
	
	
	public String getProduct_id() {
		return product_id;
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
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
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
	public Integer getDetail_local() {
		return detail_local;
	}
	public void setDetail_local(Integer detail_local) {
		this.detail_local = detail_local;
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
	public Boolean getCapacity() {
		return capacity;
	}
	public void setCapacity(Boolean capacity) {
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
	public Boolean getDiscountNY() {
		return discountNY;
	}
	public void setDiscountNY(Boolean discountNY) {
		this.discountNY = discountNY;
	}
	public Integer getProduct_number() {
		return product_number;
	}
	public void setProduct_number(Integer product_number) {
		this.product_number = product_number;
	}
	
	

	
}
