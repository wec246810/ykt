package com.CodeOcr;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;


public class DownloadImage {
	

	public boolean DownloadImage(InputStream inputStream, String path) {
		// TODO Auto-generated method stub

		try {
			InputStream inStrm = inputStream;
			
			OutputStream outstream = new FileOutputStream(new File(path+"DOWNLOAD", 1 + ".png"));
			int l = -1;
			byte[] tmp = new byte[2048];
			while ((l = inStrm.read(tmp)) != -1) {
				outstream.write(tmp,0,l);
			}
			outstream.close();
			return true;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("URL创建失败");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO流出现错误");
			e.printStackTrace();
			return false;
		}
	}
}
