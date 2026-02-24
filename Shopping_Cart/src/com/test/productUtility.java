package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class productUtility { 
	
	ArrayList<Products> cart = new ArrayList<>(); 
	Products p = new Products();
	public ArrayList<Products> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Products> cart) {
		this.cart = cart;
	}

	public void addToCart(int int1, String string, String string2, int int2) {
		// TODO Auto-generated method stub
		cart.add(new Products(int1,string,string2,int2));
	}
	
	public void display()
	{
		for(Products pd :cart)
		{
			System.out.println(pd);
		}
	}
	
	public void removeFromCart(int id)
	{
		boolean removed = false;
		if (cart.isEmpty()) { 
			System.out.println("Cart is empty."); 
		} 
		else { 
			removed = cart.removeIf(p -> p.getId() == id); 
			System.out.println("Product with ID " + id + " removed successfully.");
			}
			if (!removed)
			{
				System.out.println("Product with ID " + id + " removal unsuccessful.");
			}
		} 
	
	public void calculatePrice()
	{
		int sum=0; 
		for(Products pd :cart)
		{
			sum = sum + pd.getPrice();
		}
		if(cart.isEmpty())
		{
			System.out.println("Cart empty");
		}
		else
		{
			System.out.println("total : "+ sum);
		}
	}
	
	public void sortUsingProductName()
	{
		if(cart == null)
		{
			System.out.println("Cart empty");
		}
		else
		{
		Collections.sort(cart, Comparator.comparing(p -> p.getP_name()));
		System.out.println("Cart sorted by product name:"); 
		display();
		}
	}
	
	public void sortUsingPrice()
	{
		if(cart == null)
		{
			System.out.println("Cart empty");
		}
		else
		{
			Collections.sort(cart, Comparator.comparingInt(Products::getPrice)); 
			System.out.println("Cart sorted by price:");
			display();
		}
		
	}
	
	public void getHighestAndLowestPrice()
	{
		if (cart.isEmpty()){
			System.out.println("Cart is empty.");
			return; 
			} 
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;
		Products lowestProduct = null;
		Products highestProduct = null;
		for (Products pd : cart){
			int price = pd.getPrice();
			if (price < low){ 
				low = price;
				lowestProduct = pd;
				} 
			if (price > high){
				high = price;
				highestProduct = pd;
				} 
			} 
		System.out.println("Lowest priced product: " + lowestProduct);
		System.out.println("Highest priced product: " + highestProduct);
	}
}
