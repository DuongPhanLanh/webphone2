package com.entity;

public class product {
	private int id;
	private String name;
	private String img;
	private String category;
	private String description;
	private int stock;
	private double price;
	private double discount;
	private double totalPrice;
	
	private String gmail;
	
	
	public product() {
		// TODO Auto-generated constructor stub
	}


	

	public product(String name, int stock, String category, String description, double price, String img,
			String gmail) {
		super();
		this.name = name;
		this.stock = stock;
		this.category = category;
		this.description = description;
		this.price = price;
		this.img = img;
		this.gmail = gmail;
	}




	public product(int id, String name, int stock, String category, String description, double price, double discount,
			String img, double totalPrice, String gmail) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.category = category;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.img = img;
		this.totalPrice = totalPrice;
		this.gmail=gmail;
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




	public String getImg() {
		return img;
	}




	public void setImg(String img) {
		this.img = img;
	}




	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public int getStock() {
		return stock;
	}




	public void setStock(int stock) {
		this.stock = stock;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public double getDiscount() {
		return discount;
	}




	public void setDiscount(double discount) {
		this.discount = discount;
	}




	public double getTotalPrice() {
		return totalPrice;
	}




	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}




	public String getGmail() {
		return gmail;
	}




	public void setGmail(String gmail) {
		this.gmail = gmail;
	}




	@Override
	public String toString() {
		return "product [id=" + id + ", name=" + name + ", img=" + img + ", category=" + category + ", description="
				+ description + ", stock=" + stock + ", price=" + price + ", discount=" + discount + ", totalPrice="
				+ totalPrice + ", gmail=" + gmail + "]";
	}


	

	
	
	


	
	
}
