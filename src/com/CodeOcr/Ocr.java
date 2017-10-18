package com.CodeOcr;

import java.io.InputStream;

public class Ocr {
	DownloadImage downloadImage=null;
	Binaryzation binaryzation=null;
	GetResult getResult=null;
	String path = "C:\\Ic\\";
	public String Ocr(InputStream inputStream,String path) {
		downloadImage=new DownloadImage();
		
		//下载图片
		downloadImage.DownloadImage(inputStream, path);
		binaryzation=new Binaryzation();
		//二值化 移除背景
		binaryzation.removeBackGroud(path, path+"DOWNLOAD\\1.png", 1);
		//获取结果
		getResult=new GetResult();
		String result=getResult.getAllOcr(path+"temp\\1.png");
		return result;
	}
}
