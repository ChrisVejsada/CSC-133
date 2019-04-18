package com.mycompany.a3;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class PlayerRobot extends Robot {
	private int size;
	private double x, y;

	public PlayerRobot(GameWorld gw,int size, int heading, double x, double y) {
		super(gw,size, heading, x, y);
		this.x =x;
		this.y=y;
		this.size=size;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		String parentDesc = super.toString();
		return "Robot:" + parentDesc;
	}
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		int locX = (int)getX() + (int)pCmpRelPrnt.getX();
        int locY = (int)getY() + (int)pCmpRelPrnt.getY();
        g.setColor(getColor());
        g.fillRect(locX, locY, size, size);
	}
}