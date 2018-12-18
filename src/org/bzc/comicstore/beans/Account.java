package org.bzc.comicstore.beans;

import java.math.BigDecimal;

public class Account {
	private String userid;

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	private String email;

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	private String firstname;

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFirstname() {
		return firstname;
	}

	private String lastname;

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLastname() {
		return lastname;
	}

	private String status;

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	private String addr1;

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr1() {
		return addr1;
	}

	private String addr2;

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getAddr2() {
		return addr2;
	}

	private String city;

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	private String state;

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	private String zip;

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getZip() {
		return zip;
	}

	private String country;

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	private String phone;

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}
	private BigDecimal balance;
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getBalance() {
		return balance;
	}
	
}
