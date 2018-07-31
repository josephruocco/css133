
import java.util.*;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		// have the computer choose a value
		
		
		 int user_losses = 0;
		 int user_wins = 0;
		 int user_ties = 0;
	
		while(true) { 
	    	
			 Scanner scn = new Scanner(System.in);
			  // ask for number
			 System.out.print("Would you like to play? Please type 'yes' or 'no'");
			 //   
			 String start_game = scn.nextLine(); 
	 
		if(start_game.equals("yes")) {
			
	 
			double random_throw = (Math.random() * 3) + 1;
	
			int computer_choice = (int) random_throw;
		
			//store the computer's choice
		
			String comp_throw = "";
		
			// computer choice is Rock
			if (computer_choice == 1) {
			 comp_throw = "Rock";
			}
			// computer choice is Paper
			if (computer_choice == 2) {
			 comp_throw = "Paper";
			}
			// computer choice is Scissors
			if (computer_choice == 3) {
			 comp_throw = "Scissors";
			}	
			//Declare a new scanner object
			Scanner scn1 = new Scanner(System.in);
			// ask for number
			System.out.print("What is your throw? Dial 1 for Rock, Dial 2 for Paper, Dial 3 for Scissors");
			//   
			int user_throw = scn1.nextInt(); 
		 
			// user wins
			if (user_throw > computer_choice) {
			 System.out.println("Computer threw " + comp_throw + " User Wins");
			  user_wins++;
			}
			// computer wins 
			else if (user_throw < computer_choice)  {
			 System.out.println("Computer threw " + comp_throw + " Computer Wins");
			user_losses++;
			}
			// rock beats scissors  and user wins
			else if (user_throw == 1 && computer_choice == 3 ) {
			 System.out.println("Computer threw " + comp_throw + " User Wins");
			 user_wins++;
			}
			// user loses
			else if (user_throw == 3 && computer_choice == 1 ) {
			 System.out.println("Computer threw " + comp_throw + " Computer Wins");
			 user_losses++;
			}
			// tie
			else {
			 System.out.println("Computer threw " + comp_throw + " Tie");
			 user_ties++;
			}
		}
		else {
			break;
		}
		
	    }
	
		System.out.println("Thanks for playing!  User wins: " + user_wins + " User Losses: " + user_losses + " User ties: " + user_ties);
	}

}
