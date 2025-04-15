package com.sake.module.product;

import java.time.LocalDateTime;
import java.util.List;

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
	private Integer pd_use;
	private String pd_regiDate;
	private String pd_modiDate;
	
	private String dc_id;
	private String discount_name;
	private Double discount_rate;
	private String discount_dateS;
	private String discount_dateF;

	
	private String cd_id;
    private String cd_name;
	
	private List<Integer> pdIds;
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
	public Integer getPd_use() {
		return pd_use;
	}
	public void setPd_use(Integer pd_use) {
		this.pd_use = pd_use;
	}
	public String getPd_regiDate() {
		return pd_regiDate;
	}
	public void setPd_regiDate(String pd_regiDate) {
		this.pd_regiDate = pd_regiDate;
	}
	public String getPd_modiDate() {
		return pd_modiDate;
	}
	public void setPd_modiDate(String pd_modiDate) {
		this.pd_modiDate = pd_modiDate;
	}
	public List<Integer> getPdIds() {
		return pdIds;
	}
	public void setPdIds(List<Integer> pdIds) {
		this.pdIds = pdIds;
	}
	public String getCd_id() {
		return cd_id;
	}
	public void setCd_id(String cd_id) {
		this.cd_id = cd_id;
	}
	public String getCd_name() {
		return cd_name;
	}
	public void setCd_name(String cd_name) {
		this.cd_name = cd_name;
	}
	

	
	
	

	
}
