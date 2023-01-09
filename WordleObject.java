import java.util.*;
//this class is used to represent the word people are trying to solve.
public class WordleObject
{
    private String[] letters;  //size 5
    private ArrayList<String> alphabet;  //everytime a user guesses a letter, take out a letter
    private int attempts = 0;
    private int[] match = {0,0,0,0,0,0};
    private ArrayList<String> alreadyGuess;
    public WordleObject(String[] letters)
    {
        this.letters = letters;
        alphabet = new ArrayList<String>();
        alreadyGuess = new ArrayList<String>();
        String[] x = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w"
                , "x", "y", "z",};
        for (String temp : x)
            alphabet.add(temp);
    }
    
    	
    public boolean gameOver() {
    	this.attempts = attempts;
    	if (this.attempts > 6) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public String[] getWord() {
    	return letters;
    }
    
    public void setAttempts() {
    	this.attempts = attempts + 1;
    }
    
    public boolean Match(String[] arr) { 
		int count = 0;
		for (int a = 0; a < match.length; a++) {
			match[a] = 0;
		}
		
		for (int i = 0; i < arr.length; i++) {
    		if(arr[i].equals(letters[i])) {
    			match[i] = 1;
    		}
    	}
    	
    	for (int i = 0; i < arr.length; i++) {
    		for (int j = 0; j < arr.length; j++) {
    			if(arr[i].equals(letters[j])) {
    				if(match[j] == 1) {
    					continue;
    				}
    				match[i] = 2; 
    			}
    		}
    	}
    	
    	for (int i = 0; i < arr.length; i++) {
    		if (match[i] == 0) {
    			System.out.print(arr[i] + " (no match) ");
    		} else if (match[i] == 1) {
    			System.out.print(arr[i] + " (perfect match) ");
    		} else {
    			System.out.print(arr[i] + " (match) ");
    		}
    	}
    	
		System.out.println("");

    	for (int i = 0; i < alphabet.size(); i++) {
    		String temp = alphabet.get(i);
    		for (int j = 0; j < arr.length; j++) {
    			if (temp.equals(arr[j])) {
        			alphabet.remove(i);	
        			alreadyGuess.add(temp);
        			i--;
        			break;
    		}
    		}
    	}
    	for(int z = 0; z < match.length; z++) {
    		if (match[z] == 1) {
    			count++;
    		}
    	}
    	if(count == match.length - 1) {
    		System.out.println("You win");
    		return true;
    	} 
    	System.out.println("Letters available: " + alphabet);
    	System.out.println("Letters used " + alreadyGuess);
    	return false;
    }
 }
    
    
