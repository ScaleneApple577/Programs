
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.*;
import java.util.Scanner;
public class Wordle {
	static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
    	boolean gameWon = false;
    	boolean validWord = false;
        ArrayList<String> allWords = new ArrayList<String>();
        try {
            File myObj = new File("wordle.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                allWords.add(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        int x = (int) (Math.random() * allWords.size());
        String wordFind = allWords.get(x);
        String[] arr = new String[5];
        for (int i = 0; i < arr.length; i++) {
        	String temp = wordFind.substring(i,i +1);
        	arr[i] = temp;
        }
       WordleObject w1 = new WordleObject(arr);
       
       while (w1.gameOver() != true && gameWon == false) {
       validWord = false;
       System.out.println("Enter a word");
       String word = input.nextLine(); 
       if (word.length() != 5) {
    	   System.out.println("Invalid Word");
    	   continue;
       }
       for(int i = 0; i < allWords.size(); i++) {
    	   String temp = allWords.get(i);
    	   if (temp.equals(word)) {
    		   validWord = true;
    		   break;
    	   } 
       }
       if (validWord == false) {
    	   System.out.println("Invalid Word");
    	   continue;
       }
       w1.setAttempts();
       String[] array = new String[5];
       for (int i = 0; i < array.length; i++) {
       	String temp = word.substring(i,i +1);
       	array[i] = temp;
       }
       gameWon = w1.Match(array);
       
       }
       
       if (gameWon == false) {
    	   String[] wordArray = w1.getWord();
		   System.out.println("You lose, correct word: ");
    	   for(int a = 0; a < wordArray.length; a++) {
    		   System.out.print(wordArray[a]);
    	   }
       }
    }
}
