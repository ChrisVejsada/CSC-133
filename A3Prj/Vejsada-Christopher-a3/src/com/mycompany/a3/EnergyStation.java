package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class EnergyStation extends Fixed {
	
	private int capacity, size;

	
	/**
	 *
	 * @param size
	 * @param x
	 * @param y
	 */
	
	public EnergyStation(GameWorld gw,int size, double x, double y) {
		super(gw,size, x, y);
		super.setColor(ColorUtil.rgb(0,255, 0));
		capacity = size;
		this.size=size;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity() {
		capacity=0;
	}
	
	@Override
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " capacity="+capacity;
		return "Energy Station:" + parentDesc + myDesc;
	
	}
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
        g.setColor(getColor());
        if(!isSelected()) {
        g.fillArc((int)(pCmpRelPrnt.getX()+this.getX())
        		, (int)(pCmpRelPrnt.getY()+this.getY())
        		, this.size, size, 0, 360);
        }else {
        	g.drawArc((int)(pCmpRelPrnt.getX()+this.getX())
            		, (int)(pCmpRelPrnt.getY()+this.getY())
            		, this.size, size, 0, 360);
        }
        
        
        int locX = (int)getX() + (int)pCmpRelPrnt.getX();
        int locY = (int)getY() + (int)pCmpRelPrnt.getY();
        g.setColor(0x000000);
        String copacityNum = Integer.toString(capacity);
        g.drawString(copacityNum, locX, locY);
	}

}