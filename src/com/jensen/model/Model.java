package com.jensen.model;

/**
 * 
 * @author Takeyoshi, Jonas, Sergej, Oskar
 * @version 1.0
 */
public class Model {
	//values
	private String[] scoreName =
	{"Spelare", "Ettor" ,"Tvåer",
	"Treor", "Fyror" ,"Femmor",
	"Sexor","Summa","Bonus", "Par", 
	"Två Par","Tretal", "Fyrtal", 
	"Liten Stege","Stor Stege", "Kåk", 
	"Chans","YATZY", "Totalt"}; 
	private String[] playerName;
	private int numberPlayers;
	private Dice[] diceArray = new Dice[5];
	private String[][] scoreBoard;
	private int[][] underlyingScoreboard = new int[19][6];
	public static int[] diceResult = new int[5];
	//states
	private boolean[][] placedOrNot = new boolean[19][6];
	private boolean diceThrow[] = new boolean[5];
	private boolean continuePlaying = true;
	private boolean placementDone = true;
	private boolean resetDiceResult = false;
	private boolean onePlayerRule;
	private int gameOver = 0;
	//counter
	private static int rollCounter;
	private static int turn;
	
	/**
	 * This constructor control the game i.e names, dice throw, who's turn it is etc.
	 * @param pN is a string array that holding all players names.
	 */
	public Model(String[] pN){
		
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
	
	/**
	 * This method returns a players name from a string array, given from a specific index number. 
	 * @param i is the index of a players name
	 * @return a string that is a players name.
	 */
	public String getPlayerName(int i){
		return playerName[i];
	}
	
	/**
	 * This method assigns a score on the scoreboard that is a two dimensional array.
	 * @param score is an integer representing the score you want to set.
	 * @param i is a index of the row.
	 * @param j is a index of the column.
	 */
	public void setScore(int score, int i, int j){
		underlyingScoreboard[i][j] = score;
	}
	
	/**
	 * This method returns a score from the scoreboard that is a two dimensional array.
	 * @param i equals row index.
	 * @param j equals column index.
	 * @return an integer representing the score from the scoreboard
	 */
	public int getScore(int i, int j){
		return underlyingScoreboard[i][j];
	}
	
	/**
	 * This method keeps track of a players rolls, (maximum 3 rolls).
	 */
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
	
	/**
	 * This method keeps track of a players turn.
	 */
	public void whosTurn(){
		for(int i=0; i<6; i++){
			placedOrNot[0][i] = false;
		}
		placedOrNot[0][turn] = true;
	}
	
	/**
	 * This method assigns next player in turn.
	 */
	public void setNextInTurn(){
		turn = turn + 1;
		if(turn == numberPlayers){
			turn = 0;
		}
	}
	
	/**
	 *  This method returns an integer (index) representing who's turn it is.
	 * @return an integer representing who's turn it is.
	 */
	public int getTurn(){
		return turn;
	}
	
	/**
	 * This method generates all the dice numbers, (five dice each randomly 1-6).
	 * @see Dice class.
	 */
	public void roll() {
		Dice dice = new Dice();
		for(int i=0; i<5; i++){
			if(diceThrow[i]){
				diceResult[i] = dice.value();
			}
		}
	}
	
	/**
	 * This method returns an integer array holding all the dice results.
	 * @return an integer array holding all the dice results.
	 */
	public int[] getRollResult() {
		return diceResult;
	}
	
	/**
	 * This method resets the roll counter to zero.
	 */
	public void setResetRollCounter(){
		rollCounter = 0;
	}
	
	/**
	 * This method returns an integer of the roll counter representing how many rolls there has been.
	 * @return an integer representing how many rolls there has been.
	 */
	public int getRollCounter() {
		return rollCounter;
	}
	
	/**
	 * This method returns an integer representing how many players participating in the game.
	 * @return an integer representing how many players participating in the game.
	 */
	public int getNumberPlayers(){
		return numberPlayers;
	}
	
	/**
	 *  This method returns a underlying scoreboard (an integer two dimensional array) holding all the scores.
	 * @return a underlying scoreboard (an integer two dimensional array) holding all the scores.
	 */
	public int[][] getUnderlyingScoreboard(){
		return underlyingScoreboard;
	}
	
	/**
	 * This method assigns that a placement has been done on the scoreboard.
	 * @param i is an integer equals row index.
	 * @param j is an integer equals column index.
	 */
	public void setPlacedTrue(int i, int j){
		placedOrNot[i][j] = true;
	}
	
	/**
	 * This method determines if a placement has been done, on a given row and column index.
	 * @param i is an integer equals row index.
	 * @param j is an integer equals column index.
	 * @return Boolean value, true if a placement has been done.
	 */
	public boolean getPlaced(int i, int j){
		return placedOrNot[i][j];
	}
	
	/**
	 * This method determines which one of the dice you want to throw
	 * @param i is an integer representing one the dice 1-5.
	 * @param b is a boolean representing if you want to throw the dice, true if you want to throw.
	 */
	public void setDiceThrow(int i, boolean b){
		diceThrow[i] = b;
	}
	
	/**
	 * This method returns a boolean of a dice representing if you want to throw it or save it.
	 * @param i is an integer representing one the dice 1-5.
	 * @return a boolean representing if you want to throw the dice or save it, true if you want to throw.
	 */
	public boolean getDiceThrow(int i){
		return diceThrow[i];
	}
	
	/**
	 * This method keeps track on a players rolls (maximum 3 rolls).
	 */
	public void continuePlaying(){
		if(getRollCounter() == 3){
			continuePlaying = false;
		}
	}
	
	/**
	 * This method assigns a boolean representing if a player is allowed to roll or has to make a placement. True if the player are allowed to roll.
	 * @param b is a boolean, true if a player can continue play.
	 */
	public void setContinuePlaying(boolean b){
		continuePlaying = b;
	}
	
	/**
	 * This method returns a boolean representing if a player is allowed to roll or has to make a placement.
	 * @return a boolean, true if the player are allowed to roll.
	 */
	public boolean getContinuePlaying(){
		return continuePlaying;
	}
	
	/**
	 * This method assigns if a placement has been done or not.
	 * @param b is a boolean representing if a placement has been done or not, true if a placement has been done.
	 */
	public void setPlacementDone(boolean b){
		placementDone = b;
	}
	
	/**
	 * This method returns a boolean representing if a placement has been done or not.
	 * @return a boolean representing if a placement has been done or not. True if a placement has been done.
	 */
	public boolean getPlacementDone(){
		return placementDone;
	}
	
	/**
	 * This method assigns to reset the dice.
	 * @param b is a boolean representing if you want to reset the dice, true if you want.
	 */
	public void setResetDiceResult(boolean b){
		resetDiceResult = b;
	}
	
	/**
	 * This method returns a boolean representing if the dice are going to reset or not.
	 * @return a boolean representing if the dice are going to reset, true if they are going to reset.
	 */
	public boolean getResetDiceResult(){
		return resetDiceResult;
	}
	
	/**
	 * This method calculates the sum of Yatzy-point category ones to sixes and assigns it to the underlying scoreboard.
	 */
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
	
	/**
	 * This method returns the sum of Yatzy-point category ones to sixes from one player, given a specific index.
	 * @param i is an integer representing a index of a player.
	 * @return an integer representing the sum of Yatzy-point category ones to sixes from one player.
	 */
	public int getBonusSum(int i){
		return underlyingScoreboard[7][i];
	}
	
	/**
	 * This method calculates every Yatzy-point category and assigns it to the underlying scoreboard.
	 */
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
	
	/**
	 * This method keeps track if the game is over.
	 * @return a boolean representing if the game is over, true if the game is over.
	 */
	public boolean gameComplete(){
		for(int i=1; i<19; i++){
			for(int j=0; j<numberPlayers; j++){
				if(!placedOrNot[i][j]){
					gameOver = gameOver + 1;
				}
			}
		}
		if(gameOver == 0){
			return true;
		}
		else{
			gameOver= 0;
			return false;
		}
	}
	
	/**
	 * This method returns an integer representing an index of a player with the highest points, the winner.
	 * @return an integer representing an index of a player with the highest points, the winner.
	 */
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
	
	/**
	 * This method is a rule, only applied if there is only one player playing the game. To prevent multiple placement of one dice throw result.
	 * @param b is a boolean representing a state that has to be true if the player are going to be able to make a placement.
	 */
	public void setOnePlayerRule(boolean b){
		onePlayerRule = b;
	}
	
	/**
	 * This method returns a boolean representing a rule, only applied if there is only one player playing the game. To prevent multiple placement of one dice throw result.
	 * @return a boolean representing a state that has to be true if the player are going to be able to make a placement.
	 */
	public boolean getOnePlayerRule(){
		return onePlayerRule;
	}
}