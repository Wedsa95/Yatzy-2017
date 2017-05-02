package com.jensen.controller;

import com.jensen.model.Model;
/**
 * This Class assigns the correct value to each possible Yatzy-point category (e.g. chance, fullhouse,three of a kind etc)
 * @author Takeyoshi
 * @version 1.0
 */
public class Correction {
	
	private static Correction correction;
	
	private static Model model;
	
	//converter
	static int[] counter = new int[6];
    static int counter1;
    static int counter2;
    static int counter3;
    static int counter4;
    static int counter5;
    static int counter6;
    
    //one to six
    static int ones;
	static int twos;
	static int threes;
	static int fours;
	static int fives;
	static int sixes;
	
	//twoPair
	static boolean[] twoPairOf = new boolean[15];
	
	/**
	 * This constructor makes an object that takes in a Model object that it correct.
	 * @param model a model object of the yatzy game.
	 */
    public Correction(Model model) {
    	this.model = model;

    }
    
    /**
     * This method converts an integer array holding 5 values (representing a possible outcome when throwing 5 dice, i.e. a Yatzy dice throw) to a so called "counter". A "counter" sorts out the result of the 5 dice into a integer array that contains 6 slots in a specific order depending on the result of the 5 dice. 
     * @param diceResult is an integer array, the array receives five values representing the dice throw in a Yatzy game.
     * @return an integer array, is used in the Correction Class.   
     */
	//converting to counter
    public static int[] converter(int[] diceResult){
    	
    	counter1 = 0;
    	counter2 = 0;
    	counter3 = 0;
    	counter4 = 0;
    	counter5 = 0;
    	counter6 = 0;
    	
    	for(int i=0; i<5; i++){
            if(diceResult[i] == 1)
                counter1++;
            if(diceResult[i] == 2)
                counter2++;
            if(diceResult[i] == 3)
                counter3++;
            if(diceResult[i] == 4)
                counter4++;
            if(diceResult[i] == 5)
                counter5++;
            if(diceResult[i] == 6)
            	counter6++;
	    }
    	
	    for(int i=0; i<6; i++){
	        if(i==0)
	        	counter[i] = counter1;
	        if(i==1)
	        	counter[i] = counter2; 
	        if(i==2)
	        	counter[i] = counter3;
	        if(i==3)
	        	counter[i] = counter4; 
	        if(i==4)
	        	counter[i] = counter5;
	        if(i==5)
	        	counter[i] = counter6; 
	    }
	    return counter;
    }
    
