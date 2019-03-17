package com.mycompany.a2;

import java.util.ArrayList;

public class GameObjectCollection implements ICollection {
	private ArrayList<GameObject> gameObjectList = new ArrayList<GameObject>();
	private class Iterator implements IIterator{
		private int currentIndex = 0;
		
		 @Override
	        public Object getNext() {
	        	currentIndex ++;
	            return gameObjectList.get(currentIndex-1);
	        }
		 
		 @Override
	        public boolean hasNext() {
	        if(gameObjectList.size() <= 0)
	        	return false;
	        if(currentIndex == gameObjectList.size())
	        	return false;
	        return true;
	        }
		 
		 @Override
		    public void add(Object object) {
		        gameObjectList.add((GameObject) object);

		    }

		    @Override
		    public IIterator getIterator() {
		        return new Iterator();
		    }
	}


}