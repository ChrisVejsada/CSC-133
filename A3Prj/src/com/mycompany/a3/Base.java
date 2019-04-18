package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Base extends Fixed{
	private double x, y;
	private int size;
	private boolean isSelected;

	private int sequenceNumber;
	//Sets the base color
	public Base(GameWorld gw,int size, int sequenceNumber, double x, double y) {
		super(gw,size, x, y);
		this.x = x;
		this.y = y;
		this.size = size;
		super.setColor(ColorUtil.rgb(0, 0, 255));
		this.sequenceNumber = sequenceNumber;
	}
	
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	
	@Override
	public void setColor(int color) {
		super.setColor(ColorUtil.rgb(0, color, 255));
	}
	
	@Override
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " sequence Number="+sequenceNumber;
		return "Base:" + parentDesc + myDesc;
	}
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		
		//Draws the base and fills in the triangle
		int locX = (int)x + (int)pCmpRelPrnt.getX();
        int locY = (int)y + (int)pCmpRelPrnt.getY();
        int xx = (int) (pCmpRelPrnt.getX()+this.getX());
        int yy = (int) (pCmpRelPrnt.getY()+this.getY());
        Point top = new Point((int) (pCmpRelPrnt.getX()+this.getX()), (size) + yy);
        Point bottomL = new Point(xx - (size), yy - (size));
        Point bottomR = new Point(xx + (size), yy - (size));
        //Set as triangle
        g.setColor(getColor());
        if(!isSelected) {
        g.fillTriangle( (int)top.getX(),     (int)top.getY(), 
                        (int)bottomL.getX(), (int)bottomL.getY(), 
                        (int)bottomR.getX(), (int)bottomR.getY());
        }
        else {

             //Set as triangle
             g.setColor(getColor());
             g.drawLine((int)top.getX(), (int)top.getY(), (int)bottomL.getX(), (int)bottomL.getY());
             g.drawLine((int)bottomL.getX(), (int)bottomL.getY(), (int)bottomR.getX(), (int)bottomR.getY());
             g.drawLine((int)top.getX(), (int)top.getY(), (int)bottomR.getX(), (int)bottomR.getY());
        }
        g.setColor(0x000000);
        String copacityNum = Integer.toString(sequenceNumber);
        g.drawString(copacityNum, xx-7,yy-(size/2));


	}
	public void setSelected(boolean yesNo) {
		isSelected = yesNo;	
	}


	//check if selected
	public boolean isSelected() {
		return isSelected;
	}
	
	//Draw the base
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		int px = pPtrRelPrnt.getX(); 
		int py = pPtrRelPrnt.getY(); 
		int xLoc = (int) (pCmpRelPrnt.getX()+ this.getX());
		int yLoc = (int) (pCmpRelPrnt.getY()+ this.getY());
		if ( (px >= xLoc) && (px <= xLoc+this.getSize())&& (py >= yLoc) && (py <= yLoc+this.getSize()) )
		        return true; 
		else
		        	return false;
		
	}
	
}