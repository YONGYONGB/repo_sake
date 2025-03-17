package com.sake.module.code;

public class CodeDto {

	private String cd_id;
	private Boolean cd_use;
	
	private String cg_id;
	private Integer cg_code;
	private String cg_name;
	private String cd_name;
	private Integer cd_order;
	private Integer codeGroup_cg_id;
	
	
	//-----
	
	
	public String getCd_id() {
		return cd_id;
	}
	public String getCg_id() {
		return cg_id;
	}
	public void setCg_id(String cg_id) {
		this.cg_id = cg_id;
	}
	public void setCd_id(String cd_id) {
		this.cd_id = cd_id;
	}
	public Boolean getCd_use() {
		return cd_use;
	}
	public void setCd_use(Boolean cd_use) {
		this.cd_use = cd_use;
	}
	
	public Integer getCg_code() {
		return cg_code;
	}
	public void setCg_code(Integer cg_code) {
		this.cg_code = cg_code;
	}
	public String getCg_name() {
		return cg_name;
	}
	public void setCg_name(String cg_name) {
		this.cg_name = cg_name;
	}
	public String getCd_name() {
		return cd_name;
	}
	public void setCd_name(String cd_name) {
		this.cd_name = cd_name;
	}
	public Integer getCd_order() {
		return cd_order;
	}
	public void setCd_order(Integer cd_order) {
		this.cd_order = cd_order;
	}
	public Integer getCodeGroup_cg_id() {
		return codeGroup_cg_id;
	}
	public void setCodeGroup_cg_id(Integer codeGroup_cg_id) {
		this.codeGroup_cg_id = codeGroup_cg_id;
	}
	
	

	
	
	
	
}
