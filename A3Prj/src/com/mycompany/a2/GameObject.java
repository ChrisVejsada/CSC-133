package com.mycompany.a2;
import com.codename1.charts.util.*;
import com.codename1.charts.util.ColorUtil;
public abstract class GameObject {
	
	private int myColor;
	private double x = 0;
	private double y = 0;
	private int size;
	
	public GameObject(int size, double x, double y) {
		this.size = size;
		this.x = x;
		this.y = y;
	}
	
	public double getY() {
		return y;
	}
	
	public double getX() {
		return x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setColor(int color) {
		myColor = color;
	}
	
	public int getColor() {
		return myColor;
	}
	
	public String toString() {
		
		String myDesc = "loc=" + Math.round(x*10.0)/10.0 + "," + Math.round(y*10.0)/10.0 + 
				"color=[" + ColorUtil.red(myColor) + "," + ColorUtil.green(myColor) + "," + ColorUtil.blue(myColor) + "]";
		return myDesc;
	}
	

}
