package com.mycompany.a3;
import com.codename1.util.MathUtil;

public class RobotHuntStrategy implements IStrategy {

	private Robot myRobo;
    private Robot targetRobo;

    public RobotHuntStrategy(Robot thisRobo, Robot target){
        myRobo = thisRobo;
        targetRobo = target;
    }



    public void setStrategy(){

        // change in x and y
        double dx, dy;

        dx = targetRobo.getX() - myRobo.getX();
        dy = targetRobo.getY() - myRobo.getY();

        // check for needing to move on axis, this also accounts
        // for checking of division by 0

        // is the y val the same?
        if( dy == 0 )
            if( dx < 0 ){
                
                myRobo.setNPRHeading(270);
                return;
            }
            else if( dx > 0 ){
         
                myRobo.setNPRHeading(90);
                return;
            }

        // is x val the same?
        if( dx == 0 )
            if( dy > 0 ){
             
                myRobo.setNPRHeading(0);
                return;
            }else if( dy < 0 ){
           
                myRobo.setNPRHeading(180);
                return;
            }

        int angle = (int)Math.toDegrees(MathUtil.atan(dx/dy) );

        // got the angle, now figure out which quadrant to put it in
        if( dx > 0 ){ 
            if( dy > 0 ){
                // top right
                myRobo.setNPRHeading( Math.abs(angle) );
                return;
            }else if( dy < 0){
                // bottom right
                myRobo.setNPRHeading( 180 - angle );
                return;
            }
        }else if( dx < 0 ){
            if( dy > 0){
                // top left
                myRobo.setNPRHeading( 360 - angle );
                return;
            }else if( dy < 0){
                // bottom left
                myRobo.setNPRHeading( 180 + Math.abs(angle) );
                return;
            }
        }
    }


	@Override
	public void invokeStrategy() {
		setStrategy();
		
	}

}