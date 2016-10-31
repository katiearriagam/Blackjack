package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>(52);
	public Deck(){
		for(int i = 1; i < 11; i++){
			for(int j = 0; j < 4; j++){
				cards.add(new Card(i, false));
			}
		}
		for(int i = 0; i < 12; i++){
			cards.add(new Card(10, false));
		}
	}
	
	public void shuffle(){
		Collections.shuffle(cards);
	}
	
	public ArrayList<Card> getNcards(int n){
		ArrayList<Card> helper = new ArrayList<Card>();
		for(int i = 0; i < n; i++){
			helper.add(cards.get(i));
			cards.remove(i);
		}
		return helper;
	}
	
	
}
