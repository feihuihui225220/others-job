package com.anticw.aged.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
@Repository
public class ValidateCode {
	private Random random = new Random();
	private String rdString = "023456789abcdefghjkmnopqrstABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int width;
	private int height;
	private int lineSize;
	private int stringNum;
	private int fontSize;
	
	private Font getFont(){
		return new Font("Fixedsys",Font.CENTER_BASELINE, fontSize);
	}
	private Color getRdColor(int fc,int bc){
		if(fc > 255)
            fc = 255;
        if(bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc-fc-16);
        int g = fc + random.nextInt(bc-fc-14);
        int b = fc + random.nextInt(bc-fc-18);
        return new Color(r,g,b);	
	}
	public void getRdCode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,18));
		g.setColor(getRdColor(110, 133));
		for(int i=0;i<=lineSize;i++){
			drawLine(g);
		}
		String randomString = "";
		for(int i=0;i<stringNum;i++){
			randomString = drawString(g,randomString,i);			
		}
		g.dispose();
		request.getSession().setAttribute("validateCode", randomString);
		
		ImageIO.write(image, "JPEG", response.getOutputStream());
		
	}
	private String drawString(Graphics g,String randomString,int i){
		g.setFont(getFont());
		g.setColor(new Color(random.nextInt(101),random.nextInt(111),random.nextInt(121)));
		String rand = String.valueOf(getRandomString(random.nextInt(rdString.length())));
		randomString += rand;
		g.translate(random.nextInt(3), random.nextInt(3));
		//英文字母文字基线位置为2/3
		g.drawString(rand, width/stringNum*i, height*2/3);
		return randomString;
	}
	private void drawLine(Graphics g){
		int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x+xl, y+yl);
	}
	public String getRandomString(int num){
		return String.valueOf(rdString.charAt(num));
	}
	
	
	public void setRdString(String rdString) {
		this.rdString = rdString;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setLineSize(int lineSize) {
		this.lineSize = lineSize;
	}
	public void setStringNum(int stringNum) {
		this.stringNum = stringNum;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	
	
}
