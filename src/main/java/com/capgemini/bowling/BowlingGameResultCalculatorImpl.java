package com.capgemini.bowling;

import java.util.LinkedList;

public class BowlingGameResultCalculatorImpl implements BowlingGameResultCalculator {

	private static final int MAX_ROUNDS_NUMBER = 10;
	private LinkedList<BowlingRound> bowlerRounds = new LinkedList<BowlingRound>();

	public void roll(int numberOfPins) {
		if(newRoundIsNeeded()){
			addNewRound();
		}

		bowlerRounds.getLast().addRollToRound(numberOfPins);
	}

	public int score() {
		int gameScore = 0;
		
		for(BowlingRound singleRound : bowlerRounds){
			gameScore += singleRound.getRoundScore();
		}
		return gameScore;
	}
	
	public boolean isFinished() {
		BowlingRound currentRound = bowlerRounds.getLast();
		return currentRound.checkIfLastRound() && currentRound.roundIsFinished();
	}
	
	private boolean newRoundIsNeeded() {
		return isStart() || bowlerRounds.getLast().roundIsFinished();
	}

	private void addNewRound() {
		BowlingRound nextRound = new BowlingRound();
		
		if(!isStart()){
			bowlerRounds.getLast().setNextRound(nextRound);;
		}
		
		bowlerRounds.add(nextRound);

		if(MAX_ROUNDS_NUMBER == bowlerRounds.size()){
			bowlerRounds.getLast().setLastRound(true);
		}
	}

	private boolean isStart() {
		return bowlerRounds.isEmpty();
	}

}
