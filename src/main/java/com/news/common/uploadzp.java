package com.news.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class uploadzp {
	public void upload(File file, String path) {
		InputStream is;
		try {
		is = new FileInputStream(file);
		OutputStream os = new FileOutputStream(path);
		byte buffer[] = new byte[1024];
		int count = 0;
		while((count=is.read(buffer))!=-1)
		{
			os.write(buffer,0,count);
		}
			os.flush();
			os.close();
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
