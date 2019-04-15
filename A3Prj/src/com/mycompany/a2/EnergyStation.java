package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class EnergyStation extends Fixed {
	
	private int capacity;
	
	/**
	 *
	 * @param size
	 * @param x
	 * @param y
	 */
	
	public EnergyStation(int size, double x, double y) {
		super(size, x, y);
		super.setColor(ColorUtil.rgb(0,0, 255));
		capacity = size;
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

}
