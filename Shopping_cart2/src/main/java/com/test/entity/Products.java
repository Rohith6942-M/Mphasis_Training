package com.test.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 15, nullable = false)
	private String p_name;
	@Column(length = 15, nullable = false)
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

	@Override
	public int hashCode() {
		return Objects.hash(category, id, p_name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return Objects.equals(category, other.category) && id == other.id && Objects.equals(p_name, other.p_name)
				&& price == other.price;
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
