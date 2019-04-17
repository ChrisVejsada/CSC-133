package com.mycompany.a3;

import com.codename1.util.MathUtil;
public class NextBaseStrategy implements IStrategy {

	private NonPlayerRobot npr;
    private GameWorld tgw;

    public NextBaseStrategy(NonPlayerRobot thisRobot, GameWorld gw) {
        npr = thisRobot;
        tgw = gw;
    }

    @Override
    public void setStrategy() {
        // TODO Auto-generated method stub
        int nextBase = npr.getLastBase() + 1;
        double pX = 0, pY = 0;
        IIterator theElements = tgw.gameObjectList.getIterator();

        Object currentObj;
        while( theElements.hasNext() ){
            currentObj = theElements.getNext();
            if(currentObj instanceof Base)
                if( ((Base)currentObj).getSequenceNumber() == nextBase ){
                    // found the next base they need to get to, save coordinates
                    pX = ((Base)currentObj).getX();
                    pY = ((Base)currentObj).getY();
                }
        }

        double dx, dy;

        dx = pX - npr.getX();
        dy = pY - npr.getY();

        if( dy == 0 )
            if( dx < 0 ){
                // target base is directly to the left
                npr.setHeading(270);
                return;
            }
            else if( dx > 0 ){
                // target base is directly to the right
                npr.setHeading(90);
                return;
            }
// is x val the same?
        if( dx == 0 )
            if( dy > 0 ){
            
                npr.setHeading(0);
                return;
            }else if( dy < 0 ){
                
                npr.setHeading(180);
                return;
            }

        // target wasn't at a 90 degree interval,
        // need to determine the angle
        
        int angle = (int)(Math.toDegrees(MathUtil.atan(dx/dy)));

        // got the angle, now figure out which quadrant to put it in
        if( dx > 0 ){ 
            if( dy > 0 ){
                // top right
                npr.setHeading( Math.abs(angle) );
                return;
            }else if( dy < 0){
                // bottom right
                npr.setHeading( 180 - angle );
                return;
            }
        }else if( dx < 0 ){
            if( dy > 0){
                // top left
                npr.setHeading( 360 - angle );
                return;
            }else if( dy < 0){
                // bottom left
                npr.setHeading( 180 + Math.abs(angle) );
                return;
            }
        }

     }

    @Override
    public void invokeStrategy() {
        setStrategy();

    }
}