package com.sake.module.product;

import com.sake.module.base.BaseVo;

public class FilterDto extends BaseVo{
	private Integer local;
    private Integer local_detail;
    private Integer type;
    private Integer minPrice;
    private Integer maxPrice;
    
    
    private String pd_id;
	private String name;
	private Integer brand;
	private Integer fixed_price;
	private Double total_rating;
	private String keyword;
	
	
	
	private String discount_dc_id;
	private Integer seq;
	
	
	private String shlocal;
	private String shbrand;
	private String shtype;
	
	
	
	
    
    public FilterDto(Integer local,Integer local_detail, Integer type, Integer minPrice, Integer maxPrice) {
    	this.local = local;
        this.local_detail = local_detail;
        this.type = type;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }


	public Integer getLocal_detail() {
		return local_detail;
	}

	public void setLocal_detail(Integer local_detail) {
		this.local_detail = local_detail;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Integer getLocal() {
		return local;
	}


	public void setLocal(Integer local) {
		this.local = local;
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


	public Integer getBrand() {
		return brand;
	}


	public void setBrand(Integer brand) {
		this.brand = brand;
	}


	public Integer getFixed_price() {
		return fixed_price;
	}


	public void setFixed_price(Integer fixed_price) {
		this.fixed_price = fixed_price;
	}


	public Double getTotal_rating() {
		return total_rating;
	}


	public void setTotal_rating(Double total_rating) {
		this.total_rating = total_rating;
	}


	public String getDiscount_dc_id() {
		return discount_dc_id;
	}


	public void setDiscount_dc_id(String discount_dc_id) {
		this.discount_dc_id = discount_dc_id;
	}


	public Integer getSeq() {
		return seq;
	}


	public void setSeq(Integer seq) {
		this.seq = seq;
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


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
    
    
    
}