    /**
     * This method checks each and every possible Yatzy-point category and then reports it to the "model".
     * @param diceResult is an integer array that represents the outcome of a Yatzy dice throw.
     */
    //checking a result of five dice and returns a string with all the possible alternatives
  	public static void check(int[] diceResult){
  		
  		int[] counter = converter(diceResult);
  		
  		//reseting the underlying scoreboard to zero if not placement has been done
  		for(int i=0; i<18; i++){
			for(int j=0; j<6; j++){
				if(!model.getPlaced(i, j)){ // !model.placedOrNot[i][j]
					model.setScore(-1, i, j);
				}
			}
		}
  		
  		//summing all the ones
  		if(counter[0]>=1)
  			if(!model.getPlaced(1, model.getTurn())){ //!model.placedOrNot[1][model.getTurn()]
  				model.setScore(one(counter), 1, model.getTurn());
  			}
  		
  		//summing all the twos
  		if(counter[1]>=1)
  			if(!model.getPlaced(2, model.getTurn())){ //!model.placedOrNot[2][model.getTurn()]
  				model.setScore(two(counter), 2, model.getTurn());
  			}
  		
  		//summing all the threes
  		if(counter[2]>=1)
  			if(!model.getPlaced(3, model.getTurn())){ //!model.placedOrNot[3][model.getTurn()]
  				model.setScore(three(counter), 3, model.getTurn());
  			}
  		
  		//summing all the fours
  		if(counter[3]>=1)
  			if(!model.getPlaced(4, model.getTurn())){ //!model.placedOrNot[4][model.getTurn()]
  				model.setScore(four(counter), 4, model.getTurn());
  			}
  		
  		//summing all the fives
  		if(counter[4]>=1)
  			if(!model.getPlaced(5, model.getTurn())){ //!model.placedOrNot[5][model.getTurn()]
  				model.setScore(five(counter), 5, model.getTurn());
  			}
  		
  		//summing all the sixes
  		if(counter[5]>=1)
  			if(!model.getPlaced(6, model.getTurn())){ //!model.placedOrNot[6][model.getTurn()]
  				model.setScore(six(counter), 6, model.getTurn());
  			}
  		
  		//Sum
  		model.bonusSum();
  		
  		//Bonus
  		if(model.getScore(7, model.getTurn())>=63){
  			model.setScore(50, 8, model.getTurn());
  		}
  		else if(model.getScore(7, model.getTurn())<63){
  			model.setScore(0, 8, model.getTurn());
  		}
  		
  		//checking if pair
  				if(pair(counter)){
  					if(threeOfAKind(counter) && fullHouse(counter)==false){
  						if(fourOfAKind(counter)){
  							if(yatzy(counter)){
  								if(!model.getPlaced(9, model.getTurn())){ //!model.placedOrNot[9][model.getTurn()]
  									model.setScore(threeOf(counter)*2, 9, model.getTurn());
  	  					  		}
  							}
  							else{
  								if(!model.getPlaced(9, model.getTurn())){ //!model.placedOrNot[9][model.getTurn()]
  									model.setScore(threeOf(counter)*2, 9, model.getTurn());
  	  					  		}
  							}
  						}
  						else{
  							if(!model.getPlaced(9, model.getTurn())){ //!model.placedOrNot[9][model.getTurn()]
  								model.setScore(threeOf(counter)*2, 9, model.getTurn());
  					  		}
  						}
  					}
  					else if(twoPair(counter)==false){
  						if(!model.getPlaced(9, model.getTurn())){ //!model.placedOrNot[9][model.getTurn()]
  							model.setScore(pairOf(counter)*2, 9, model.getTurn());
				  		}
  					}

  					else if(twoPair(counter)){ //ändrade till "else if", ist för bara "if"
  						if (fullHouse(counter)){
  							if(threeOf(counter) < pairOfHouse(counter)){
  									if(!model.getPlaced(9, model.getTurn())){ //!model.placedOrNot[9][model.getTurn()]
  										model.setScore(pairOfHouse(counter)*2, 9, model.getTurn());
  									}
								}
								else{
									if(!model.getPlaced(9, model.getTurn())){ //!model.placedOrNot[9][model.getTurn()]
										model.setScore(threeOf(counter)*2, 9, model.getTurn());
									}
								}
  						}
  						else if(twoPair(counter)){
  							if(!model.getPlaced(9, model.getTurn())){ //!model.placedOrNot[9][model.getTurn()]
  								if(twoPairOf1(counter) < twoPairOf2(counter)){
  									if(!model.getPlaced(9, model.getTurn())){ //!model.placedOrNot[9][model.getTurn()]
  										model.setScore(twoPairOf2(counter)*2, 9, model.getTurn());
  									}
  								}
  								else{
  									if(!model.getPlaced(9, model.getTurn())){ //!model.placedOrNot[9][model.getTurn()]
  										model.setScore(twoPairOf1(counter)*2, 9, model.getTurn());
  									}
  								}
  				  			}
  						}
  						else{
  							if(!model.getPlaced(9, model.getTurn())){ //!model.placedOrNot[9][model.getTurn()]
  								model.setScore(pairOf(counter)*2, 9, model.getTurn());
  				  			}
  						}
  					}
  				}
  		
  		//checking if two pair
  		if(twoPair(counter)){
  			if(twoPair(counter) && fullHouse(counter)){
  				if(!model.getPlaced(10, model.getTurn())){ //!model.placedOrNot[10][model.getTurn()]
  					model.setScore(threeOf(counter)*2 + pairOfHouse(counter)*2, 10, model.getTurn());
  		  		}
  		  	}
  		  	else{
  		  		if(!model.getPlaced(10, model.getTurn())){ //!model.placedOrNot[10][model.getTurn()]
  		  			model.setScore(twoPairOf1(counter)*2 + twoPairOf2(counter)*2, 10, model.getTurn());
  		  	  	}
  		  	}
  		}

  		//checking if three of a kind
  		if(threeOfAKind(counter)){
  			if(!model.getPlaced(11, model.getTurn())){ //!model.placedOrNot[11][model.getTurn()]
  				model.setScore(threeOf(counter)*3, 11, model.getTurn());
  			}
  		}

  		//checking if four of a kind
  		if(fourOfAKind(counter)){
  			if(!model.getPlaced(12, model.getTurn())){ //!model.placedOrNot[12][model.getTurn()]
  				model.setScore(fourOf(counter)*4, 12, model.getTurn());
  			}
  		}

  		//checking if small straight
  		if(smallStraight(counter)){
  			if(!model.getPlaced(13, model.getTurn())){ //!model.placedOrNot[13][model.getTurn()]
  				model.setScore(15, 13, model.getTurn());
  			}
  		}

  		//checking if large straight
  		if(largeStraight(counter)){
  			if(!model.getPlaced(14, model.getTurn())){ //!model.placedOrNot[14][model.getTurn()]
  				model.setScore(20, 14, model.getTurn());
  			}
  		}
  		
  		//checking if full house
  		if(fullHouse(counter)){
  			if(!model.getPlaced(15, model.getTurn())){ //!model.placedOrNot[15][model.getTurn()]
  				model.setScore(threeOf(counter)*3 + pairOfHouse(counter)*2, 15, model.getTurn());
  			}
  		}
  		
  		//calculate chance
  		if(!model.getPlaced(16, model.getTurn())){ //!model.placedOrNot[16][model.getTurn()]
  			model.setScore(chance(counter), 16, model.getTurn());
		}

  		//checking if yatzy
  		if(yatzy(counter)){
  			if(!model.getPlaced(17, model.getTurn())){ //!model.placedOrNot[17][model.getTurn()]
  				model.setScore(50, 17, model.getTurn());
  			}
  		}
  		
  		//Total
  		model.totalSum();
  		
  		//reseting the counter to zero. Very important! IS NEEDED FOR IT TO FUNCTION CORRECTLY
  		for(int i=0; i<6; i++)
  			counter[i] = 0;
  		
  		for(int i=0; i<15; i++){
  			twoPairOf[i] = false;
  		}
  	}
  	
