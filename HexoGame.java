import java.util.Scanner;

/**
 * The HexoGame class runs the HEXO game.
 * 
 * @author Chris Lindgren
 * @version 1.0
 */

public class HexoGame
{
    public static final int MAX_HEX_LENGTH = 5;
    public static final int END_TURN = 16;
    
    /**
     * The runHexo method uses the scanner to take user input and provide proper output for game feedback.
     */
    public void runHexo()
    {
        int turn = 0;
        int hexMatch = 0;
        int hexMatch1 = 0;
        int hexMatch2 = 0;
        int hexPosition = 0;
        int points = 0;
        int firstGuess = 100000;
        String guess = "";
        Scanner scan = new Scanner(System.in);
        char secretChr = ' ';
        char guessChr = ' ';
        char non = ' ';
        char dup1 = ' ';
        char dup2 = ' ';
        char dup3 = ' ';
        char dup4 = ' ';
        
        //generates random hexnumber for the game
        HexGen hexNumber = new HexGen();
        String secretHex = hexNumber.create().toUpperCase();
        System.out.println(secretHex);
        
        //Welcome message and initial prompt
        System.out.println("\nWelcome to the game of Hexo." + 
                           "\nThe computer will generate a random hexadecimal number." + 
                           "\nEach of the five places will be unique." + 
                           "\nThe object of the game is to guess the number within 16 tries.");
        
        for(turn = 1; turn != END_TURN + 1; turn++)
        {
            System.out.print("\n\nPlease make a guess: ");
            guess = scan.nextLine().toUpperCase();
            
            //exception handling for guesses longer than MAX_HEX_LENGTH and truncates to that length
            for(int j = guess.length(); guess.length() > MAX_HEX_LENGTH; j++)
            {
                guess = guess.substring(0, guess.length() - 1);
                
                if(guess.length() == MAX_HEX_LENGTH)
                {
                    System.out.print("\nThe number has only five places. \nThe first five characters of your guess will be used." + 
                                            "\n\nYour guess is now: " + guess + "\n");
                }
            }
            
            //resets the hexPosition instance variable for a new turn
            hexPosition = 0;
            //detects non hexadecimal letters & calculates how many characters are in the correct position.
            for(int m = 0; m <= guess.length() - 1; m++)
            {
                //detects non-hexadecimal letters
                non = guess.charAt(m);
            
                if(!Character.isDigit(non) && !("ABCDEF").contains(non + ""))         
                {
                    switch(m)
                    {
                        case 0:
                            System.out.println("\nHex numbers have the digits 0 - 9 and the letters A - F," 
                                                    + "\nthe character " + non + " in your guess will never match.");
                            dup1 = non;
                            break;                         
                             
                        case 1: 
                            if(non != dup1)
                            {
                                System.out.println("\nHex numbers have the digits 0 - 9 and the letters A - F," + 
                                                    "\nthe character " + non + " in your guess will never match.");
                                dup2 = non;
                            }
                            break;                      
                              
                        case 2:
                            if(non != dup1 && non != dup2)
                            {
                                System.out.println("\nHex numbers have the digits 0 - 9 and the letters A - F," +
                                                    "\nthe character " + non + " in your guess will never match.");
                                dup3 = non;
                            }
                            break; 
                               
                        case 3 :
                            if(non != dup1 && non != dup2 && non != dup3)
                            {
                                System.out.println("\nHex numbers have the digits 0 - 9 and the letters A - F," +
                                                    "\nthe character " + non + " in your guess will never match.");
                                dup4 = non;   
                            }   
                            break;  
                             
                        case 4 :
                            if(non != dup1 && non != dup2 && non != dup3 && non != dup4)
                            {
                                System.out.println("\nHex numbers have the digits 0 - 9 and the letters A - F," +
                                                    "\nthe character " + non + " in your guess will never match.");                                           
                            }           
                    }    
                }
                
                //calculates hexPosition
                char secPosition = secretHex.charAt(m);
                char gusPosition = guess.charAt(m);
                
                if(secPosition == gusPosition)
                {
                    hexPosition++;                                                                
                }
            }
            
            //replaces guess with less than 5 chars with an "X"
            for(int k = guess.length(); k < MAX_HEX_LENGTH; k++)
            { 
                guess += "X";
                
                if(k == MAX_HEX_LENGTH - 1)
                {
                    System.out.print("\nHex numbers have the digits 0 - 9 and the letters A - F," + 
                                            "\nthe character X in your guess will never match.\n");
                }
            }
            
            //resets the hexMatch instance variables for a new turn
            hexMatch = 0;
            hexMatch1 = 0;
            hexMatch2 = 0;
            //calculates hexMatch
            for(int n = 0; n <= secretHex.length() - 1; n++)
            {    
                 char secMatch = secretHex.charAt(n);
                 
                 for(int o = 0; o <= guess.length() - 1; o++)
                 {
                     char gusMatch = guess.charAt(o);
                     
                     //conditional that checks the initial char value at 0
                     if(secMatch == gusMatch && o == 0)
                     {
                        hexMatch1++;
                     }
                     
                     //conditional that checks any non-duplicate char values after the initial char value 0
                     if(secMatch == gusMatch && o > 0)
                        {
                            char dup = guess.charAt(o - 1);
                            
                            if(gusMatch != dup)
                            {
                                hexMatch2++;
                            }
                        }
                     
                     hexMatch = hexMatch1 + hexMatch2;
                 }
            }  
            
            //end of guess output messages
            if(guess.equals(secretHex))
            {
                if(turn == 1)
                {
                    System.out.print("\n" + guess + ", is the number.");
                    System.out.print("\nDude, you frackin' guessed it in " + turn + " try!");
                    System.out.print("\nHell yeah!!! You have acquired " + firstGuess + " points!!!");
                }
                else if(turn > 1)
                {
                    System.out.print("\n" + guess + ", is the number.");
                    System.out.print("\nYou guessed it in " + turn + " tries!");
                    System.out.print("\nWoo Hoo!!! You have acquired " + (points = END_TURN - turn) + " points!!!");
                }
                
                //ends game
                System.exit(0);
            }
            else if(guess != secretHex)
            {
                System.out.print("\n" + guess + ", guess number " + turn + ".");
                System.out.print("\nhas " + hexMatch + " matching characters");
                System.out.print("\nwith " + hexPosition + " in the correct position.");
            }
            else if(turn == END_TURN) //need to figure this condition out, wants boolean not int
            {
                System.out.print("\n" + guess + ", is the number.");
                System.out.print("\nYou took " + turn + " turns and didn't guess it.");
                System.out.println("\nNo points for you this time.");
            }
        }
        
        //end of game message
        System.out.print("\n\n" + secretHex + " is the number." + "\nYou took 16 turns and didn't guess it." +
                                         "\nNo points for you this time.");
               
        //ends game
        System.exit(0);
    }
}