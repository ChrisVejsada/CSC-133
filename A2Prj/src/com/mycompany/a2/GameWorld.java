package com.mycompany.a2;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;
	
	public class GameWorld extends Observable {
		private boolean soundOn = false;
		private int mapHeight;
		private int mapWidth;
		private int lives;
		private Random rand = new Random();
		private int counter = 0;
		//private Robot robot;
		private PlayerRobot robot;
		private int clock = 0;
		private boolean soundChecked = false;
		private int baseSize = 15;
		private int robotSize = 25;
		//Timer timer = new Timer();
		private boolean isExit = true;
		private int winningBase = 4;
		GameObjectCollection gameObjectList;
		
		public GameWorld() {
			gameObjectList = new GameObjectCollection();
			robot = new PlayerRobot(robotSize, 0, 500, 500);
		}
		
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
		
		public void setMapHeight(int height) {
			this.mapHeight = height;
			System.out.println("" + height);
		}
		
		public void setMapWidth(int width) {
			this.mapWidth = width;
		}
		
		/**
		 * Starts the game and resets the gameObjects just in case
		 */
		public void init() {
		//clears the gameObjectList before play
			//gameObjectList.clear();
			
			//Creating Static objects
			gameObjectList.add(new Base(baseSize, 1,500, 500));
			gameObjectList.add(new Base(baseSize, 2,100, 750));
			gameObjectList.add(new Base(baseSize, 3,400, 400));
			gameObjectList.add(new Base(baseSize, 4,1000, 125));
			gameObjectList.add(new EnergyStation(randObjSize(),randX(),randY()));
			gameObjectList.add(new EnergyStation(randObjSize(),randX(),randY()));
			
			//creates player
			gameObjectList.add(robot);
			
			//creat npr
			gameObjectList.add(new NonPlayerRobot(robotSize, 0, 500, 550));
			gameObjectList.add(new NonPlayerRobot(robotSize, 0, 500, 450));
			gameObjectList.add(new NonPlayerRobot(robotSize, 0, 550, 500));
			
			
			//creates attack drones
			gameObjectList.add(new Drone(randObjSize(), randX(), randY()));
			gameObjectList.add(new Drone(randObjSize(), randX(), randY()));
			
			this.setChanged();
			this.notifyObservers();
			
			
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
			System.out.println();
			IIterator elements = gameObjectList.getIterator();
			while (elements.hasNext()) {
				GameObject temp = ((GameObject) elements.getNext());
				System.out.println(temp.toString());
			}
		}
		
		private void lifeReset() {//resets drone to start base to continue where left off
			robot.resetRobot();
		}
		
		public void toggleSound() {
			this.soundChecked = !(this.soundChecked);
			this.setChanged();
			this.notifyObservers();
		}

		public void tick() {
			if(robot.getDamageLevel()!=100 && robot.getEnergyLevel() !=0 && robot.getLives()!=0) {
				robot.setHeading(robot.getStearingDirection());
				robot.setEnergyLevel(300);//reduces robot evergy level by 1
				counterTime();
			
				IIterator elements = gameObjectList.getIterator();
				while ( elements.hasNext()) {
					GameObject temp = ((GameObject) elements.getNext());
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
			notifyobs();
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
		public String isSound() {
			if (this.soundChecked) {
				return " ON";
			} else {
				return " OFF";
			}

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
		//Creating randInts for the game
		private int randX() {
			return rand.nextInt(mapWidth);
		}
		private int randY() {
			return rand.nextInt(mapHeight);
		}
		private int randObjSize() {
			return 15+rand.nextInt(25);
		}
		/*public void robotCollision(char with) {
			robot.collision(with);
		}*/
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
		
		public void energyStationCollision() {
			IIterator iterator = gameObjectList.getIterator();
			while(iterator.hasNext()) {
				GameObject temp = (GameObject) iterator.getNext();
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

		public void counterTime() {
			counter += 1;
		}
		
		private void notifyobs() {
			this.setChanged();
			this.notifyObservers();
		}
		
		
}