  	//all the logic behind the correction of each and single possible combination you can get in a yatzy game
  	
  	/**
  	 * This method calculates the point value of the Yatzy-point category "chance".
  	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
  	 * @return An integer representing the point value of "chance".
  	 * @see The converter method.
  	 */
  	//checks chance
	public static int chance(int[] counter){
		return (counter[0]*1 + counter[1]*2 + counter[2]*3 + counter[3]*4 + counter[4]*5 + counter[5]*6); 
	}
	
	/**
  	 * This method calculates the point value of the Yatzy-point category "ones".
  	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
  	 * @return An integer representing the point value of "ones".
  	 * @see The converter method.
  	 */
	//returns the sum of all ones (int)
	public static int one(int[] counter){
		for(int i=0; i<6; i++){
			if(counter[0] == i){
				ones = 1*i;
			}
		}
		return ones;
	}
	
	/**
  	 * This method calculates the point value of the Yatzy-point category "twos".
  	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
  	 * @return An integer representing the point value of "twos".
  	 * @see The converter method.
  	 */
	//returns the sum of all twos (int)
	public static int two(int[] counter){
		for(int i=0; i<6; i++){
			if(counter[1] == i){
				twos = 2*i;
			}
		}
		return twos;
	}
	
	/**
  	 * This method calculates the point value of the Yatzy-point category "threes".
  	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
  	 * @return An integer representing the point value of "threes".
  	 * @see The converter method.
  	 */
	//returns the sum of all threes (int)
	public static int three(int[] counter){
		for(int i=0; i<6; i++){
			if(counter[2] == i){
				threes = 3*i;
			}
		}
		return threes;
	}
	
	/**
  	 * This method calculates the point value of the Yatzy-point category "fours".
  	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
  	 * @return An integer representing the point value of "fours".
  	 * @see The converter method.
  	 */
	//returns the sum of all fours (int)
	public static int four(int[] counter){
		for(int i=0; i<6; i++){
			if(counter[3] == i){
				fours = 4*i;
			}
		}
		return fours;
	}
	
	/**
  	 * This method calculates the point value of the Yatzy-point category "fives".
  	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
  	 * @return An integer representing the point value of "fives".
  	 * @see The converter method.
  	 */
	//returns the sum of all fives (int)
	public static int five(int[] counter){
		for(int i=0; i<6; i++){
			if(counter[4] == i){
				fives = 5*i;
			}
		}
		return fives;
	}
	
