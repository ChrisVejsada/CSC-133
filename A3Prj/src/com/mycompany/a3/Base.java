package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import java.util.*;
import com.codename1.charts.models.Point;
import com.codename1.ui.Dialog;
import com.codename1.ui.Graphics;


public class Base extends Fixed /*implements IDrawable, ISelectable, ICollider*/{
	
	private boolean isSelected = false;
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
	
	
	
