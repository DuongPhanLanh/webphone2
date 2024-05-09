package com.entity;

public class user {
	private int id;
	private String name;
	private String gmail;
	private String password;
	private String phone;
	
	public user() {
		// TODO Auto-generated constructor stub
	}

	public user(String name, String gmail, String password, String phone) {
		super();
		this.name = name;
		this.gmail = gmail;
		this.password = password;
		this.phone = phone;
	}

	public user(int id, String name, String gmail, String password, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.gmail = gmail;
		this.password = password;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", gmail=" + gmail + ", password=" + password + ", phone=" + phone
				+ "]";
	}
	
	
}