	/**
  	 * This method calculates the point value of the Yatzy-point category "sixes".
  	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
  	 * @return An integer representing the point value of "sixes".
  	 * @see The converter method.
  	 */
	//returns the sum of all sixes (int)
	public static int six(int[] counter){
		for(int i=0; i<6; i++){
			if(counter[5] == i){
				sixes = 6*i;
			}
		}
		return sixes;
	}
	
	/**
	 * This method checks if the Yatzy-point category "pair" is within the outcome of a Yatzy dice throw.
	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
	 * @return A boolean, returning true if it's "pair".
	 * @see The converter method.
	 */
	//checks pair
	public static boolean pair(int[] counter){
        if (counter[0]>=2 || counter[1]>=2 || counter[2]>=2 || counter[3]>=2 || counter[4]>=2 || counter[5]>=2)
            return true;
        else
            return false;
    }
	
	/**
	 * This method calculates the point value of the Yatzy-point category "pair".
	 * @param counter is an integer array representing a Yatzy dice throw.
	 * @return An integer representing the point value of the Yatzy-point category "pair".
	 * @see The converter method.
	 */
	//checks pair of
    public static int pairOf(int[] counter){
    	int pairOf = 0;
    	if (pair(counter)==true) {
            for(int i=0, j=1; i<6; i++, j++){
            	if (counter[i]>=2)
                    pairOf = j;
            }
        }
    	return pairOf;
    }
    
    /**
	 * This method calculate the point value of the pair in the Yatzy-point category "Full house".
	 * @param counter is an integer array representing a Yatzy dice throw.
	 * @return An integer representing the point value of the pair in the Yatzy-point category "Full house".
	 * @see The converter method.
	 */
    //checks pair of, when also there is full house
    public static int pairOfHouse(int[] counter){
    	int pairOf = 0;
    	if (pair(counter)) {
    		for(int i=0, j=1; i<6; i++, j++){
    			if (counter[i]==2)
                    pairOf = j;
            }
        }
    	return pairOf;
    }
    
    /**
	 * This method checks if the Yatzy-point category "two pair" is within the outcome of a Yatzy dice throw.
	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
	 * @return A boolean, returning true if it's "two pair".
	 * @see The converter method.
	 */
    //checks two pair
    public static boolean twoPair(int[] counter){
        
        if(fullHouse(counter)){
        	return true;
    	}
        for(int i=1, j=0; i<6; i++, j++){
        	if(counter[0]==2 && counter[i]==2){
            	twoPairOf[j] = true;
            	return true;
            }
        }
        for(int i=2, j=5; i<6; i++, j++){
        	if(counter[1]==2 && counter[i]==2){
            	twoPairOf[j] = true;
            	return true;
            }
        }
        for(int i=3, j=9; i<6; i++, j++){
        	if(counter[2]==2 && counter[i]==2){
            	twoPairOf[j] = true;
            	return true;
            }
        }
        for(int i=4, j=12; i<6; i++, j++){
        	if(counter[3]==2 && counter[i]==2){
            	twoPairOf[j] = true;
            	return true;
            }
        }
        if(counter[4]==2 && counter[5]==2){
        	twoPairOf[14] = true;
        	return true;
        }
        else
        	return false;
        
    }
    
    /**
	 * This method calculates the point value of the lowest pair of the Yatzy-point category "two pair".
	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
	 * @return An integer representing the point value of the lowest pair of a "two pair".
	 * @see The converter method.
	 */
    //checks the first possible pair, when also there is two pair
    public static int twoPairOf1(int[] counter){
    	for(int i=0; i<5; i++){
    		if(twoPairOf[i]==true)
        		return 1;
    	}
    	for(int i=5; i<9; i++){
    		if(twoPairOf[i]==true)
        		return 2;
    	}
    	for(int i=9; i<12; i++){
    		if(twoPairOf[i]==true)
        		return 3;
    	}
    	for(int i=12; i<14; i++){
    		if(twoPairOf[i]==true)
        		return 4;
    	}
    	if(twoPairOf[14]==true)
			return 5;
    	
    	else 
    		return 0;
    }
    
