package com.jensen.model;

import com.jensen.controller.Correction;

public class Model {
	
	
	
	

	private String[] scoreName =
	{"Spelare", "Ettor" ,"Tvåer",
	"Treor", "Fyror" ,"Femor",
	"Sexor","Summa","Bonus", "Par", 
	"Två Par","Tre Tal", "Fyr Tal", 
	"Liten","Stor", "Fullt Hus", 
	"Chans","YATZY", "Total"}; 
	
	private String[] playerName;
	private static int numberPlayers;
	//TaBort
	private String[][] scoreBoard;
	
	//yoshi
		public int[][] underlyingScoreboard = new int[19][6];
		public boolean[][] placedOrNot = new boolean[19][6];
		
		static String value;
		boolean state = true;
		public static int rollCounter;
		

		private static int turn;
		
		private Dice[] diceArray = new Dice[5];
		
		public static int[] diceResult = new int[5];
		//Boolean [] Controller 
		public static boolean diceOne = true;
		public static boolean diceTwo = true;
		public static boolean diceThree = true;
		public static boolean diceFour = true;
		public static boolean diceFive = true;
	
	public Model(String[] pN){
		
		this.playerName = pN;
		this.numberPlayers = playerName.length;
		this.scoreBoard = new String[numberPlayers][19];
		
			for(int i = 0; i < 5; i++){
				diceArray[i] = new Dice();
			}
			for(int i = 0; i < numberPlayers; i++){
				scoreBoard[i][0] = playerName[i];
			}
	}

	public String[][] getScoreBoard() {
		return scoreBoard;
	}
	public Dice[] getDiceArray() {
		return diceArray;
	}
	public void setScoreBoard(String[][] scoreBoard) {
		this.scoreBoard = scoreBoard;
	}
	public String[] getScoreName() {
		return scoreName;
	}
	
	public  void setScore(int score, int i, int j){
		underlyingScoreboard[i][j] = score;
	}
	public  int getScore(int i, int j){
		return underlyingScoreboard[i][j];
	}
	public  void rollCounter(){
		rollCounter = rollCounter + 1;
		if(rollCounter==4){
			rollCounter = 1;
			turn = turn + 1;
			if(turn== numberPlayers){
				turn = 0;
			}
		}
	}
	public  int getTurn(){
		return turn;
	}

	public int[] rollDice() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getRollCounter() {
		return rollCounter;
	}
}
