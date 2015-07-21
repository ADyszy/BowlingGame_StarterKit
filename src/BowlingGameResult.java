import java.util.LinkedList;

public class BowlingGameResult implements BowlingGameResultCalculator {

	private LinkedList<Round> rounds = new LinkedList<Round>();
	
	@Override
	public void roll(int numberOfPins) {
		if(!isFinished()){
			if(rounds.isEmpty() || rounds.getLast().isFinished()){
				rounds.add(new Round(rounds.size() + 1));
				rounds.getLast().addRoll(numberOfPins);
				if(rounds.size() > 1){
					rounds.get(rounds.size() - 2).setNextRound(rounds.getLast());
				}
			}
			else{
				rounds.getLast().addRoll(numberOfPins);
			}			
		}
	}

	@Override
	public int score() {
		int score = 0;
		for (Round round : rounds) {
			score += round.getCurrentScore();
		}
		return score;
	}
	
	@Override
	public boolean isFinished() {
		return rounds.size() == 10 && rounds.getLast().isFinished();
	}
}