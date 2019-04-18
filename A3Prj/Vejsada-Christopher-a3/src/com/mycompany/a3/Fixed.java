package com.mycompany.a3;

import com.codename1.ui.geom.Point;

public abstract class Fixed extends GameObject implements ISelectable{
	private boolean isSelected;
	
	
	public Fixed(GameWorld gw,int size, double x, double y) {
		super(gw,size, x, y);
	}

	@Override
	public void setSelected(boolean yesNo) {
		// TODO Auto-generated method stub
		isSelected = yesNo;	
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return isSelected;
	}

	@Override
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		int px = pPtrRelPrnt.getX(); // pointer location relative to
		int py = pPtrRelPrnt.getY(); // parents origin
		int xLoc = (int) (pCmpRelPrnt.getX()+ this.getX());// shape location relative 
		int yLoc = (int) (pCmpRelPrnt.getY()+ this.getY());// to parents origin
		if ( (px >= xLoc) && (px <= xLoc+this.getSize())&& (py >= yLoc) && (py <= yLoc+this.getSize()) )
		        return true; 
		else
		        	return false;
		
	}

}