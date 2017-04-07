package com.jensen.model;

public class Model {
	
	private String[] scoreName = {"Övre Delen", "Ettor" ,"Tvåer",
								"Treor", "Fyror" ,"Femor",
								"Sexor","Nedere Del", "Par", 
								 "Två Par","Tre Tal", "Fyr Tal", 
								 "Liten","Stor", "Fullt Hus", 
								 "Chans","YATZY", "Total",}; 
	
	private String[] playerName;
	private int numberPlayers;
	private String[][] scoreBoard;
	
	public Model(String[] playerName){
		
		Correction corr = new Correction();
		
		this.playerName = playerName;
		this.numberPlayers = playerName.length;
		this.scoreBoard = new String[numberPlayers][19];
		
			for(int i = 0; i < numberPlayers; i++){
				scoreBoard[0][i] = playerName[i];
			}
		
	}

	public String[][] getScoreBoard() {
		return scoreBoard;
	}

	public void setScoreBoard(String[][] scoreBoard) {
		this.scoreBoard = scoreBoard;
	}

	public String[] getScoreName() {
		return scoreName;
	}

}
