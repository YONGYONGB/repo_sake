package com.sake.module.codegroup;

public class CodeGroupDto {

	private String cg_id;
	private Boolean cg_use;
	private String cg_name;
	private Integer cg_order;
	
	
	
	//--------------
	
	public String getCg_id() {
		return cg_id;
	}
	public void setCg_id(String cg_id) {
		this.cg_id = cg_id;
	}
	public Boolean getCg_use() {
		return cg_use;
	}
	public void setCg_use(Boolean cg_use) {
		this.cg_use = cg_use;
	}
	
	public String getCg_name() {
		return cg_name;
	}
	public void setCg_name(String cg_name) {
		this.cg_name = cg_name;
	}
	public Integer getCg_order() {
		return cg_order;
	}
	public void setCg_order(Integer cg_order) {
		this.cg_order = cg_order;
	}
	
	
	
}
