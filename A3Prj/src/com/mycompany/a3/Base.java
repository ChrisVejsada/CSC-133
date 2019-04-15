package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import java.util.*;

public class Base extends Fixed{
	

	private int sequenceNumber;
	//Sets the base color
	public Base(int size, int sequenceNumber, double x, double y) {
		super(size, x, y);
		super.setColor(ColorUtil.rgb(0, 255, 0));
		//this.setSize(10);
		this.sequenceNumber = sequenceNumber;
	}
	//Getter fpr number of base
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	
	@Override
	public void setColor(int color) {
		
	}
	
	@Override
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " sequence Number="+sequenceNumber;
		return "Base:" + parentDesc + myDesc;
	}
	
}
	
	
	
