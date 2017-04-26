package com.jensen.controller;

import com.jensen.model.Model;

public class Correction {
	
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
	
	/*
    static boolean twoPairOf1 = false;
    static boolean twoPairOf2 = false;
    static boolean twoPairOf3 = false;
    static boolean twoPairOf4 = false;
    static boolean twoPairOf5 = false;
    static boolean twoPairOf6 = false;
    static boolean twoPairOf7 = false;
    static boolean twoPairOf8 = false;
    static boolean twoPairOf9 = false;
    static boolean twoPairOf10 = false;
    static boolean twoPairOf11 = false;
    static boolean twoPairOf12 = false;
    static boolean twoPairOf13 = false;
    static boolean twoPairOf14 = false;
    static boolean twoPairOf15 = false;
    */
	
    public Correction(Model model) {
    	this.model = model;

    }

	//converting to counter
    public static int[] converter(int[] diceResult){
    	
    	counter1 = 0;
    	counter2 = 0;
    	counter3 = 0;
    	counter4 = 0;
    	counter5 = 0;
    	counter6 = 0;
    	//Sergej om han håller på igen 
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
	    //*
	    return counter;
    	
        /*
        switch (diceResult[0]){
        case 1: counter1 = counter1 + 1;
                counter[0] = counter1;
            break;
        case 2: counter2 = counter2 + 1;
                counter[1] = counter2;
            break;
        case 3: counter3 = counter3 + 1;
                counter[2] = counter3;
            break;
        case 4: counter4 = counter4 + 1;
                counter[3] = counter4;
            break;
        case 5: counter5 = counter5 + 1;
                counter[4] = counter5;
            break;
        case 6: counter6 = counter6 + 1;
                counter[5] = counter6;
            break;
        }
        switch (diceResult[1]){
        case 1: counter1 = counter1 + 1;
                counter[0] = counter1;
            break;
        case 2: counter2 = counter2 + 1;
                counter[1] = counter2;
            break;
        case 3: counter3 = counter3 + 1;
                counter[2] = counter3;
            break;
        case 4: counter4 = counter4 + 1;
                counter[3] = counter4;
            break;
        case 5: counter5 = counter5 + 1;
                counter[4] = counter5;
            break;
        case 6: counter6 = counter6 + 1;
                counter[5] = counter6;
            break;
        }
        switch (diceResult[2]){
        case 1: counter1 = counter1 + 1;
                counter[0] = counter1;
            break;
        case 2: counter2 = counter2 + 1;
                counter[1] = counter2;
            break;
        case 3: counter3 = counter3 + 1;
                counter[2] = counter3;
            break;
        case 4: counter4 = counter4 + 1;
                counter[3] = counter4;
            break;
        case 5: counter5 = counter5 + 1;
                counter[4] = counter5;
            break;
        case 6: counter6 = counter6 + 1;
                counter[5] = counter6;
            break;
        }
        switch (diceResult[3]){
        case 1: counter1 = counter1 + 1;
                counter[0] = counter1;
            break;
        case 2: counter2 = counter2 + 1;
                counter[1] = counter2;
            break;
        case 3: counter3 = counter3 + 1;
                counter[2] = counter3;
            break;
        case 4: counter4 = counter4 + 1;
                counter[3] = counter4;
            break;
        case 5: counter5 = counter5 + 1;
                counter[4] = counter5;
            break;
        case 6: counter6 = counter6 + 1;
                counter[5] = counter6;
            break;
        }
        switch (diceResult[4]){
        case 1: counter1 = counter1 + 1;
                counter[0] = counter1;
            break;
        case 2: counter2 = counter2 + 1;
                counter[1] = counter2;
            break;
        case 3: counter3 = counter3 + 1;
                counter[2] = counter3;
            break;
        case 4: counter4 = counter4 + 1;
                counter[3] = counter4;
            break;
        case 5: counter5 = counter5 + 1;
                counter[4] = counter5;
            break;
        case 6: counter6 = counter6 + 1;
                counter[5] = counter6;
            break;
        }
        
        return counter;
        */
    }
    
