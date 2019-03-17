package com.mycompany.a2;

public class PlayerRobot extends Robot {

	public PlayerRobot(int size, int heading, double x, double y) {
		super(size, heading, x, y);
		
	}
	//override of toString
	@Override
	public String toString() {
		String parentDesc = super.toString();
		return "Robot:" + parentDesc;
	}
}