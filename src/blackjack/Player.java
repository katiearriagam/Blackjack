package blackjack;

public class Player {
		Hand playerHand;
	
		public Player(){
			playerHand = new Hand();
		}
	
		public Hand getHand(){return playerHand;}
		public void setHand(Hand helper){playerHand = helper;}
		public void receiveCard(Card card){playerHand.addToHand(card);}
}
