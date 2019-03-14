package com.mycompany.a1;

public class Moveable extends GameObject{
	
	private int heading = 0;
	private int speed = 0;
	
	public Moveable(int size, double x, double y) {
		
		super(size, x, y);
		//TODO auto gen
	}
	
	public void move() {
		
	
		double tempX =(getX()+(Math.cos(Math.toRadians(90-heading)))*speed);
		double tempY= getY()+(Math.sin(Math.toRadians(90-heading)))*speed;
		
		/// Makes sure the object isn't leaving the screen
		if(tempX <= 1024 && tempY <= 786 && tempX >=0 && tempY >=0) {
			setX(tempX);
			setY(tempY);
		}
		else {
			//change heading then call move again
			heading -= 45;
			move();
			
		}
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
