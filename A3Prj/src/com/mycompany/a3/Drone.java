package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Drone extends Moveable{
	private Random rand = new Random();
	private int size;
	
	/* Drone Constructor
	 * @param x
	 * @param y
	 * @param size
	 * @param deading
	 * @param speed
	 */

	public Drone(GameWorld gw,int size, double x, double  y) {
		super(gw,size, x, y);
		super.setColor(ColorUtil.rgb(190, 1, 1));
		this.size =size;
		setSpeed(randSpeed());
		setHeading(randHeading());
	}
	 
	public String toString() {
		//String name = this.getClass().getSimpleName();
		String parentDesc = super.toString();
		return "Drone:" + parentDesc;
	}
	@Override
	public void setColor(int color) {}//overides set color to non changable
	@Override
	public void setHeading(int heading) {
		// TODO Auto-generated method stub
		super.setHeading(randValue());
	}
	
	private int randValue() {
		return ((-5)+rand.nextInt(10));
	}
	
	private int randHeading() {//Generates initial random heading value
		return rand.nextInt(359);
	}
	
	private int randSpeed() {
		return 20 + rand.nextInt(25);
	}
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		//super.draw(g, pCmpRelPrnt);
		int locX = (int)getX() + (int)pCmpRelPrnt.getX();
        int locY = (int)getY() + (int)pCmpRelPrnt.getY();
        Point top = new Point(locX, size + locY);
        Point bottomL = new Point(locX - size, locY - size);
        Point bottomR = new Point(locX + size, locY - size);
        //Set as triangle
        g.setColor(getColor());
        g.drawLine((int)top.getX(), (int)top.getY(), (int)bottomL.getX(), (int)bottomL.getY());
        g.drawLine((int)bottomL.getX(), (int)bottomL.getY(), (int)bottomR.getX(), (int)bottomR.getY());
        g.drawLine((int)top.getX(), (int)top.getY(), (int)bottomR.getX(), (int)bottomR.getY());
        
	}
}