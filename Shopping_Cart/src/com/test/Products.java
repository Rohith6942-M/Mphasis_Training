package com.test;

public class Products {
	
	private int id;
	private String p_name;
	private String category;
	private int price;
	
	public Products()
	{
		
	}
	
	public Products(int id, String p_name, String category, int price) {
		this.id = id;
		this.p_name = p_name;
		this.category = category;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Products [id=" + id + ", p_name=" + p_name + ", category=" + category + ", price=" + price + "]";
	}
	

}