  //checking a result of five dices and returns a string with all the possible alternatives
  	public static void check(int[] diceResult){
  		
  		int[] counter = converter(diceResult);
  		
  		//reseting the underlying scoreboard to zero if not placement has been done
  		for(int i=0; i<18; i++){
			for(int j=0; j<6; j++){
				if(!model.placedOrNot[i][j]){
					model.setScore(-1, i, j);
				}
			}
		}
  		
  		//summing all the ones
  		if(counter[0]>=1)
  			if(!model.placedOrNot[1][model.getTurn()]){
  				model.setScore(one(counter), 1, model.getTurn());
  			}
  		
  		//summing all the twos
  		if(counter[1]>=1)
  			if(!model.placedOrNot[2][model.getTurn()]){
  				model.setScore(two(counter), 2, model.getTurn());
  			}
  		
  		//summing all the threes
  		if(counter[2]>=1)
  			if(!model.placedOrNot[3][model.getTurn()]){
  				model.setScore(three(counter), 3, model.getTurn());
  			}
  		
  		//summing all the fours
  		if(counter[3]>=1)
  			if(!model.placedOrNot[4][model.getTurn()]){
  				model.setScore(four(counter), 4, model.getTurn());
  			}
  		
  		//summing all the fives
  		if(counter[4]>=1)
  			if(!model.placedOrNot[5][model.getTurn()]){
  				model.setScore(five(counter), 5, model.getTurn());
  			}
  		
  		//summing all the sixes
  		if(counter[5]>=1)
  			if(!model.placedOrNot[6][model.getTurn()]){
  				model.setScore(six(counter), 6, model.getTurn());
  			}
  		
  		//Summa
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
  								if(!model.placedOrNot[9][model.getTurn()]){
  									model.setScore(threeOf(counter)*2, 9, model.getTurn());
  	  					  		}
  							}
  							else{
  								if(!model.placedOrNot[9][model.getTurn()]){
  									model.setScore(threeOf(counter)*2, 9, model.getTurn());
  	  					  		}
  							}
  						}
  						else{
  							if(!model.placedOrNot[9][model.getTurn()]){
  								model.setScore(threeOf(counter)*2, 9, model.getTurn());
  					  		}
  						}
  					}
  					else if(twoPair(counter)==false){
  						if(!model.placedOrNot[9][model.getTurn()]){
  							model.setScore(pairOf(counter)*2, 9, model.getTurn());
				  		}
  					}

  					else if(twoPair(counter)){ //ändrade till "else if", ist för bara "if"
  						if (fullHouse(counter)){
  							if(threeOf(counter) < pairOfHouse(counter)){
  									if(!model.placedOrNot[9][model.getTurn()]){
  										model.setScore(pairOfHouse(counter)*2, 9, model.getTurn());
  									}
								}
								else{
									if(!model.placedOrNot[9][model.getTurn()]){
										model.setScore(threeOf(counter)*2, 9, model.getTurn());
									}
								}
  						}
  						else if(twoPair(counter)){
  							if(!model.placedOrNot[9][model.getTurn()]){
  								if(twoPairOf1(counter) < twoPairOf2(counter)){
  									if(!model.placedOrNot[9][model.getTurn()]){
  										model.setScore(twoPairOf2(counter)*2, 9, model.getTurn());
  									}
  								}
  								else{
  									if(!model.placedOrNot[9][model.getTurn()]){
  										model.setScore(twoPairOf1(counter)*2, 9, model.getTurn());
  									}
  								}
  				  			}
  						}
  						else{
  							if(!model.placedOrNot[9][model.getTurn()]){
  								model.setScore(pairOf(counter)*2, 9, model.getTurn());
  				  			}
  						}
  					}
  				}
  		
  		//checking if two pair
  		if(twoPair(counter)){
  			if(twoPair(counter) && fullHouse(counter)){
  				if(!model.placedOrNot[10][model.getTurn()]){
  					model.setScore(threeOf(counter)*2 + pairOfHouse(counter)*2, 10, model.getTurn());
  		  		}
  		  	}
  		  	else{
  		  		if(!model.placedOrNot[10][model.getTurn()]){
  		  			model.setScore(twoPairOf1(counter)*2 + twoPairOf2(counter)*2, 10, model.getTurn());
  		  	  	}
  		  	}
  		}

  		//checking if three of a kind
  		if(threeOfAKind(counter)){
  			if(!model.placedOrNot[11][model.getTurn()]){
  				model.setScore(threeOf(counter)*3, 11, model.getTurn());
  			}
  		}

  		//checking if four of a kind
  		if(fourOfAKind(counter)){
  			if(!model.placedOrNot[12][model.getTurn()]){
  				model.setScore(fourOf(counter)*4, 12, model.getTurn());
  			}
  		}

  		//checking if small straight
  		if(smallStraight(counter)){
  			if(!model.placedOrNot[13][model.getTurn()]){
  				model.setScore(15, 13, model.getTurn());
  			}
  		}

  		//checking if large straight
  		if(largeStraight(counter)){
  			if(!model.placedOrNot[14][model.getTurn()]){
  				model.setScore(20, 14, model.getTurn());
  			}
  		}
  		
  		//checking if full house
  		if(fullHouse(counter)){
  			if(!model.placedOrNot[15][model.getTurn()]){
  				model.setScore(threeOf(counter)*3 + pairOfHouse(counter)*2, 15, model.getTurn());
  			}
  		}
  		
  		//calculate chance
  		if(!model.placedOrNot[16][model.getTurn()]){
  			model.setScore(chance(counter), 16, model.getTurn());
		}

  		//checking if yatzy
  		if(yatzy(counter)){
  			if(!model.placedOrNot[17][model.getTurn()]){
  				model.setScore(50, 17, model.getTurn());
  			}
  		}
  		
  		//Total
  		model.totalSum();
  		
  		//printing the underlyging scoreboard in the console
  		/*
  		for(int i=1; i<19; i++){
  			System.out.println("\n");
  			switch(i){
	  			case 1: System.out.print("Ettor \t");
	  					break;
	  			case 2: System.out.print("Tvåor \t");
	  					break;
	  			case 3: System.out.print("Treor \t");
	  					break;
	  			case 4: System.out.print("Fyror \t");
						break;
	  			case 5: System.out.print("Femmor \t");
						break;
	  			case 6: System.out.print("Sexor \t");
						break;
	  			case 7: System.out.print("Summa \t");
						break;
	  			case 8: System.out.print("Bonus \t");
						break;
	  			case 9: System.out.print("Par \t");
						break;
	  			case 10: System.out.print("Tvåpar \t");
						break;
	  			case 11: System.out.print("Tretal \t");
						break;
	  			case 12: System.out.print("Fyrtal \t");
						break;
	  			case 13: System.out.print("Liten \t");
						break;
	  			case 14: System.out.print("Stor \t");
	  					break;
	  			case 15: System.out.print("Kåk \t");
	  					break;
	  			case 16: System.out.print("Chans \t");
	  					break;
	  			case 17: System.out.print("Yatzy \t");
	  					break;
	  			case 18: System.out.print("Totalt \t");
	  					break;
  			}
  			for(int j=0; j<6; j++){
  				System.out.print("|" + /*model.placedOrNot[i]* / [j]model.underlyingScoreboard[i][j]);
  			}
  		}
  		*/
  		
  		//reseting the counter to zero. Very important! IS NEEDED FOR IT TO FUNCTION CORRECTLY
  		for(int i=0; i<6; i++)
  			counter[i] = 0;
  		
  		for(int i=0; i<15; i++){
  			twoPairOf[i] = false;
  		}
  	}
  	
