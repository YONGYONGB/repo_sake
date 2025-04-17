package com.sake.module.member;

import java.time.LocalDateTime;
import java.util.List;

public class MemberDto {
	// member------
	
	private String user_id;
	private String name; 
	private Integer gender;
	private String birthday;
	private String clearance;
	private String id;
	private String email;
	private String password;
	private String address;
	private Integer user_delny;
	private String user_regiDate;
	private String user_modiDate;
	
	private List<Integer> userIds;
	
	// address------
	private String ua_id;
	private String zipCode;
	private String ua_address;
	private String detailAd;
	private String reference;
	private String latitude;
	private String longitude;
	private String user_user_id;
	
	
	
	
	//--------
	
	public String getUser_id() {
		return user_id;
	}
	public String getUser_regiDate() {
		return user_regiDate;
	}
	public void setUser_regiDate(String user_regiDate) {
		this.user_regiDate = user_regiDate;
	}
	public String getUser_modiDate() {
		return user_modiDate;
	}
	public void setUser_modiDate(String user_modiDate) {
		this.user_modiDate = user_modiDate;
	}
	public List<Integer> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}
	@Override
	public String toString() {
		return "MemberDto [user_id=" + user_id + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday
				+ ", clearance=" + clearance + ", id=" + id + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", user_delny=" + user_delny + "]";
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
	public Integer getUser_delny() {
		return user_delny;
	}
	public void setUser_delny(Integer user_delny) {
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
	public String getUa_id() {
		return ua_id;
	}
	public void setUa_id(String ua_id) {
		this.ua_id = ua_id;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getUa_address() {
		return ua_address;
	}
	public void setUa_address(String ua_address) {
		this.ua_address = ua_address;
	}
	public String getDetailAd() {
		return detailAd;
	}
	public void setDetailAd(String detailAd) {
		this.detailAd = detailAd;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getUser_user_id() {
		return user_user_id;
	}
	public void setUser_user_id(String user_user_id) {
		this.user_user_id = user_user_id;
	}
	
	
	
}
