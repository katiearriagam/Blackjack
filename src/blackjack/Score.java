package blackjack;

public class Score {
	int playerScore;
	public Score(){playerScore = 0;}
	public int getScoreValue() {return playerScore;}
	public void setScoreValue(int n){playerScore = n;}
	public void addOneToScore(){playerScore++;}
	public void substractOneToScore(){playerScore--;}
	
}
