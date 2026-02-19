package com.test.fls;

import java.io.BufferedReader;
import java.io.FileReader;

public class CharRead {
	
	public static void main(String args[])throws Exception
	{
		FileReader fw = new FileReader("src/bx.text");
		BufferedReader bw = new BufferedReader(fw);
		System.out.println(bw.readLine());
		bw.close();
		System.out.println("Done.");
		
	}

}
