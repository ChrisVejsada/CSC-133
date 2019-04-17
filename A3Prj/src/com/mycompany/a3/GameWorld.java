package com.mycompany.a3;


import java.util.ArrayList;

import java.util.Observable;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
	
	public class GameWorld  extends Observable{
		private int mapHeight;
		private boolean positionable, energyCol= false, crashCol= false, deathCol=false;
		private int mapWidth;
		private int contWidth,contHeight;
		private Random rand = new Random();
		private int counter = 0;
		private PlayerRobot robot ;
		
		private double nonDisplayClock;
		private int lives;
		private GameObject lastCollsion;
		private int baseSize = 30;
		private boolean ispause = false;
		private int robotSize = 25;
		private boolean isExit = false;
		private ArrayList<GameObject> colliderList = new ArrayList<GameObject>();
		
		private boolean soundOn = false;
		GameObjectCollection gameObjectList;
		public GameWorld() {
			gameObjectList = new GameObjectCollection();
			 robot= new PlayerRobot(this, robotSize, 0, 500, 500);
			 lastCollsion = robot;
		}
		public int getMapWidth() {
			return mapWidth;
		}
		public int getMapHeight() {
			return mapHeight;
		}
		//Exits for the game
		public void exit() {
			if (isExit)
				System.exit(0);
		}
		public void setMapWidth(int width) {
			mapWidth = width;
		
		}
		public void setMapHeight(int height) {
			this.mapHeight = height;
			
		}
		public void quitGame() {
			System.out.println("do you wish to exit? (y/n)");
			isExit=true;
		}
		public void dontQuit() {
			isExit=false;
		}
		public void setWidthHeight(int width, int height) {
			contWidth = width;
			contHeight=height;
		}
		public int getContWidth(){
			return contWidth;
		}
		public int getContheight(){
			return contHeight;
		}
		/**
		 * Starts the game and resets the gameObjects just in case
		 */
		public void init() {
		//clears the gameObjectList before play
			//gameObjectList.clear();
			
			
			//Creating Static objects
			gameObjectList.add(new Base(this,baseSize, 1,500, 500));
			gameObjectList.add(new Base(this,baseSize, 2,100, 750));
			gameObjectList.add(new Base(this,baseSize, 3,400, 400));
			gameObjectList.add(new Base(this,baseSize, 4,1000, 125));
			gameObjectList.add(new EnergyStation(this, randObjSize(),randX(),randY()));
			gameObjectList.add(new EnergyStation(this,randObjSize(),randX(),randY()));
			
			//adds player to list
			gameObjectList.add(robot);
		
			gameObjectList.add(new NonPlayerRobot(robotSize, 0, 500, 550,this));
			gameObjectList.add(new NonPlayerRobot(robotSize, 0, 500, 450,this));
			gameObjectList.add(new NonPlayerRobot(robotSize, 0, 550, 500,this));
			
			//creates attack drones
			gameObjectList.add(new Drone(this, randObjSize(), randX(), randY()));
			gameObjectList.add(new Drone(this,randObjSize(), randX(), randY()));
			
			
		}
	
		public void display() {
			System.out.println("Lives left: "+robot.getLives()
			+	", Current clock time: "+counter+", Last base reached: "+robot.getLastBase()+", Energy Level: "
			+robot.getEnergyLevel()+", Damage: "+robot.getDamageLevel());
			
		}
		public void map() {
			IIterator elements = gameObjectList.getIterator();
			while (elements.hasNext()) {
				GameObject temp = ((GameObject) elements.getNext());
				System.out.println(temp.toString());
			}
		}
		public void toggleSound() {
			if(!soundOn)
				soundOn=true;
			else
				soundOn=false;
			this.setChanged();
			this.notifyObservers();
		}
		public void changeNPCStrategies(){
			System.out.println("changing strategy");
			IIterator anIterator = gameObjectList.getIterator();
			
			Object currentObj = new Object();
			
			while( anIterator.hasNext() ){
				currentObj = anIterator.getNext();
				if( currentObj instanceof NonPlayerRobot){ 
					
					
					((NonPlayerRobot)currentObj).baseCollision(((NonPlayerRobot) currentObj).getLastBase() + 1);;
					
		 
					if( ((NonPlayerRobot)currentObj).getStrategy() instanceof NextBaseStrategy ){
						((NonPlayerRobot)currentObj).setStrategy(new RobotHuntStrategy(((NonPlayerRobot)currentObj), robot));
					} else if ( ((NonPlayerRobot)currentObj).getStrategy() instanceof RobotHuntStrategy ){
						((NonPlayerRobot)currentObj).setStrategy(new NextBaseStrategy(((NonPlayerRobot)currentObj), this));
					}
				}
			}
			notifyobs();
		}

		public void tick(int elapsedTime) {
			if(robot.getLastBase() == 4) {
				System.out.print("WINNER");
				System.exit(0);
			}
				
			if((robot.getDamageLevel()!=100 && robot.getDamageLevel() <=100) && robot.getEnergyLevel() !=0 && robot.getLives()!=0) {
				robot.setHeading(robot.getStearingDirection());
				robot.setEnergyLevel(300);//reduces robot evergy level by 1
				counterTime();
			
				IIterator elements = gameObjectList.getIterator();
				while ( elements.hasNext()) {
					GameObject temp = ((GameObject) elements.getNext());
					if(temp instanceof Moveable) {
						if(temp instanceof Drone) {
							((Moveable) temp).setHeading(((Moveable) temp).getHeading());
							((Moveable) temp).move(this, elapsedTime);
						}
					else
						((Moveable) temp).move(this, elapsedTime);
					}
				}
				IIterator theColliders = gameObjectList.getIterator();
				
		        while(theColliders.hasNext()){
		            GameObject curObj = (GameObject)theColliders.getNext(); // get a collidable object 
		            // check if this object collides with any OTHER object
		            if (robot.collidesWith(curObj)) {

		                if (!colliderList.contains((GameObject)curObj)) {
		                    colliderList.add((GameObject) curObj);
		                    robot.handleCollision(curObj);

		                }
		            } else {
		                // take it out of the array
		                colliderList.remove((GameObject) curObj);

		            }
		        }

				
		}
			else {
				if(robot.getLives()!=0) {
					deathCol =true;
					robot.setDamage(0);
					lifeReset();
				}
				else {
					System.out.println("Game Over");
				}
			}
			notifyobs();
		}
		
		public void robotCollision(char with) {
			
			robot.collision(with);
			IIterator iterator = gameObjectList.getIterator();
			while(iterator.hasNext()) {
				GameObject temp = (GameObject) iterator.getNext();
				if(temp instanceof NonPlayerRobot) {
					((NonPlayerRobot) temp).collision('r');
					break;
				}
			}
			notifyobs();
		}
		
		public void baseCollision(int baseNumber) {
			robot.baseCollision(baseNumber);
			notifyobs();
			
		}
		public void setRobotSpeed(int x) {
			robot.setSpeed(robot.getSpeed()+x);
			notifyobs();
		}
		public void changeHeading(char change) {
			robot.changeHeading(change);
			notifyobs();
		}
		public int getLives() {
			return robot.getLives();
		}
		public int getClock() {
			return counter;
		}
		public int getRobotBaseReached() {
			return robot.getLastBase();
		}
		public int getEnergyLevel() {
			return robot.getEnergyLevel();
		}
		public int getRobotHealthLevel() {
			return robot.getDamageLevel();
		}
		public boolean isSound() {
			return soundOn;
		}
		public void energyStationCollision(GameObject temp) {
			energyCol = true;

					if(((EnergyStation) temp).getCapacity()!=0) {
						robot.setEnergyLevel(((EnergyStation) temp).getCapacity());
						((EnergyStation) temp).setCapacity();
						temp.setColor(ColorUtil.rgb(0, 255, 191));
						
					}
				
			
			gameObjectList.add(new EnergyStation(this,randObjSize(), randX(), randY()));
			notifyobs();
		}
		private void notifyobs() {
			this.setChanged();
			this.notifyObservers();
		}
		
		public void counterTime() {
			nonDisplayClock += (1/50.00);
			counter=(int) nonDisplayClock;
		}
		private void lifeReset() {//resets drone to start base to continue where left off
			robot.resetRobot();
			setDeathCol(true);
		}
		//Creating randInts for the game
		private int randX() {
			return rand.nextInt((mapWidth-contWidth));
		}
		private int randY() {
		
			return rand.nextInt((mapHeight-contHeight));
		}
		private int randObjSize() {
			return 15+rand.nextInt(25);
		}
		public Robot getRobot() {
			// TODO Auto-generated method stub
			return robot;
		}
		public boolean isIspause() {
			return ispause;
		}
		public void setIspause(boolean ispause) {
			this.ispause = ispause;
		}
		public boolean isPositionable() {
			return positionable;
		}
		public void setPositionable(boolean positionable) {
			this.positionable = positionable;
		}
		public boolean isEnergyCol() {
			return energyCol;
		}
		public void setEnergyCol(boolean energyCol) {
			this.energyCol = energyCol;
		}
		public boolean isCrashCol() {
			return crashCol;
		}
		public void setCrashCol(boolean crashCol) {
			this.crashCol = crashCol;
		}
		public boolean isDeathCol() {
			return deathCol;
		}
		public void setDeathCol(boolean deathCol) {
			this.deathCol = deathCol;

		}
	}
		
		
		
