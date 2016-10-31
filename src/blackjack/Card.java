package blackjack;

public class Card {
	private int value; 
	private boolean state; 
	public Card(){
		value = 0; 
		state = false;
	}
	public Card(int v, boolean b){
		value = v;
		state = b;
	}
	public int getValue() {return value;}
	public boolean getState() {return state;}
	public void setValue(int n) {value = n;}
	public void setState(boolean b) {state = b;}
}
