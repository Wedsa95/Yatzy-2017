package com.jensen.model;

import javax.swing.JOptionPane;



public class Correction {
	
	//converter
	static int[] counter = new int[6];
    static int counter1 = 0;
    static int counter2 = 0;
    static int counter3 = 0;
    static int counter4 = 0;
    static int counter5 = 0;
    static int counter6 = 0;
    
    //check
  	static String html1 = "<HTML>";
  	static String html2 = "</HTML>";
  	static String result = "";
  	
    //one to six
    static int ones;
	static int twos;
	static int threes;
	static int fours;
	static int fives;
	static int sixes;
	
	//twoPair
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
	
    //converting to counter
    public static void main (String[] args) {
    
		//fem slumpmässiga tärningsslag
		
		
		//fem förutbestämda tärningsslag
		int[] diceResult = {5, 5, 5, 6, 6};
		
		//System.out.print(a + " " + b + " " + c + " " + d + " " + e + "\n" + "\n");
		//System.out.print(Check.check(diceResult));
		
		//inställd för att visa det förutbestämda tärningsslaget
		JOptionPane.showMessageDialog(null, check(diceResult));
    }
    public static int[] converter(int[] diceResult){
        
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
    }
    
  //checking a result of five dices and returns a string with all the possible alternatives
  	public static String check(int[] diceResult){

  		int[] counter = converter(diceResult);
  		
  		//summing all the ones
  		if(counter[0]>=1)
  			result = result + ("Ettor i poäng: " + one(counter) + "<br/>");
  		
  		//summing all the twos
  		if(counter[1]>=1)
  			result = result + ("Tvåor i poäng: " + two(counter) + "<br/>");
  		
  		//summing all the threes
  		if(counter[2]>=1)
  			result = result + ("Treor i poäng: " + three(counter) + "<br/>");
  		
  		//summing all the fours
  		if(counter[3]>=1)
  			result = result + ("Fyror i poäng: " + four(counter) + "<br/>");
  		
  		//summing all the fives
  		if(counter[4]>=1)
  			result = result + ("Femmor i poäng: " + five(counter) + "<br/>");
  		
  		//summing all the sixes
  		if(counter[5]>=1)
  			result = result + ("Sexor i poäng: " + six(counter) + "<br/>");
  		
  		//checking if pair
  				if(pair(counter)){
  					if(threeOfAKind(counter) && fullHouse(counter)==false){
  						if(fourOfAKind(counter)){
  							if(yatzy(counter))
  								result = result + ("Par i: " + threeOf(counter) + "<br/>");
  							else
  								result = result + ("Par i: " + threeOf(counter) + "<br/>");
  						}
  						else
  							result = result + ("Par i: " + threeOf(counter) + "<br/>");
  					}
  					else if(twoPair(counter)==false)
  						result = result + ("Par i: " + pairOf(counter) + "<br/>");

  					if(twoPair(counter)){
  						if (fullHouse(counter))
  							result = result + (("Par i: " + threeOf(counter) + " eller " + pairOfHouse(counter)) + "<br/>");
  						else if(twoPair(counter))
  							result = result + (("Par i: " + twoPairOf1(counter) + " eller " + twoPairOf2(counter)) + "<br/>");
  						else
  							result = result + ("Par i: " + pairOf(counter) + "<br/>");
  					}
  				}

  		//checking if three of a kind
  		if(threeOfAKind(counter))
  			result = result + ("Triss i: " + threeOf(counter)) + "<br/>";

  		//checking if four of a kind
  		if(fourOfAKind(counter))
  			result = result + ("Fyrtal i: " + fourOf(counter)) + "<br/>";

  		//checking if two pair
  		if(twoPair(counter)){
  			if(twoPair(counter) && fullHouse(counter))
  				result = result + ("Två par i: " + threeOf(counter) + " och " + pairOfHouse(counter)) + "<br/>";
  			else
  				result = result + ("Två par i: " + twoPairOf1(counter) + " och " + twoPairOf2(counter)) + "<br/>";
  		}

  		//checking if full house
  		if(fullHouse(counter))
  			result = result + ("Kåk i: " + threeOf(counter) + " och " + pairOfHouse(counter)) + "<br/>";

  		//checking if small straight
  		if(smallStraight(counter))
  			result = result + ("Liten stege") + "<br/>";

  		//checking if large straight
  		if(largeStraight(counter))
  			result = result + ("Stor stege") + "<br/>";

  		//checking if yatzy
  		if(yatzy(counter))
  			result = result + ("Yatzy") + "<br/>";

  		result = result + ("Chans: " + chance(counter)) + "<br/>";

  		return html1 + result + html2;
  	}
  	
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
}
