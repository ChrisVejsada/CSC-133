package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public abstract class Robot extends Moveable implements ISteerable {
	
	private int maximumSpeed=30;
	private int energyLevel=100;
	double nonDisplayenergy = 100.00;
	private double energyConsumptionRate=1.00;
	private int damageLevel = 0;
	private int lastBaseReached=1;
	private int lives=3;
	private GameWorld gw;
	private int red = 255;
	private boolean isDead = false;
	private int steeringDirection;
	
	/**
	 * Constructor for robot
	 * @param x
	 * @param y
	 */
	public Robot(GameWorld gw,int size, int heading,double x, double y) {//
		super(gw,size, x, y);
		super.setSpeed(20);
		super.setColor(ColorUtil.rgb(red, 0, 0));
		this.gw = gw;
	}
	
	
	public int getRed(){
		return red;
	}
	public void setRed(int addIt) {
		red -= addIt;
	}
	public int getLives() {
		return lives;
	}
	
	public int getLastBase() {
		return lastBaseReached;
	}
	
	public int getDamageLevel() {
		return damageLevel;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}
	
	public int getStearingDirection() {
		return steeringDirection;
	}
	
	@Override
	public void changeHeading(char s) {
		if(s=='l')
			if(steeringDirection >= (-35))
				steeringDirection-=5;
		if(s=='r')
			if(steeringDirection <= 35)
				steeringDirection+=5;
		}
	@Override
	public void setSpeed(int speed) {//sets the speed of robot
		if(speed <= (maximumSpeed) && speed >=0 )
			super.setSpeed(speed);
	}
	public void checkSpeed() {//checks the speed when the robot takes damage
		
		maximumSpeed=(int) (30-(30*(damageLevel/100.00)));
		if (getSpeed()>maximumSpeed)
			setSpeed(maximumSpeed);
	}
	public void setDamage(int damage) {
		damageLevel += damage;
	}
	public void collision(char with) {//Called when a collision with a drone or robot is detected. sets damage and color accordenly 
		if(damageLevel!=100) {
		if(with=='r') {//robot collision
			damageLevel += 10;
			setColor(ColorUtil.rgb((red-=10), 0, 0));
			checkSpeed();
			gw.setCrashCol(true);
			
		}
		if(with=='d') {//drone collision
			damageLevel += 5;
			setColor(ColorUtil.rgb((red-=5), 0, 0));
			checkSpeed();
			
		}
		}
	}
	public void baseCollision(int baseNumber) {// called when collision with base is detected
		if(baseNumber==(lastBaseReached+1))
			lastBaseReached=baseNumber;
	}
	
	public void setEnergyLevel(int energy) {//Receives 300 to set energy based on consumption rate or value depending on energy station to add energy
		if (energy == 300) {
			nonDisplayenergy-=(energyConsumptionRate/(1000.00/20.00));
			
				energyLevel=(int) nonDisplayenergy;
		}
		else {
			nonDisplayenergy=energyLevel+=energy;
			if(energyLevel>100)
			nonDisplayenergy=energyLevel=100;
		}
	}
	
	
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " maxSpeed=" + maximumSpeed + " steeringDirection="+steeringDirection+ " energyLevel="+ energyLevel+ " damageLevel=" + damageLevel + "lives:  "+lives;
		return parentDesc + myDesc;
		
	}
	
	public void resetRobot() {
		setX(500);
		setY(500);
			damageLevel=0;
			energyLevel=100;
			lives-=1;
		
	}
	
	
}