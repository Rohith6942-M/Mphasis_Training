package com.test;

@FunctionalInterface
interface FunInf
{
	void draw();
	default void dog()
	{
		
	}
	static void cat()
	{
		
	}
}

class Circle implements FunInf
{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("circle");
	}
	
}

class Square implements FunInf
{
	@Override
	public void draw()
	{
		System.out.println("square");
	}
	//factory method
		public Square getObj()
		{
			System.out.println("Object returned");
			return new Square();
		} 
}
public class exp2 {
	
	public static void main(String args[])
	{
		FunInf obj1 = new Circle();
		obj1.draw();
		FunInf obj2 = new Square();
		obj2.draw();
		FunInf obj3 = () -> System.out.println("Circle");
		obj3.draw();
	}
}
