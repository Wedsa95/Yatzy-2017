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
		
		for(int i= 0; i < nPlayers; i++ )
		{
			playerNames[i] = initPlayers(i+1);;
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
				 numberOfPlayers = JOptionPane.showInputDialog(" Hur många spelare (1-6): ");
				 if (numberOfPlayers != null){
					 nPlayers = Integer.parseInt(numberOfPlayers); 
				 }
				 else{
					  JFrame frame = new JFrame();
					  JOptionPane.showMessageDialog(frame, "Spelet avslutas", "Message",JOptionPane.INFORMATION_MESSAGE);
					  System.exit(0); 
				  }
			 }
			 cont = false;
		  }
		 catch (NumberFormatException e)
		 {
			 JFrame frame = new JFrame();
			 			
			 JOptionPane.showMessageDialog(frame, "Ogiltig antal spelare !!!",
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
			  
				  nameOfPlayers = JOptionPane.showInputDialog(" Spelarens namn " + x);
				 try {
					 if(nameOfPlayers.equals(""))
					 {
						 JFrame frame = new JFrame();
					  
						 JOptionPane.showMessageDialog(frame, "Spelarens namn är tomt !!!",
						   "Input error", JOptionPane.ERROR_MESSAGE); 
					 }
					 else
					 {
						 cont = false;
					 }
				 }
				 catch(Exception e)
	              {
	                 JOptionPane.showMessageDialog(null,"Spelet avslutas !!!","Input error", JOptionPane.ERROR_MESSAGE);
	                 System.exit(0); 
	              }
		  } while(cont);
		return nameOfPlayers.trim().toUpperCase();
	  }
}
