/* Hangman2.java
 * Author: Alyssa Lagimoniere
 * Submission Date: 3/6/15
 * 
 * Purpose:
 * 
 * Statement of Academic Honesty: 
 * 
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with 
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia. 
 */

import java.util.Scanner;
public class Hangman2 {
	
	private static final boolean testingMode = true;
	public static void main(String[] args) {
	
		//Define variables
		int gameNumber;
		int guesses = 0;
		int spaces = 0;
		int i = 0;
		int wordLength;
		int integer;
		char cGuess;
		char sGuess = 0;
		String difficulty;
		String secretWord;
		String word;
		String charGuess;
		String spaceGuess;
		
		
		//Define scanner
		Scanner keyboard = new Scanner(System.in);
		
		for (gameNumber = 0; gameNumber <= 25; gameNumber++) {
			
			//Set difficulty
			System.out.println("Enter your difficulty: Easy (e), Intermediate (i), or Hard (h) \n");
			difficulty = keyboard.next();
			difficulty = difficulty.substring(0,1);
			
			if (difficulty.equalsIgnoreCase("e")) {
				guesses = 15;
				spaces = 7;
			} else if (difficulty.equalsIgnoreCase("i")) {
				guesses = 12;
				spaces = 5;
			} else if (difficulty.equalsIgnoreCase("h")) {
				guesses = 10;
				spaces = 3;
			} else {
				System.out.println("");
				System.out.println("Invalid difficulty. Try again...\n");
				continue;
			}
			
			//Get word
			secretWord = RandomWord.newWord();
			word = secretWord;
			wordLength = word.length();
			System.out.println("");
			System.out.println("The secret word is: " + word + "\n");
		
			//Display dashes
			System.out.print("The word is: ");
			for (i = 0; i < wordLength; i++) {
				System.out.print("- ");
			}
			System.out.println("\n");
			
			//Play game
			while (guesses > 0) {
				
				//Ask for guess
				System.out.print("Please enter the letter you want to guess: ");
				charGuess = keyboard.next();
				System.out.println("");
				cGuess = charGuess.charAt(0);
				
				//Ask for spaces
				System.out.println("Please enter the spaces you want to check (separated by spaces): \n");
				spaceGuess = keyboard.nextLine();
				String indices = keyboard.nextLine();
				System.out.println("");
								
				//Check guess and length of input
				if (Character.isLetter(cGuess) && (indices.length() == spaces)) {
				} else {
					System.out.println("Your input is invalid. Try again. \n");
				}
				
				for (i = 0; i < indices.length(); i++) {
					sGuess = indices.charAt(i);	
					if ((sGuess < indices.length()) || ((i % 2 == 0) && (Character.isDigit(sGuess))) || ((i % 2 != 0) && (Character.isWhitespace(sGuess)))) {
						continue;
					} else {
					}
					System.out.println("Your input is invalid. Try again. \n");
				}
				
							
				//Check spaces for guess
				for (i = 0; i < wordLength; i++) {
					sGuess = indices.charAt(i);	
					System.out.println(sGuess);
					if (cGuess == word.charAt(0)) {
						System.out.println("Your guess is in the word!");
						System.out.println("The updated word is: ");
					} else {
						System.out.println("Your guess is not in the word. Try again.");
						guesses--;
					}
				}
				
				System.out.println("Guesses remaining: " + guesses + "\n");
				
			}
			
			
			
		}	
		
	}

}