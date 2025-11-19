/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman_test extends ConsoleProgram {

	private static final int TOTAL_NUMBER_GUESS=8;
	
    public void run() {
		/* You fill this in */
    	println("Welcome To Hangman!");
    	part1=new HangmanLexicon();
    	playGame();
    }
    
    public void playGame()
    {
    	selectedWord= part1.getWord(selectRandomWordIndex());
    	hiddenGuess=getHideWord();
    	startMatch();
    }
    	
    	
    public void startMatch()
    {
    	while(true)
    	{
    		println("The word now looks like this : "+hiddenGuess);
    		println("You have "+guessRemaining+" guess remaining");
    		userLetter=getLetter();
    		println("Your Guess : "+ userLetter);
    		guessRemaining=addOccuranceToHiddenWord(guessRemaining);
    		
    		
    		if(selectedWord.equals(hiddenGuess))
    		{
    			println("You guessed the word "+hiddenGuess+"\n "+guessRemaining+" Number of Guess remaining!\n You Win!");
    			break;
    		}
    		if(guessRemaining<=0 )
    		{
    			println("There are no "+userLetter+"'s in the word.\nYou Completely Hung.\nThe Word was : "+selectedWord+"\n You Lose!");
    			break;
    		}
    		
    		//	Debugger
        	//	println(selectedWord);
    	}
    }
    
    
    	/**		ask user for a Letter	*/
    public char getLetter()
    {
    	char letter;
    	String userInput=readLine();
    	letter=userInput.charAt(0);
    	
    	if(Character.isLowerCase(letter))
    	{
    		letter=Character.toUpperCase(letter);
    	}
    	
    	return letter;
    }
    
    /**	Select a Word from a given word bundle 		*/
	public int selectRandomWordIndex()
	{
		return rgen.nextInt(0,part1.getWordCount()-1);
	}

	 /**		Replace a chosen/Selected word into a guess word by a Dash( - )		*/
    public String getHideWord()
    {
    	String hWord="";	//	=selectedWord;
    	for(int i=0; i<selectedWord.length();i++)
    	{
    			hWord+='-';		
    	}
    	return hWord;
    }
    
    /**		add occurances if matches		*/
    public int addOccuranceToHiddenWord(int guessCounter){
    	
    	boolean found=false;
    	for(int i=0;i<selectedWord.length();i++)
    	{
    		if (selectedWord.charAt(i) == userLetter && hiddenGuess.charAt(i) != userLetter) {
                // Replace  one letter
                hiddenGuess = hiddenGuess.substring(0, i) + userLetter + hiddenGuess.substring(i + 1);
                found=true;
                break; // Stop after replacing just one
            }
    		
    	}
    	if(!found )		//	check for guess remaining!
    	{
    		guessCounter--;
    		return guessCounter;
    	}
    	return guessCounter;
    }
    	
    //	Instance Variables...
   	private int guessRemaining=TOTAL_NUMBER_GUESS;
    private char userLetter;
    private String selectedWord;
    private String hiddenGuess;
    private HangmanLexicon part1;
    
    public RandomGenerator rgen= RandomGenerator.getInstance();
}

