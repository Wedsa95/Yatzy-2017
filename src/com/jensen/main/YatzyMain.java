package com.jensen.main;

import com.jensen.controller.Controller;
import com.jensen.model.Model;
import com.jensen.view.View;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class YatzyMain {
	
	public static void main(String[] args) {
		
		int nPlayers = 0;
		
		//Number of players				
		nPlayers = initNumberOfPlayers();
		String[] playerNames = new String[nPlayers];
		
		//Players names
		if(nPlayers == 1)
		{
			int choice = JOptionPane.showConfirmDialog(null, "Will you play with computer?", null, JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION){
				playerNames[0] = initPlayers(1);
				//TO DO play with computer
				
			} else if(choice == JOptionPane.NO_OPTION){
				playerNames[0] = initPlayers(1);
			}
		}
		else {
			for(int i= 0; i < nPlayers; i++ )
			{
				playerNames[i] = initPlayers(i+1);;
			}
		}
		
		Model model = new Model(playerNames);
		View view = new View(nPlayers);
	
		Controller con = new Controller(model, view);
	}
	
	
	/*
	 * Input of players number
	 */
	public static int initNumberOfPlayers()
	  {
		boolean cont = true;
		int nPlayers = 0;
		
		do {
		try{
			 String numberOfPlayers;
		  
			 while (nPlayers < 1 || nPlayers > 6)
			 {
				 numberOfPlayers = JOptionPane.showInputDialog(" Enter the number of player (1-6): ");
				 if (numberOfPlayers != null){
					 nPlayers = Integer.parseInt(numberOfPlayers); 
				 }
				 else{
					  JFrame frame = new JFrame();
					  JOptionPane.showMessageDialog(frame, "Game is over", "Message",JOptionPane.INFORMATION_MESSAGE);
					  System.exit(0); 
				  }
			 }
			 cont = false;
		  }
		 catch (NumberFormatException e)
		 {
			 JFrame frame = new JFrame();
			 			
			 System.out.println("Illegal number, " + e); 
			 JOptionPane.showMessageDialog(frame, "Illegal number of Players !!!",
					    "Input error",
					    JOptionPane.ERROR_MESSAGE);
		 }
		} while(cont);
		 return nPlayers;
		 
	  }

	public static String initPlayers(int x)
	  {
		  String nameOfPlayers = "";
		  boolean cont = true;
		  
		  do {
			  
				  nameOfPlayers = JOptionPane.showInputDialog(" Name for Player " + x);
				 
				  if(nameOfPlayers.equals(""))
				  {
					  JFrame frame = new JFrame();
					  
					  JOptionPane.showMessageDialog(frame, "Players Name is empty !!!",
						   "Input error", JOptionPane.ERROR_MESSAGE); 
				  }
				  else
				  {
					  cont = false;
				  }
		  } while(cont);
		return nameOfPlayers.trim().toUpperCase();
	  }
}
