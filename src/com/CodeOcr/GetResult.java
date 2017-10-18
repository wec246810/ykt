package com.CodeOcr;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class GetResult {
	private static String path="C:\\Ic\\";
	private static Map<BufferedImage, String> trainMap = null;

	public static Map<BufferedImage, String> loadTrainData(String trainFile) throws Exception {
		Map<BufferedImage, String> map = new HashMap<BufferedImage, String>();
		for (int i = 0; i < 9; i++) {
			File dir = new File(path+"train\\" + trainFile + "\\" + i);
			File[] files = dir.listFiles();
			for (File file : files) {
				map.put(ImageIO.read(file), i+"");
//				System.out.println(file.getPath());
//				 System.out.println(i);
			}
		}
		trainMap = map;

		return trainMap;

	}
	public static int isBlack(int colorInt) {
		Color color = new Color(colorInt);
		if (color.getRed() + color.getGreen() + color.getBlue() <= 100) {
			return 1;
		}
		return 0;
	}
	public static String getSingleCharOcr(BufferedImage img, Map<BufferedImage, String> map) {
		String result = "#";
		int width = img.getWidth();
		int height = img.getHeight();
		int min = width * height;
		for (BufferedImage bi : map.keySet()) {
			int count = 0;
			if (Math.abs(bi.getWidth() - width) > 3)
				continue;
			int widthmin = width < bi.getWidth() ? width : bi.getWidth();
			int heightmin = height < bi.getHeight() ? height : bi.getHeight();
			Label1: for (int x = 0; x < widthmin; ++x) {
				for (int y = 0; y < heightmin; ++y) {
					if (isBlack(img.getRGB(x, y)) != isBlack(bi.getRGB(x, y))) {
						count++;
						if (count >= min)
							break Label1;
					}
				}
			}
			if (count < min) {
				min = count;
				result = map.get(bi);
			}
		}
//		System.out.println(result);
		return result;
	}
	public String getAllOcr(String file){
		try {
			String result = "";
		File dir = new File(file);
		BufferedImage img = ImageIO.read(dir);
		List<BufferedImage> listImg = splitImage(img);
		Map<BufferedImage, String> map0 = loadTrainData("0");
		Map<BufferedImage, String> map1 = loadTrainData("1");
		Map<BufferedImage, String> map2 = loadTrainData("2");
		Map<BufferedImage, String> map3 = loadTrainData("3");
		int i = 0;
		for (BufferedImage bi : listImg) {
			switch (i) {
			case 0:
				result += getSingleCharOcr(bi, map0);
				break;
			case 1:
				result += getSingleCharOcr(bi, map1);
				break;
			case 2:
				result += getSingleCharOcr(bi, map2);
				break;
			case 3:
				result += getSingleCharOcr(bi, map3);
				break;
			}
			i++;
			
			// 分成四部分
		}
		ImageIO.write(img, "png", new File(path+"result//" + result + ".jpg"));
		System.out.println("now.the.yzm.result="+result);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	
	}
	private static List<BufferedImage> splitImage(BufferedImage image) {
		List<BufferedImage> digitImageList = new ArrayList<BufferedImage>();
		digitImageList.add(image.getSubimage(0, 0, 16 , 30));
		digitImageList.add(image.getSubimage(16, 0, 16, 30));
		digitImageList.add(image.getSubimage(32, 0, 16, 30));
		digitImageList.add(image.getSubimage(48, 0, 16, 30));

		return digitImageList;
	}
	
}
