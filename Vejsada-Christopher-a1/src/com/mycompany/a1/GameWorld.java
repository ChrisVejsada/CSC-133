package com.mycompany.a1;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;
	
	public class GameWorld {
		private Random rand = new Random();
		private int counter = 0;
		private Robot robot;
		private ArrayList<GameObject> gameObjectList = new ArrayList<GameObject>();
		private int baseSize = 15;
		private int robotSize = 25;
		//Timer timer = new Timer();
		private boolean isExit = false;
		
		//Exits for the game
		public void exit() {
			if (isExit)
				System.exit(0);
		}
		public void quitGame() {
			System.out.println("Do you wish to exit? (y/n)");
			isExit=true;
		}
		public void dontQuit() {
			isExit=false;
		}
		
		/**
		 * Starts the game and resets the gameObjects just in case
		 */
		public void init() {
		//clears the gameObjectList before play
			gameObjectList.clear();
			
			//Creating Static objects
			gameObjectList.add(new Base(baseSize, 1,500, 500));
			gameObjectList.add(new Base(baseSize, 2,100, 750));
			gameObjectList.add(new Base(baseSize, 3,400, 400));
			gameObjectList.add(new Base(baseSize, 4,1000, 125));
			gameObjectList.add(new EnergyStation(randObjSize(),randX(),randY()));
			gameObjectList.add(new EnergyStation(randObjSize(),randX(),randY()));
			
			//creates player
			gameObjectList.add(robot = new Robot(robotSize, 0, 500, 500));
			
			//creates attack drones
			gameObjectList.add(new Drone(randObjSize(), randX(), randY()));
			gameObjectList.add(new Drone(randObjSize(), randX(), randY()));
			
			
		}
		/**
		 * Displays information about the game
		 */
		public void display() {
			System.out.println("Lives left: "+robot.getLives()
			+	", Current clock time: "+counter+", Last base reached: "+robot.getLastBase()+", Energy Level: "
			+robot.getEnergyLevel()+", Damage: "+robot.getDamageLevel());
			
		}
		public void map() {
			
			for (GameObject temp: gameObjectList) {
				System.out.println(temp);
			}
		}
		private void lifeReset() {//resets drone to start base to continue where left off
			robot.resetRobot();
		}
		public void tick() {
			if(robot.getDamageLevel()!=100 && robot.getEnergyLevel() !=0 && robot.getLives()!=0) {
				robot.setHeading(robot.getStearingDirection());
				robot.setEnergyLevel(300);//reduces robot evergy level by 1
				counterTime();
			
				for(GameObject temp: gameObjectList) {
					if(temp instanceof Moveable) {
						if(temp instanceof Drone) {
							((Moveable) temp).setHeading(((Moveable) temp).getHeading());
							((Moveable) temp).move();
						}
					else
						((Moveable) temp).move();
					}
				}
				
		}
			else {
				if(robot.getLives()!=0) {
					lifeReset();
				}
				else {
					System.out.println("Game Over");
				}
			}

		}
		//Creating randInts for the game
		private int randX() {
			return rand.nextInt(1024);
		}
		private int randY() {
			return rand.nextInt(768);
		}
		private int randObjSize() {
			return 15+rand.nextInt(25);
		}
		public void robotCollision(char with) {
			robot.collision(with);
		}
		public void baseCollision(int baseNumber) {
			robot.baseCollision(baseNumber);
		}
		public void setRobotSpeed(int x) {
			robot.setSpeed(robot.getSpeed()+x);
		}
		public void changeHeading(char change) {
			robot.changeHeading(change);
		}
		
		public void energyStationCollision() {
			for(GameObject temp: gameObjectList ) {
				if(temp instanceof EnergyStation) {
					if(((EnergyStation) temp).getCapacity()!=0) {
						robot.setEnergyLevel(((EnergyStation) temp).getCapacity());
						((EnergyStation) temp).setCapacity();
						temp.setColor(ColorUtil.rgb(0, 255, 0));
						break;
					}
				}
			}
			gameObjectList.add(new EnergyStation(randObjSize(), randX(), randY()));
		}
		/*public void droneCollision() {
			robot.hitDrone();
		}
		*/
		public void counterTime() {
			counter += 1;
		}
		
		
		
}
