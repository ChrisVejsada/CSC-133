package com.mycompany.a2;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String; 

public class Game extends Form {
	private GameWorld gw;
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}
	
	private void play() {
		Label myLabel = new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		
		myTextField.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent evt) {
				
			
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				switch(sCommand.charAt(0)) {
				case 'x':
					//System.out.println("Please Confirm to exit");
					myLabel.setText("Please enter y or n");
					gw.quitGame();
					break;
				
				case 'a':
					gw.setRobotSpeed(2);
					break;
				
				case 'b':
					gw.setRobotSpeed(-2);
					break;
				
				case 'l':
					gw.changeHeading('l');
					break;
				
				case 'r':
					gw.changeHeading('r');
					break;
				
				case 'c':
					gw.robotCollision('r');
					break;
				
				case '1':
					gw.baseCollision(1);
					break;
				
				case '2':
					gw.baseCollision(2);
					break;
				
				case '3':
					gw.baseCollision(3);
					break;
				
				case '4':
					gw.baseCollision(4);
					break;
				
				case '5':
					gw.baseCollision(5);
					break;
				
				case '6':
					gw.baseCollision(6);
					break;
				
				case '7':
					gw.baseCollision(7);
					break;
				
				case '8':
					gw.baseCollision(8);
					break;
				
				case '9':
					gw.baseCollision(9);
					break;
				
				case 'e':
					gw.energyStationCollision();
					break;
				
				case 'g':
					gw.robotCollision('d');
					break;
				
				case 't':
					gw.tick();;
					break;
				
				case 'd':
					gw.display();
					break;
				
				case 'm':
					gw.map();
					break;
				
				case 'n':
					gw.dontQuit();
					myLabel.setText("Enter a Command:");
					break;
				
				case 'y':
					gw.exit();
					break;
					
				
				}
			}
		});
	}
	
}
			
		
		