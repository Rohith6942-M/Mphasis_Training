package com.test;
interface Inf1
{
	float p1 = 3.14f;
	void display();
	default void human()
	{
		System.out.println("Hi human");
		animals();
	}
	static String greetuser(String msg)
	{
		return msg;
	}
	private void animals()
	{
		System.out.println("private method");
	}
}
interface Inf2
{
	void book();
}
abstract class Abs1
{
	public abstract void fox();
	public void color()
	{
		System.out.println("implemented method");
	}
}
class impl1 extends Abs1 implements Inf1, Inf2
{
	@Override
	public void fox()
	{
		System.out.println("abs implemented");
	}
	@Override
	public void display()
	{
		System.out.println("inf1 implemented");
	}
	@Override
	public void book()
	{
		System.out.println("inf2 implemented");
	}
}
public class exp1 {
	
	public static void main(String args[])
	{
		impl1 obj = new impl1();
		
		obj.book();
		obj.human();
		obj.display();
		obj.fox();
		obj.color();
		System.out.println(Inf1.greetuser("Hello MLA CODERS"));
		
		
	}

}
