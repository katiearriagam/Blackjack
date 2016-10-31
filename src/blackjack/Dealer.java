package blackjack;

public class Dealer {
	Hand dealerHand;
	
	public Dealer(){
		dealerHand = new Hand();
	}

	public Hand getHand(){return dealerHand;}
	public void setHand(Hand helper){dealerHand = helper;}
	public void receiveCard(Card card){dealerHand.addToHand(card);}
}
