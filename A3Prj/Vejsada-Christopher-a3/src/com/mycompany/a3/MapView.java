package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
public class MapView extends Container implements  Observer{
	
	private GameWorld model;

	public MapView(Observable myModel) {
		model = (GameWorld) myModel;
		myModel.addObserver(this);
		this.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.rgb(255,0,0)));
		this.getAllStyles().setBgColor(0xffffff);
	
		//model.setWidthHeight(getX(), getY());
	}
	public int getMapWidth() {
		
		return getComponentForm().getWidth() - (2 * getX());
	}
	
	public int getMapHeight() {
		
		return getHeight();
	}
	
	@Override
	public void paint(Graphics g) {
	
		// TODO Auto-generated method stub
		super.paint(g);
		IIterator anIterator = model.gameObjectList.getIterator();
		model.setWidthHeight(getX(), getY());
		Object currentObj = new Object();
		Point pCmpRelPrnt = new Point(getX(),getY());
		
		while( anIterator.hasNext() ){
			currentObj = anIterator.getNext();
		
				((GameObject) currentObj).draw(g, pCmpRelPrnt);
		
		}
	}
	public void pointerPressed(int x, int y) {
		if (model.isIspause() == false)
			return;
		
		x = x-getParent().getAbsoluteX();
		y= y-getParent().getAbsoluteY();
		Point pPtrRelPrnt = new Point(x, y);
	       
		Point pCmpRelPrnt = new Point(getX(), getY());
		double locX = (int)x + (int)pCmpRelPrnt.getX();
        double locY = (int)y + (int)pCmpRelPrnt.getY();
			
		IIterator theSelectors = model.gameObjectList.getIterator();
		while(theSelectors.hasNext()){
			GameObject curObj = (GameObject)theSelectors.getNext();
			if (curObj instanceof Base || curObj instanceof EnergyStation) {
				
				//check if it was selected so we can move it
				if (((ISelectable)curObj).isSelected() && model.isPositionable()) {
					curObj.setX(x - getX() - curObj.getSize() / 2 );
					curObj.setY(y - getY() - curObj.getSize() / 2);
					((ISelectable)curObj).setSelected(false);
					model.setPositionable(false);
					
				} else if(((ISelectable)curObj).contains(pPtrRelPrnt, pCmpRelPrnt)) {
					((ISelectable)curObj).setSelected(true);
					
				}
				else {
					((ISelectable)curObj).setSelected(false);
				}
			
			}

			update(model, null);
			//repaint();
			
		}
	}
	


	public void update (Observable o, Object arg) {
		//code to call the method in GameWorld (Observable) that output the 
		//game object info to the console
		this.repaint();
		model.map();
		//model = (GameWorld) o;
		//model.addObserver(this);
		//model.generateDisplay();
	
	}
}