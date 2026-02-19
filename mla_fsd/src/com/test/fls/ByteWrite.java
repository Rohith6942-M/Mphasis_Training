package com.test.fls;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class ByteWrite {
	
	public static void main(String args[])throws Exception
	{
		File file = new File("src/bt.text");
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		String msg = "this is simple byte stream write";
		bos.write(msg.getBytes());
		bos.flush();
		bos.close();
		System.out.println("Done.");
	}
	

}
