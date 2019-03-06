package com.pack.model;

public class Product {
	private String pname,brand,category,pid,description;
	private float rating,price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String pid,String pname, String brand, String category, float rating, float price,String description) {
		super();
		this.pid=pid;
		this.pname = pname;
		this.brand = brand;
		this.category = category;
		this.rating = rating;
		this.price = price;
		this.description=description;
	}
	
	public Product(String pid,String pname,String brand, String category, String description, float price) {
		super();
		this.pname = pname;
		this.category = category;
		this.pid = pid;
		this.description = description;
		this.price = price;
		this.brand=brand;
	}
	
	public Product(String pname,String brand, String category, String description, float price) {
		super();
		this.pname = pname;
		this.category = category;
		this.brand=brand;
		//this.pid = pid;
		this.description = description;
		this.price = price;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
