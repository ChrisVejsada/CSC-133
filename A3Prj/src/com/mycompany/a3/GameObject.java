package com.mycompany.a3;
import com.codename1.charts.util.*;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
public class GameObject implements IDrawable,ICollider{

	private int myColor;
	private double x = 0;
	private double y = 0;
	private boolean isCollided = false;
	private int size;
	private double left, right, top ,bottom;
	GameWorld gw;
	
	public GameObject(GameWorld gw,int size, double x, double y) {
		this.size = size;
		this.x = x;
		this.y = y;
		left = (int) (getX()-(size/2));
		right = (int)(getX()+(size/2));
		top = (int) (getY()-(size/2));
		bottom = (int) (getY()+(size/2));
		this.gw = gw;
	}
	
	public double getY() {
		return y;
	}
	public int getSize() {
		return size;
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
	

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {

	}
	public double getRight() {

		return (getX()+(size/2));
	}
	public double getLeft() {
		return (getX()-(size/2));
		
	}
	public double getTop() {
		return (this.getY()-(size/2));
		
	}
	public double getBottom() {
		return (getY()+(size/2));
		
	}
	public boolean getHasColided() {
		return isCollided;
	}
	public void setHasColided(boolean b) {
		isCollided = b;
	}

	@Override
	public boolean collidesWith(GameObject otherObject) {

		if( getRight() < otherObject.getLeft() || getLeft() > otherObject.getRight())
			// no left/right overlap, return false
			return false;
		
		// there was left/right overlap, now check top/bottom
		if( otherObject.getTop() > getBottom() || getTop() > otherObject.getBottom() )
			// no top/bottom overlap, return false
			return false;
		
		// there was overlap in both L/R and T/B, they are colliding
		return true;
		
	}

	@Override
	public void handleCollision(GameObject otherObject) {
		// TODO Auto-generated method stub
		if(this instanceof PlayerRobot) {
			if(otherObject instanceof EnergyStation) {
				if(! otherObject.getHasColided()) {
					otherObject.setHasColided(true);
					gw.energyStationCollision(otherObject);
				}
			}
			if(otherObject instanceof Base) { 
				if(!otherObject.getHasColided()) {
					//otherObject.setHasColided(true);
					gw.baseCollision(((Base) otherObject).getSequenceNumber());
					otherObject.setColor(191);
				}
			}
			if (otherObject instanceof NonPlayerRobot) {
				if(!otherObject.getHasColided()) {
					//otherObject.setHasColided(true);
				gw.robotCollision('r');
				}
			}
			if(otherObject instanceof Drone) {
				if(!otherObject.getHasColided()) {
					//otherObject.setHasColided(true);
				gw.robotCollision('d');
				}
			}
			
		}
	}

}