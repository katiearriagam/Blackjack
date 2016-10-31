package blackjack;

import java.util.Scanner;

public class Main {

	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
	Game game = new Game();
	game.initializeScore(); 

	System.out.println("Let's play Blackjack!");
	System.out.println("Would you like to play?"); 
	String choice = scan.nextLine();
	System.out.println("Current score: " + game.getScore().getScoreValue() + ".");
	while(choice.toUpperCase().charAt(0) == 'Y'){
		game.newGame();
		System.out.println("Current score: " + game.getScore().getScoreValue() + ".");
		System.out.println("Would you like to play again? (Y/N)");
		choice = scan.nextLine();
	}

	System.out.println("Your final score was -> " + game.getScore().getScoreValue() + ".");
	}
}
