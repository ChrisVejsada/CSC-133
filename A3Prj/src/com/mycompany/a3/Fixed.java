package com.mycompany.a3;

import com.mycompany.a3.GameObject;

public abstract class Fixed extends GameObject{
	
	/**
	 * Constuctor for fixed
	 * @param x
	 * @param y
	 */
	
	public Fixed(int size, double x, double y) {
		super(size, x, y);
	}
	
	/**
	 * Override that does not allow fixed to set x and y
	 */
	@Override
	public void setX(double x) {
		
	}
	@Override
	public void setY(double y) {
		
	}

}
