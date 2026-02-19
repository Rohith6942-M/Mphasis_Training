package com.test;
 
@FunctionalInterface
interface FunInf1
{
	String greetUser(String name, String msg);
}
public class exp3 {
	
	public static void main()
	{
		FunInf1 obj1 = (String name, String msg) ->
		{
			System.out.println("hi "+name+" "+msg);
			return "hello "+name+" Mla "+msg;
		};
		obj1.greetUser("Rohith", "FSD meta geek");
		System.out.println();
		System.out.println(obj1.greetUser("Rohith", "FSD meta geek"));
	}

}