    /**
	 * This method calculates the point value of the highest pair of the Yatzy-point category "two pair".
	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
	 * @return An integer representing the point value of the highest pair of a "two pair".
	 * @see The converter method.
	 */
    //checks the second possible pair, when also there is two pair
    public static int twoPairOf2(int[] counter){
    	for(int i=0, j=2; i<5; i++, j++){
    		if(twoPairOf[i]==true)
        		return j;
    	}
    	for(int i=5, j=3; i<9; i++, j++){
    		if(twoPairOf[i]==true)
    			return j;
    	}
    	for(int i=9, j=4; i<12; i++, j++){
    		if(twoPairOf[i]==true)
    			return j;
    	}
    	for(int i=12, j=5; i<14; i++, j++){
    		if(twoPairOf[i]==true)
    			return j;
    	}
    	if(twoPairOf[14]==true)
    		return 6;
    	
    	else 
    		return 0;
    }
    
    /**
	 * This method checks if the Yatzy-point category "three of a kind" is within the outcome of a Yatzy dice throw.
	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
	 * @return A boolean, returning true if it's "three of a kind".
	 * @see The converter method.
	 */
    //checks three of a kind
    public static boolean threeOfAKind(int[] counter){
        if (counter[0]>=3 || counter[1]>=3 || counter[2]>=3 || counter[3]>=3 || counter[4]>=3 || counter[5]>=3)
            return true;
        else
            return false;
    }
    
    /**
	 * This method calculates the point value of the Yatzy-point category "three of a kind".
	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
	 * @return An integer representing the point value of "three of a kind".
	 * @see The converter method.
	 */
    //checks three of
    public static int threeOf(int[] counter){
        int threeOf = 0;
        if (threeOfAKind(counter)) {
        	for(int i=0, j=1; i<6; i++, j++){
        		if (counter[i]>=3)
                    threeOf = j;
			}
        }
        return threeOf;
    }
    
    /**
	 * This method checks if the Yatzy-point category "four of a kind" is within the outcome of a Yatzy dice throw.
	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
	 * @return A boolean, returning true if it's "four of a kind".
	 * @see The converter method.
	 */
    //checks four of a kind
    public static boolean fourOfAKind(int[] counter){
		if (counter[0]>=4 || counter[1]>=4 || counter[2]>=4 || counter[3]>=4 || counter[4]>=4 || counter[5]>=4)
			return true;
		else
			return false;
	}
    
    /**
	 * This method calculates the point value of the Yatzy-point category "four of a kind".
	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
	 * @return An integer representing the point value of "four of a kind".
	 * @see The converter method.
	 */
    //checks four of
	public static int fourOf(int[] counter){
		int fourOf = 0;
		if (fourOfAKind(counter)==true) {
			for(int i=0, j=1; i<6; i++, j++){
				if (counter[i]>=4)
					fourOf = j;
			}
		}
		return fourOf;
	}
	
	/**
	 * This method checks if the Yatzy-point category "yatzy" is within the outcome of a Yatzy dice throw.
	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
	 * @return A boolean, returning true if it's "yatzy".
	 * @see The converter method.
	 */
	//checks yatzy
	public static boolean yatzy(int[] counter){
        if (counter[0]==5 || counter[1]==5 || counter[2]==5 || counter[3]==5 || counter[4]==5 || counter[5]==5)
            return true;
        else
            return false;
    }
	
	/**
	 * This method checks if the Yatzy-point category "small straight" is within the outcome of a Yatzy dice throw.
	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
	 * @return A boolean, returning true if it's "small straight".
	 * @see The converter method.
	 */
	//checks small straight
	public static boolean smallStraight(int[] counter) {
        
        if (counter[0]==1 && counter[1]==1 && counter[2]==1 && counter[3]==1 && counter[4]==1)
            return true;
        else 
            return false;
    }
	
	/**
	 * This method checks if the Yatzy-point category "large straight" is within the outcome of a Yatzy dice throw.
	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
	 * @return A boolean, returning true if it's "large straight".
	 * @see The converter method.
	 */
	//checks large straight
	public static boolean largeStraight(int[] counter) {
        
        if (counter[1]==1 && counter[2]==1 && counter[3]==1 && counter[4]==1 && counter[5]==1)
            return true;
        else 
            return false;
    }
	
	/**
	 * This method checks if the Yatzy-point category "full house" is within the outcome of a Yatzy dice throw.
	 * @param counter is an integer array representing the outcome of a Yatzy dice throw.
	 * @return A boolean, returning true if it's "full house".
	 * @see The converter method.
	 */
	//checks full house
	public static boolean fullHouse(int[] counter){
		if(threeOfAKind(counter)==true && (counter[0]==2 || counter[1]==2 || counter[2]==2 || counter[3]==2 || counter[4]==2 || counter[5]==2))
			return true;
		else
			return false;
	}
}
