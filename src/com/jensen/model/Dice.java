package com.jensen.model;
import java.util.Random;


/**
*
* @author ozzyoskar
*  Instructions: 
*   - Create Dice- object t.ex:
*  		Dice myDice = new Dice();
*	- Every time you can use value()- method to get new the random number from 1 to 6 t.ex: 
*		myNumber = myDice.value());
*/
public class Dice {
	
	private Random rand;
	private int value;
	private int sides;
	
	// Constructor for Dice-class
	public Dice()
	{
		sides = 6;
		rand = new Random();
	}
	
   public int value()
	{
	   rand = new Random();
	   value = rand.nextInt(sides) + 1;
	   return value;
	}
}