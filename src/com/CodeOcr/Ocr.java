package com.CodeOcr;

import java.io.InputStream;

public class Ocr {
	DownloadImage downloadImage=null;
	Binaryzation binaryzation=null;
	GetResult getResult=null;
	String path = "C:\\Ic\\";
	public String Ocr(InputStream inputStream,String path) {
		downloadImage=new DownloadImage();
		
		//����ͼƬ
		downloadImage.DownloadImage(inputStream, path);
		binaryzation=new Binaryzation();
		//��ֵ�� �Ƴ�����
		binaryzation.removeBackGroud(path, path+"DOWNLOAD\\1.png", 1);
		//��ȡ���
		getResult=new GetResult();
		String result=getResult.getAllOcr(path+"temp\\1.png");
		return result;
	}
}
