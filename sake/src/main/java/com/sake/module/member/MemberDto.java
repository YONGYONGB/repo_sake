package com.sake.module.member;

public class MemberDto {

	private String user_id;
	private String name; 
	private Integer gender;
	private String birthday;
	private String clearance;
	private String id;
	private String email;
	private String password;
	private String address;
	private Boolean user_delny;
	
	
	//------
	
	
	
	
	public String getUser_id() {
		return user_id;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getUser_delny() {
		return user_delny;
	}
	public void setUser_delny(Boolean user_delny) {
		this.user_delny = user_delny;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getClearance() {
		return clearance;
	}
	public void setClearance(String clearance) {
		this.clearance = clearance;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
