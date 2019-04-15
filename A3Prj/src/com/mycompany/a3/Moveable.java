package com.mycompany.a3;

public abstract class Moveable extends GameObject{
	
	private int heading = 0;
	private int speed = 0;
	
	public Moveable(int size, double x, double y) {
		
		super(size, x, y);
		//TODO auto gen
	}
	
public void move() {
		
		double deltaX = (float)Math.cos(Math.toRadians(90 - this.getHeading())) * this.getSpeed();
		double deltaY = (float)Math.sin(Math.toRadians(90 - this.getHeading())) * this.getSpeed();
		
		this.setX(this.getX() + (float)deltaX);
		this.setY(this.getY() + (float)deltaY);
	}
	/*
	 * setter for speed
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	// @return speed
	public int getSpeed() {
		return speed;
	}
	
	public int getHeading() {
		return heading;
	}
	
	public void setHeading(int heading) {
		this.heading=(this.heading+heading);
	}
	
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " heading="+heading+" speed="+speed;
		return parentDesc+myDesc;
	}

}
