package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;

public class NonPlayerRobot extends Robot {
	
	public NonPlayerRobot(int size, int heading, double x, double y) {
		super(size, heading, x, y);
		
	}
	
	public void collision(char with) {//Called when a collision with a drone or robot is detected. sets damage and color acordenly 
		if(super.getDamageLevel()!=100) {
		if(with=='r') {//robot collision
			super.setDamage(5);
			super.setColor(ColorUtil.rgb((super.getRed()-5), 0, 0));
			super.setRed(5);
			super.checkSpeed();
		}
		if(with=='d') {//drone collision
			super.setDamage(1);
			super.setColor(ColorUtil.rgb((super.getRed()-1), 0, 0));
			super.setRed(1);
			super.checkSpeed();
			
		}
		}
	}
	@Override
	public String toString() {
		String parentDesc = super.toString();
		return "NPR:" + parentDesc;
	}

}