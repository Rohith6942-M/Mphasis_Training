package com.test.fls;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class CharWrite {
	
	public static void main(String args[])throws Exception
	{
		FileWriter fw = new FileWriter("src/bx.text");
		BufferedWriter bw = new BufferedWriter(fw);
		String msg = "This is simple char Stream write";
		bw.write(msg);
		bw.flush();
		bw.close();
		System.out.println("Done.");
		
	}

}