//all the logic behind the correction of each and single possible combination you can get in a yatzy game
  	
  	//checks chance
	public static int chance(int[] counter){
		return (counter[0]*1 + counter[1]*2 + counter[2]*3 + counter[3]*4 + counter[4]*5 + counter[5]*6); 
	}
	
	//returns the sum of all ones (int)
	public static int one(int[] counter){
		for(int i=0; i<6; i++){
			if(counter[0] == i){
				ones = 1*i;
			}
		}
		return ones;
	}
	
	//returns the sum of all twos (int)
	public static int two(int[] counter){
		for(int i=0; i<6; i++){
			if(counter[1] == i){
				twos = 2*i;
			}
		}
		return twos;
	}
	
	//returns the sum of all threes (int)
	public static int three(int[] counter){
		for(int i=0; i<6; i++){
			if(counter[2] == i){
				threes = 3*i;
			}
		}
		return threes;
	}
	
	//returns the sum of all fours (int)
	public static int four(int[] counter){
		for(int i=0; i<6; i++){
			if(counter[3] == i){
				fours = 4*i;
			}
		}
		return fours;
	}
	
	//returns the sum of all fives (int)
	public static int five(int[] counter){
		for(int i=0; i<6; i++){
			if(counter[4] == i){
				fives = 5*i;
			}
		}
		return fives;
	}
	
	//returns the sum of all sixes (int)
	public static int six(int[] counter){
		for(int i=0; i<6; i++){
			if(counter[5] == i){
				sixes = 6*i;
			}
		}
		return sixes;
	}
	
	//checks pair
	public static boolean pair(int[] counter){
        if (counter[0]>=2 || counter[1]>=2 || counter[2]>=2 || counter[3]>=2 || counter[4]>=2 || counter[5]>=2)
            return true;
        else
            return false;
    }
	
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
    
    //checks pair of, when also there is full house
    public static int pairOfHouse(int[] counter){
    	int pairOf = 0;
    	if (pair(counter)==true) {
    		for(int i=0, j=1; i<6; i++, j++){
    			if (counter[i]==2)
                    pairOf = j;
            }
        }
    	return pairOf;
    }
    
    //checks two pair
    public static boolean twoPair(int[] counter){
        
        if(fullHouse(counter)==true){
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
    
    //checks three of a kind
    public static boolean threeOfAKind(int[] counter){
        if (counter[0]>=3 || counter[1]>=3 || counter[2]>=3 || counter[3]>=3 || counter[4]>=3 || counter[5]>=3)
            return true;
        else
            return false;
    }
    
    //checks three of
    public static int threeOf(int[] counter){
        int threeOf = 0;
        if (threeOfAKind(counter)==true) {
        	for(int i=0, j=1; i<6; i++, j++){
        		if (counter[i]>=3)
                    threeOf = j;
			}
        }
        return threeOf;
    }
    
    //checks four of a kind
    public static boolean fourOfAKind(int[] counter){
		if (counter[0]>=4 || counter[1]>=4 || counter[2]>=4 || counter[3]>=4 || counter[4]>=4 || counter[5]>=4)
			return true;
		else
			return false;
	}
    
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
	
	//checks yatzy
	public static boolean yatzy(int[] counter){
        if (counter[0]==5 || counter[1]==5 || counter[2]==5 || counter[3]==5 || counter[4]==5 || counter[5]==5)
            return true;
        else
            return false;
    }
	
	//checks small straight
	public static boolean smallStraight(int[] counter) {
        
        if (counter[0]==1 && counter[1]==1 && counter[2]==1 && counter[3]==1 && counter[4]==1)
            return true;
        else 
            return false;
    }
	
	//checks large straight
	public static boolean largeStraight(int[] counter) {
        
        if (counter[1]==1 && counter[2]==1 && counter[3]==1 && counter[4]==1 && counter[5]==1)
            return true;
        else 
            return false;
    }
	
	//checks full house
	public static boolean fullHouse(int[] counter){
		if(threeOfAKind(counter)==true && (counter[0]==2 || counter[1]==2 || counter[2]==2 || counter[3]==2 || counter[4]==2 || counter[5]==2))
			return true;
		else
			return false;
	}
}


/*
//all the logic behind the correction of each and single possible combination you can get in a yatzy game
  	
  	//checks chance
	public static int chance(int[] counter){
		return (counter[0]*1 + counter[1]*2 + counter[2]*3 + counter[3]*4 + counter[4]*5 + counter[5]*6); 
	}
	
	//returns the sum of all ones (int)
	public static int one(int[] counter){
		
		switch (counter[0]){
		case 0: ones = 0; 
		break;
		case 1: ones = 1*1;
		break;
		case 2: ones = 1*2;
		break;
		case 3: ones = 1*3;
		break;
		case 4: ones = 1*4;
		break;
		case 5: ones = 1*5;
		break;
		}
		return ones;
	}
	
	//returns the sum of all twos (int)
	public static int two(int[] counter){
		switch (counter[1]){
		case 0: twos = 0; 
		break;
		case 1: twos = 2*1;
		break;
		case 2: twos = 2*2;
		break;
		case 3: twos = 2*3;
		break;
		case 4: twos = 2*4;
		break;
		case 5: twos = 2*5;
		break;
		}
		return twos;
	}
	
	//returns the sum of all threes (int)
	public static int three(int[] counter){
		switch (counter[2]){
		case 0: threes = 0; 
		break;
		case 1: threes = 3*1;
		break;
		case 2: threes = 3*2;
		break;
		case 3: threes = 3*3;
		break;
		case 4: threes = 3*4;
		break;
		case 5: threes = 3*5;
		break;
		}
		return threes;
	}
	
	//returns the sum of all fours (int)
	public static int four(int[] counter){
		switch (counter[3]){
		case 0: fours = 0; 
		break;
		case 1: fours = 4*1;
		break;
		case 2: fours = 4*2;
		break;
		case 3: fours = 4*3;
		break;
		case 4: fours = 4*4;
		break;
		case 5: fours = 4*5;
		break;
		}
		return fours;
	}
	
	//returns the sum of all fives (int)
	public static int five(int[] counter){
		switch (counter[4]){
		case 0: fives = 0; 
		break;
		case 1: fives = 5*1;
		break;
		case 2: fives = 5*2;
		break;
		case 3: fives = 5*3;
		break;
		case 4: fives = 5*4;
		break;
		case 5: fives = 5*5;
		break;
		}
		return fives;
	}
	
	//returns the sum of all sixes (int)
	public static int six(int[] counter){
		switch (counter[5]){
		case 0: sixes = 0; 
		break;
		case 1: sixes = 6*1;
		break;
		case 2: sixes = 6*2;
		break;
		case 3: sixes = 6*3;
		break;
		case 4: sixes = 6*4;
		break;
		case 5: sixes = 6*5;
		break;
		}
		return sixes;
	}
	
	//checks pair
	public static boolean pair(int[] counter){
        if (counter[0]>=2 || counter[1]>=2 || counter[2]>=2 || counter[3]>=2 || counter[4]>=2 || counter[5]>=2)
            return true;
        else
            return false;
    }
	
	//checks pair of
    public static int pairOf(int[] counter){
    	int pairOf = 0;
    	if (pair(counter)==true) {
            if (counter[0]>=2)
                pairOf = 1;
            if (counter[1]>=2)
                pairOf = 2;
            if (counter[2]>=2)
                pairOf = 3;
            if (counter[3]>=2)
                pairOf = 4;
            if (counter[4]>=2)
                pairOf = 5;
            if (counter[5]>=2)
                pairOf = 6;
        }
    	return pairOf;
    }
    
    //checks pair of, when also there is full house
    public static int pairOfHouse(int[] counter){
    	int pairOf = 0;
    	if (pair(counter)==true) {
            if (counter[0]==2)
                pairOf = 1;
            if (counter[1]==2)
                pairOf = 2;
            if (counter[2]==2)
                pairOf = 3;
            if (counter[3]==2)
                pairOf = 4;
            if (counter[4]==2)
                pairOf = 5;
            if (counter[5]==2)
                pairOf = 6;
        }
    	return pairOf;
    }
    
    //checks two pair
    public static boolean twoPair(int[] counter){
        
        if(fullHouse(counter)==true){
        	return true;
    	}	
        if(counter[0]==2 && counter[1]==2){
        	twoPairOf1 = true;
        	return true;
        }
        if(counter[0]==2 && counter[2]==2){
        	twoPairOf2 = true;
        	return true;
    	}
        if(counter[0]==2 && counter[3]==2){
        	twoPairOf3 = true;
        	return true;
    	}
        if(counter[0]==2 && counter[4]==2){
        	twoPairOf4 = true;
        	return true;
        }
        if(counter[0]==2 && counter[5]==2){
        	twoPairOf5 = true;
        	return true;
        }
        
        if(counter[1]==2 && counter[2]==2){
        	twoPairOf6 = true;
        	return true;
        }
        if(counter[1]==2 && counter[3]==2){
        	twoPairOf7 = true;
        	return true;
        }
        if(counter[1]==2 && counter[4]==2){
        	twoPairOf8 = true;
        	return true;
        }
        if(counter[1]==2 && counter[5]==2){
        	twoPairOf9 = true;
        	return true;
        }
        
        if(counter[2]==2 && counter[3]==2){
        	twoPairOf10 = true;
        	return true;
        }
        if(counter[2]==2 && counter[4]==2){
        	twoPairOf11 = true;
        	return true;
        }
        if(counter[2]==2 && counter[5]==2){
        	twoPairOf12 = true;
        	return true;
        }
        
        if(counter[3]==2 && counter[4]==2){
        	twoPairOf13 = true;
        	return true;
        }
        if(counter[3]==2 && counter[5]==2){
        	twoPairOf14 = true;
        	return true;
        }
        
        if(counter[4]==2 && counter[5]==2){
        	twoPairOf15 = true;
        	return true;
        }
        else
        	return false;
        
    }
    
    //checks the first possible pair, when also there is two pair
    public static int twoPairOf1(int[] counter){
    	if(twoPairOf1==true)
    		return 1;
    	if(twoPairOf2==true)
    		return 1;
    	if(twoPairOf3==true)
    		return 1;
    	if(twoPairOf4==true)
    		return 1;
    	if(twoPairOf5==true)
    		return 1;
    	
    	if(twoPairOf6==true)
    		return 2;
    	if(twoPairOf7==true)
    		return 2;
    	if(twoPairOf8==true)
    		return 2;
    	if(twoPairOf9==true)
    		return 2;
    	
    	if(twoPairOf10==true)
    		return 3;
    	if(twoPairOf11==true)
    		return 3;
    	if(twoPairOf12==true)
    		return 3;
    	
    	if(twoPairOf13==true)
    		return 4;
    	if(twoPairOf14==true)
    		return 4;
    	
    	if(twoPairOf15==true)
    		return 5;
    	else 
    		return 0;
    }
    
  //checks the second possible pair, when also there is two pair
    public static int twoPairOf2(int[] counter){
    	if(twoPairOf1==true)
    		return 2;
    	if(twoPairOf2==true)
    		return 3;
    	if(twoPairOf3==true)
    		return 4;
    	if(twoPairOf4==true)
    		return 5;
    	if(twoPairOf5==true)
    		return 6;
    	
    	if(twoPairOf6==true)
    		return 3;
    	if(twoPairOf7==true)
    		return 4;
    	if(twoPairOf8==true)
    		return 5;
    	if(twoPairOf9==true)
    		return 6;
    	
    	if(twoPairOf10==true)
    		return 4;
    	if(twoPairOf11==true)
    		return 5;
    	if(twoPairOf12==true)
    		return 6;
    	
    	if(twoPairOf13==true)
    		return 5;
    	if(twoPairOf14==true)
    		return 6;
    	
    	if(twoPairOf15==true)
    		return 6;
    	else 
    		return 0;
    }
    
    //checks three of a kind
    public static boolean threeOfAKind(int[] counter){
        if (counter[0]>=3 || counter[1]>=3 || counter[2]>=3 || counter[3]>=3 || counter[4]>=3 || counter[5]>=3)
            return true;
        else
            return false;
    }
    
    //checks three of
    public static int threeOf(int[] counter){
        int threeOf = 0;
        if (threeOfAKind(counter)==true) {
            if (counter[0]>=3)
                threeOf = 1;
            if (counter[1]>=3)
                threeOf = 2;
            if (counter[2]>=3)
                threeOf = 3;
            if (counter[3]>=3)
                threeOf = 4;
            if (counter[4]>=3)
                threeOf = 5;
            if (counter[5]>=3)
                threeOf = 6;
        }
        return threeOf;
    }
    
    //checks four of a kind
    public static boolean fourOfAKind(int[] counter){
		if (counter[0]>=4 || counter[1]>=4 || counter[2]>=4 || counter[3]>=4 || counter[4]>=4 || counter[5]>=4)
			return true;
		else
			return false;
	}
    
    //checks four of
	public static int fourOf(int[] counter){
		int fourOf = 0;
		if (fourOfAKind(counter)==true) {
			if (counter[0]>=4)
				fourOf = 1;
			if (counter[1]>=4)
				fourOf = 2;
			if (counter[2]>=4)
				fourOf = 3;
			if (counter[3]>=4)
				fourOf = 4;
			if (counter[4]>=4)
				fourOf = 5;
			if (counter[5]>=4)
				fourOf = 6;
		}
		return fourOf;
	}
	
	//checks yatzy
	public static boolean yatzy(int[] counter){
        if (counter[0]==5 || counter[1]==5 || counter[2]==5 || counter[3]==5 || counter[4]==5 || counter[5]==5)
            return true;
        else
            return false;
    }
	
	//checks small straight
	public static boolean smallStraight(int[] counter) {
        
        if (counter[0]==1 && counter[1]==1 && counter[2]==1 && counter[3]==1 && counter[4]==1)
            return true;
        else 
            return false;
    }
	
	//checks large straight
	public static boolean largeStraight(int[] counter) {
        
        if (counter[1]==1 && counter[2]==1 && counter[3]==1 && counter[4]==1 && counter[5]==1)
            return true;
        else 
            return false;
    }
	
	//checks full house
	public static boolean fullHouse(int[] counter){
		if(threeOfAKind(counter)==true && (counter[0]==2 || counter[1]==2 || counter[2]==2 || counter[3]==2 || counter[4]==2 || counter[5]==2))
			return true;
		else
			return false;
	}
 
*/