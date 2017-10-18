package com.CodeOcr;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Binaryzation {


	public void removeBackGroud(String path,String picFile, int i) {
		BufferedImage img;
		try {	
			img = ImageIO.read(new File(picFile));
			int h = img.getHeight();// 获取图像的高
			int w = img.getWidth();// 获取图像的宽
			int[][] gray = new int[w][h];
			for (int x = 0; x < w; x++) {
				for (int y = 0; y < h; y++) {
					gray[x][y] = getGray(img.getRGB(x, y));
				}
			}
			BufferedImage nbi=new BufferedImage(w,h,BufferedImage.TYPE_BYTE_BINARY);  
	        int SW=205;  
	        for (int x = 0; x < w; x++) {  
	            for (int y = 0; y < h; y++) {  
	                if(getAverageColor(gray, x, y, w, h)>SW){  
	                    int max=new Color(255,255,255).getRGB();  
	                    nbi.setRGB(x, y, max);  
	                }else{  
	                    int min=new Color(0,0,0).getRGB();  
	                    nbi.setRGB(x, y, min);  
	                }  
	
	            }  
	        }  
	          
	        ImageIO.write(nbi, "png", new File(path + "temp\\" + i + ".png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	/** 
     * 自己加周围8个灰度值再除以9，算出其相对灰度值 
     * @param gray 
     * @param x 
     * @param y 
     * @param w 
     * @param h 
     * @return 
     */  
    public static int  getAverageColor(int[][] gray, int x, int y, int w, int h)  
    {  
        int rs = gray[x][y]  
                        + (x == 0 ? 255 : gray[x - 1][y])  
                        + (x == 0 || y == 0 ? 255 : gray[x - 1][y - 1])  
                        + (x == 0 || y == h - 1 ? 255 : gray[x - 1][y + 1])  
                        + (y == 0 ? 255 : gray[x][y - 1])  
                        + (y == h - 1 ? 255 : gray[x][y + 1])  
                        + (x == w - 1 ? 255 : gray[x + 1][ y])  
                        + (x == w - 1 || y == 0 ? 255 : gray[x + 1][y - 1])  
                        + (x == w - 1 || y == h - 1 ? 255 : gray[x + 1][y + 1]);  
        return rs / 9;  
    } 
	static int sum = 0;


    public static int getGray(int rgb){  
    	

        int r=(rgb >> 16) & 0xff;  
        int g=(rgb >> 8) & 0xff;  
        int b=rgb & 0xff;  
        int gray = (int) (0.3 * r + 0.59 * g + 0.11 * b); 
        return gray;  
    } 
}
