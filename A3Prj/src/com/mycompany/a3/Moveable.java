package com.mycompany.a3;

public abstract class Moveable extends GameObject{
	
	private int heading = 0;
	private int speed = 0;
	
	public Moveable(GameWorld gw, int size, double x, double y) {
		
		super(gw, size, x, y);
		//TODO auto gen
	}
	
public void move(GameWorld temp,int elapsedTime) {

		
		double relativSpeed = ((speed / (1000.00/(elapsedTime+100))));
	
		double tempX =getX()+((Math.cos(Math.toRadians(90-heading)))*relativSpeed);
		double tempY= getY()+((Math.sin(Math.toRadians(90-heading)))*relativSpeed);

		/// Makes sure the object isn't leaving the screen
		if(tempX <= temp.getMapWidth() && tempY <= temp.getMapHeight() && tempX >=0 && tempY >=0) {
			setX(tempX);
			setY(tempY);
			
		}
		else {
			//change heading then call move again
			if(!(this instanceof NonPlayerRobot)) {
			heading -= 90;
			move(temp, elapsedTime);
			}
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
	public void setNPRHeading(int heading) {
		this.heading = heading;
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