package com.mycompany.a2;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Drone extends Moveable{
	private Random rand = new Random();
	
	/* Drone Constructor
	 * @param x
	 * @param y
	 * @param size
	 * @param deading
	 * @param speed
	 */

	public Drone(int size, double x, double  y) {
		super(size, x, y);
		super.setColor(ColorUtil.rgb(190, 1, 1));
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
		return 5 + rand.nextInt(5);
	}
}
