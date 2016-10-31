package blackjack;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int accumulated; 
	
	public Hand(){
		accumulated = 0; 
	}
	public ArrayList<Card> getCards(){return cards;}
	public void setCards(ArrayList<Card> helper) {cards = helper;}
	public int getAces(){
		int counter = 0; 
		for(int i = 0; i < cards.size(); i++){
			if(cards.get(i).getValue() == 11){counter++;}
		}
		return counter;
	}
	
	public void addToHand(Card card){
		if(card.getValue() == 1){
			if(accumulated + 11 <= 21) {card.setValue(11);}
		}
		accumulated += card.getValue();
		cards.add(card);
	}
	public int getAccumulated(){return accumulated;}
	public void setAccumulated(int n){accumulated = n;}
}
