import java.util.ArrayList;
import java.util.List;

public class Round {
	
	private List<Integer> rolls = new ArrayList<Integer>();
	private Round nextRound;
	private int roundID;
	
	private final static int ALL_PINS = 10;

	public Round(int id){
		roundID = id; 
	}
	
	public void addRoll(int numberOfPins){
		rolls.add(numberOfPins);
	}
	
	public void setNextRound(Round nextRound){
		this.nextRound = nextRound;
	}
	
	private int getFirstRoll(){
		return rolls.get(0);
	}
	
	private int getSecondRoll(){
		return rolls.get(1);
	}
	
	public int getCurrentScore() {
		int score = sum();
		
		if(isSpare() && roundID < 10 && nextRound != null){
			score += nextRound.getFirstRoll();
		}
		if(isStrike() && roundID < 9 && nextRound != null){
			if(nextRound.isStrike() && nextRound.nextRound != null){
				score += nextRound.getFirstRoll() + nextRound.nextRound.getFirstRoll();
			}
			else{
				score += nextRound.sum();
			}
		}
		if(isStrike() && roundID == 9){
			score += nextRound.getFirstRoll() + nextRound.getFirstRoll();
		}
		return score;
	}
	
	private int sum(){
		int score = 0;
		for(int points : rolls){
			score += points;
		}
		return score;
	}
	
	private boolean isStrike(){
		return !rolls.isEmpty() && getFirstRoll() == ALL_PINS;
	}
	
	private boolean isSpare(){
		return rolls.size() > 1 && getFirstRoll() + getSecondRoll() == ALL_PINS; 	
	}
	
	private boolean isBonus(){
		return isStrike() || isSpare();
	}
	
	public boolean isFinished(){
		if(roundID < 10 && (isStrike() || rolls.size() == 2)){
			return true;				
		}
		if((rolls.size() == 2 && !isBonus()) || rolls.size() > 2){
			return true;
		}
		return false;
	}

}
