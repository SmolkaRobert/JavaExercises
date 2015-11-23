package com.capgemini.bowling;

import java.util.LinkedList;


class BowlingRound {
	private static final int MAX_THROWS_NUMBER = 2;
	private static final int MAX_THROWS_NUMBER_WITH_BONUS = 3;
	private static final int MAX_PINS_NUMBER = 10;

	private LinkedList<Integer> throwsInRound = new LinkedList<Integer>();
	private BowlingRound nextRound;
	private boolean lastRound = false;
	private int roundScore = 0;
	
	void setLastRound(boolean isLastRound) {
		this.lastRound = isLastRound;
	}

	void setNextRound(BowlingRound nextRound) {
		this.nextRound = nextRound;
	}
	
	boolean roundIsFinished() {
		return (!lastRound && isStrike()) || maxThrowsForRoundReached();
	}
	
	boolean checkIfLastRound() {
		return lastRound;
	}
	
	void addRollToRound(int numberOfPins) {
		throwsInRound.add(numberOfPins);
	}

	int getRoundScore() {

		if(!lastRound && isStrike()){
			roundScore += MAX_PINS_NUMBER + nextRound.getBonusStrikeScore();
		}
		else{
			roundScore += getStandardScore();
		}

		return roundScore;
	}

	private int getBonusStrikeScore() {
		int bonusStrikeScore = getPinsSumForRound();
		
		if(!lastRound && isStrike()){
			bonusStrikeScore += nextRound.throwsInRound.getFirst();
		}
		
		if(isLastRoundWithBonus()){
			//get only two throws from last round if last round has a bonus throw
			bonusStrikeScore -= this.throwsInRound.getLast();
		}
		
		return bonusStrikeScore;
	}
	
	private int getStandardScore() {
		int standardScore = getPinsSumForRound();
		
		if(!lastRound && isSpare()){
			standardScore += nextRound.getBonusSparePoints();
		}
		
		return standardScore;
	}
	
	private int getBonusSparePoints() {
		return throwsInRound.getFirst();
	}

	private int getPinsSumForRound() {
		int roundPinsSum = 0;
		
		for(int singleThrow : throwsInRound){
			roundPinsSum += singleThrow;
		}
		
		return roundPinsSum;
	}

	private boolean maxThrowsForRoundReached() {
		int maxThrowsForRound = MAX_THROWS_NUMBER;

		if(isLastRoundWithBonus()){
			maxThrowsForRound = MAX_THROWS_NUMBER_WITH_BONUS;
		}
		return maxThrowsForRound == throwsInRound.size();
	}

	private boolean isLastRoundWithBonus() {
		boolean isBonusRound = false;
		if(lastRound && (isStrike() || isSpare())){
			isBonusRound = true;
		}
		return isBonusRound;
	}

	private boolean isSpare() {
		return (!isStrike() && MAX_PINS_NUMBER <= getPinsSumForRound());
	}

	private boolean isStrike() {
		return MAX_PINS_NUMBER == throwsInRound.getFirst();
	}
}