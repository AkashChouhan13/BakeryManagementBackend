package com.akash.project.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User 
{
	@Id
	private String emailId;
	
	private String name;
	
	private String otp;
	
	private Long contact;
	
	
	private String homeNo;
	
	private String colony;
	
	private String area;
	
	private String district;
	
	private String near;

	private String password;
	
	private boolean isEnable;

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ",isEnable = "+ isEnable + ", name=" + name + ", otp=" + otp + ", contact=" + contact + ", homeNo="
				+ homeNo + ", colony=" + colony + ", area=" + area + ", district=" + district + ", near=" + near
				+ ", password=" + password + "]";
	}

	public User(String emailId, String name, String password)
	{
		this.emailId = emailId;
		this.name = name;
		this.password = password;
	}
	
	public User() {}
	
	
	
	
//	--------------------------------

	
	
	
	

	public boolean getisEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String link) {
		this.otp = link;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getHomeNo() {
		return homeNo;
	}

	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}

	public String getColony() {
		return colony;
	}

	public void setColony(String colony) {
		this.colony = colony;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getNear() {
		return near;
	}

	public void setNear(String near) {
		this.near = near;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
	
	
}
