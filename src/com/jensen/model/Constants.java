/**
 * Yatzy ver.2 - demo
 * 
 * @author Group_5 
 * 
 * @since 2.0
 * 
 */
package com.jensen.model;

public enum Constants {
	N_SIDES(6), N_DICE(5), MAX_PLAYERS(6), N_CATEGORIES(16), ONES(1), TWOS(2), THREES(3), FOURS(4), FIVES(5), SIXES(6),
	THREE_KIND(0), FOUR_KIND(0),   FULL_HOUSE(25), S_STRIGHT(30), L_STRIGHT(40), YAHTZEE(50), CHANCE(0), BONUS(35), Y_BONUS(100);
	
	private int number;
	
	/**
	 * Constructor for Constants-class
	 * 
	 */
	Constants(int number) {
        this.number = number;
	}

	/**
	 * Get number method
	 * @return int
	 */
	public int getNumber() {
		return this.number;
	}
	/*public String getNumberString() {
		String numString = Integer.toString(this.number);
		return numString;
	}*/
	
	/**
	 * Set number method
	 * @return
	 */
	public void setNumber(int number) {
		this.number = number;
	}
}