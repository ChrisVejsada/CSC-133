package com.mycompany.a3;

public interface ICollider {
	
	boolean collidesWith(GameObject otherObject);
	void handleCollision(GameObject otherObject);
}