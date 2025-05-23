package com.sake.module.product;

public class FilterDto {
	private Integer local;
    private Integer local_detail;
    private Integer type;
    private Integer minPrice;
    private Integer maxPrice;
    
    public FilterDto(Integer local_detail, Integer type, Integer minPrice, Integer maxPrice) {
 
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
    
    
    
}
