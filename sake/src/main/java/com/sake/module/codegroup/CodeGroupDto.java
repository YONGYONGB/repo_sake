package com.sake.module.codegroup;

import java.time.LocalDateTime;
import java.util.List;

public class CodeGroupDto {

	private String cg_id;
	private Integer cg_use;
	private String cg_name;
	private Integer cg_order;
	private Integer cg_delny;
	
	private Integer xcd_count;
	
	private LocalDateTime cg_register;
	private LocalDateTime cg_modifDate;
	
	private List<Integer> cgIds;
	
	
	//--------------
	
	
	
	public String getCg_id() {
		return cg_id;
	}
	public List<Integer> getCgIds() {
		return cgIds;
	}
	public void setCgIds(List<Integer> cgIds) {
		this.cgIds = cgIds;
	}
	public void setCg_id(String cg_id) {
		this.cg_id = cg_id;
	}
	public Integer getCg_use() {
		return cg_use;
	}
	public void setCg_use(Integer cg_use) {
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
	public Integer getXcd_count() {
		return xcd_count;
	}
	public void setXcd_count(Integer xcd_count) {
		this.xcd_count = xcd_count;
	}
	
	public Integer getCg_delny() {
		return cg_delny;
	}
	public void setCg_delny(Integer cg_delny) {
		this.cg_delny = cg_delny;
	}
	public LocalDateTime getCg_register() {
		return cg_register;
	}
	public void setCg_register(LocalDateTime cg_register) {
		this.cg_register = cg_register;
	}
	public LocalDateTime getCg_modifDate() {
		return cg_modifDate;
	}
	public void setCg_modifDate(LocalDateTime cg_modifDate) {
		this.cg_modifDate = cg_modifDate;
	}
	
	
	
	
}
