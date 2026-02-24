package com.test;

import java.util.Scanner;
public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		productUtility pu = new productUtility();
		while(true) {
		System.out.println("1.Add a product in cart");
		System.out.println("2.Displaying products in cart");
		System.out.println("3.Remove a product in cart");
		System.out.println("4.Calculate total price");
		System.out.println("5.Sort using price in ascending order");
		System.out.println("6.Sort using product name in ascending order");
		System.out.println("7.Display the products with lowest and highest price");
		System.out.println("8.Exit");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice)
		{
		case 1:
			System.out.println("Enter the product");
			String product = sc.nextLine();
			product.trim();
			String c[] = product.split(" ");
			pu.addToCart(Integer.parseInt(c[0]),c[1],c[2],Integer.parseInt(c[3]));
			System.out.println("product added");
			break;
		case 2:
			System.out.println("Displaying the products");
			pu.display();
			break;
		case 3:
			System.out.println("Enter the product id to remove");
			int id = sc.nextInt();
			pu.removeFromCart(id);
			break;
		case 4:
			pu.calculatePrice();
			break;
		case 5:
			pu.sortUsingPrice();
			break;
		case 6:
			pu.sortUsingProductName();
			break;
		case 7:
			pu.getHighestAndLowestPrice();
			break;
		case 8:
			System.out.println("Thank you for using the application");
			sc.close();
			return;
		default:
			System.out.println("Invalid choice");
			sc.close();
			return;	
		}
	  }
	}
}
