package blackjack;
import java.util.Scanner;

public class Game {
	private Player player;
	private Dealer dealer;
	private Score score;
	private Deck deck;
	
	public Game(){
		score = new Score();
	}
	public void initializeScore(){score.setScoreValue(0);}
	public Player getPlayer(){return player;}
	public Score getScore(){return score;}
	public Dealer getDealer(){return dealer;}
	public Deck getDeck(){return deck;}
	public void setPlayer(Player p){player = p;}
	public void setScore(Score s){score = s;}
	public void setDealer(Dealer d){dealer = d;}
	public void setDeck(Deck d){deck = d;}
	
	public void newGame(){
		Scanner scanner = new Scanner(System.in);
		player = new Player();
		dealer = new Dealer();
		deck = new Deck();
		deck.shuffle();
		for(int i = 0; i < 2; i++){
			Card helper = new Card();
			helper = deck.getNcards(1).get(0);
			helper.setState(true);
			player.receiveCard(helper);
		}
		Card helper = new Card();
		helper = deck.getNcards(1).get(0);
		helper.setState(true);
		player.receiveCard(helper);
		helper = new Card();
		helper = deck.getNcards(1).get(0);
		dealer.receiveCard(helper);
		String option = "a";
		// player turn
		System.out.println("PLAYER'S TURN");
		System.out.println("Player's accumulated hand -> " + player.playerHand.getAccumulated());
		while(player.getHand().getAccumulated() < 21 && option == "a"){
			System.out.println("Pick an option: ");
			System.out.println("a. Hit");
			System.out.println("b. Stand");
			System.out.println("c. Exit game");
			option = scanner.nextLine();
			switch(option){
			case "a":
				System.out.println("Player chose Hit.");
				helper = deck.getNcards(1).get(0);
				helper.setState(true);
				player.receiveCard(helper);
				break;
			case "b":
				System.out.println("Player chose Stand.");
				System.out.println("Player's accumulated hand -> " + player.playerHand.getAccumulated());
				break;
			case "c":
				score.substractOneToScore();
				System.out.println("Player chose Exit game.");
				System.out.println("Player's new score ->" + score.getScoreValue());
				return;
			}
		}
		if(player.getHand().getAccumulated() > 21){
			System.out.println("Player lost.");
			System.out.println("Player's accumulated hand -> " + player.playerHand.getAccumulated());
			score.substractOneToScore();
			System.out.println("Player's new score ->" + score.getScoreValue());
			return;
		}
		
		if(player.getHand().getAccumulated() == 21){
			System.out.println("Player won.");
			System.out.println("Player's accumulated hand -> " + player.playerHand.getAccumulated());
			score.addOneToScore();
			System.out.println("Player's new score ->" + score.getScoreValue());
			return;
			
		}
		
		// dealer's turn
		while(dealer.getHand().getAccumulated() < 17){
			System.out.println("Dealer will hit.");
			helper = deck.getNcards(1).get(0);
			helper.setState(true);
			dealer.receiveCard(helper);
			
			System.out.println("The dealer picked a " + helper.getValue() + " and has now a total of " + dealer.getHand().getAccumulated() + ".");
			
			if (dealer.getHand().getAccumulated() > 21) {
				if (dealer.getHand().getAces() > 0) {
					System.out.print("The dealer will turn one of his aces into 1. ");
					dealer.getHand().setAccumulated(dealer.getHand().getAccumulated() - 10);
					System.out.println("Dealer's total: " + dealer.getHand().getAccumulated() + ".");
				} 
				else {
					System.out.println("The dealer busted");
					System.out.println("You have won");
					score.addOneToScore();
					return;
				}
			}
		}
		
		System.out.println("The dealer will now stand.");
		
		// end of turns
		// print final scores
		System.out.println("The player accumulated -> " + player.getHand().getAccumulated() + ".");
		System.out.println("The dealer accumulated -> " + dealer.getHand().getAccumulated() + ".");
		
		// check for winner
		if (player.getHand().getAccumulated() > dealer.getHand().getAccumulated()) {
			System.out.println("Player won.");
			score.addOneToScore();
		} 
		else if (player.getHand().getAccumulated() < dealer.getHand().getAccumulated()) {
			System.out.println("Player lost.");
			score.substractOneToScore();
		} 
		else {
			System.out.println("It's a tie. The dealer wins.");
			score.substractOneToScore();
		}
		
	}
}
