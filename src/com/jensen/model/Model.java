package com.jensen.model;

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
	private Dice[] diceArray = new Dice[5];
	//TaBort
	private String[][] scoreBoard;
	
	//yoshi*
	private Dice dice; // behövs?
	
	public int[][] underlyingScoreboard = new int[19][6];
	public boolean[][] placedOrNot = new boolean[19][6];
	public int booleanCounter;
	public boolean continuePlaying = true;
	public boolean placementDone = true;
	public boolean resetDiceResult = false;
	public boolean onePlayerRule;
	public int gameCompleted = 0;
	public static int rollCounter;
	private static int turn;
	public boolean diceThrow[] = new boolean[5];
	public static int[] diceResult = new int[5];
	//Boolean [] Controller 

	//*yoshi
		
	public Model(String[] pN){
		
		//yoshi*
		for(int i=0; i<19; i++){
			for(int j=0; j<6; j++){
				underlyingScoreboard[i][j] = -1;
			}
		}
		for(int i=0; i<5; i++){
			diceThrow[i]=true;
		}
		for(int i=0; i<6; i++){
			placedOrNot[7][i] = true;
		}
		for(int i=0; i<6; i++){
			placedOrNot[8][i] = true;
		}
		for(int i=0; i<6; i++){
			placedOrNot[18][i] = true;
		}
		//*yoshi
		
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
	
	//yoshi*
	public String getPlayerName(int i){
		return playerName[i];
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
	public void whosTurn(){
		for(int i=0; i<6; i++){
			placedOrNot[0][i] = false;
		}
		placedOrNot[0][turn] = true;
	}
	public void setNextInTurn(){
		turn = turn + 1;
		if(turn == numberPlayers){
			turn = 0;
		}
	}
	public int getTurn(){
		return turn;
	}
<<<<<<< HEAD
	public void continuePlay(){
		for(int i=0; i<19; i++){
			if(placedOrNot[i][getTurn()]){
				booleanCounter = booleanCounter + 1;
			}
		}
	}
	public void roll() {
		Dice d = new Dice();
=======
	
	/**
	 * This method generates all the dice numbers, (five dice each randomly 1-6).
	 * @see Dice class.
	 */
	public void roll() {
		Dice dice = new Dice();
>>>>>>> acb930e1f5d0ab7e2e1aa8e2c6380abc9753a12b
		for(int i=0; i<5; i++){
			if(diceThrow[i]){
				diceResult[i] = d.value();
			}
		}
	}
	public int[] getRollResult() {
		return diceResult;
	}
	public void setResetRollCounter(){
		rollCounter = 0;
	}
	public int getRollCounter() {
		return rollCounter;
	}
	public int getNumberPlayers(){
		return numberPlayers;
	}
	public int[][] getUnderlyingScoreboard(){
		return underlyingScoreboard;
	}
	public void setPlacedTrue(int i, int j){
		placedOrNot[i][j] = true;
	}
	public void setDiceThrow(int i, boolean b){
		diceThrow[i] = b;
	}
	public boolean getDiceThrow(int i){
		return diceThrow[i];
	}
	public boolean getPlaced(int i, int j){
		return placedOrNot[i][j];
	}
	public void continuePlaying(){
		if(getRollCounter() == 3){
			continuePlaying = false;
		}
	}
	public void setContinuePlaying(boolean b){
		continuePlaying = b;
	}
	public boolean getContinuePlaying(){
		return continuePlaying;
	}
	public void setPlacementDone(boolean b){
		placementDone = b;
	}
	public boolean getPlacementDone(){
		return placementDone;
	}
	public void setResetDiceResult(boolean b){
		resetDiceResult = b;
	}
	public boolean getResetDiceResult(){
		return resetDiceResult;
	}
	public int getGameCompleted(){
		return gameCompleted;
	}
	public void bonusSum(){
		for(int k=0; k<6; k++){
			underlyingScoreboard[7][k] = 0;
		}
		for(int i=1; i<7; i++){
			for(int j=0; j<6; j++){
				if(placedOrNot[i][j]){
					underlyingScoreboard[7][j] = underlyingScoreboard[7][j] + underlyingScoreboard[i][j];
				}
			}
		}
	}
	public int getBonusSum(int i){
		return underlyingScoreboard[7][i];
	}
	public void totalSum(){
		for(int k=0; k<6; k++){
			underlyingScoreboard[18][k] = 0;
		}
		for(int i=1; i<7; i++){
			for(int j=0; j<6; j++){
				if(placedOrNot[i][j]){
					underlyingScoreboard[18][j] = underlyingScoreboard[18][j] + underlyingScoreboard[i][j];
				}
			}
		}
		for(int i=8; i<18; i++){
			for(int j=0; j<6; j++){
				if(placedOrNot[i][j]){
					underlyingScoreboard[18][j] = underlyingScoreboard[18][j] + underlyingScoreboard[i][j];
				}
			}
		}
	}
	public boolean gameComplete(){
		for(int i=1; i<19; i++){
			for(int j=0; j<numberPlayers; j++){
				if(!placedOrNot[i][j]){
					gameCompleted = gameCompleted + 1;
				}
			}
		}
		if(gameCompleted == 0){
			return true;
		}
		else{
			gameCompleted = 0;
			return false;
		}
	}
	public int whoIsTheWinner(){
		int winner = 0;
		int winnerIndex = -1;
		for(int i=0; i<numberPlayers; i++){
			if(underlyingScoreboard[18][i] > winner){
				winner = underlyingScoreboard[18][i];
				winnerIndex = i;
			}
		}
		return winnerIndex;
	}
	public void setOnePlayerRule(boolean b){
		onePlayerRule = b;
	}
	public boolean getOnePlayerRule(){
		return onePlayerRule;
	}
	//*yoshi
}