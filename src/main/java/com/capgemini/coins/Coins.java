package com.capgemini.coins;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldrygala on 2015-02-06.
 * <p/>
 * Consider N coins aligned in a row. Each coin is showing either heads or tails. The adjacency of these coins is the number of adjacent pairs of coins with the same side facing up.
 * <p/>
 * It must return the maximum possible adjacency that can be obtained by reversing exactly one coin (that is, one of the coins must be reversed). Consecutive elements of array A represent consecutive coins in the row. Array A contains only 0s and/or 1s: 0 represents a coin with heads facing up; 1 represents a coin with tails facing up. For example, given array A consisting of six numbers, such that:
 * <p/>
 * A[0] = 1
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 0
 * A[5] = 0
 * <p/>
 * the function should return 4. The initial adjacency is 2, as there are two pairs of adjacent coins with the same side facing up, namely (0, 1) and (4, 5). After reversing the coin represented by A[2], the adjacency equals 4, as there are four pairs of adjacent coins with the same side facing up, namely: (0, 1), (1, 2), (2, 3) and (4, 5), and it is not possible to obtain a higher adjacency. The same adjacency can be obtained by reversing the coin represented by A[3].
 */
public class Coins {

	public static int solution(List<Integer> coins) {

		int currentCoinsAdjecency = 0;
		int maxCoinsAdjecency = 0;

		if(coins.size() > 1){

			if(checkIfNoMoreThanOneDifferentCoinExists(coins)){
				maxCoinsAdjecency = maxAdjecencyForNoMoreThanOneDifferentCoins(coins);
			}
			else{
				maxCoinsAdjecency = maxAdjecencyForTwoOrMoreDifferentCoins(coins, currentCoinsAdjecency, maxCoinsAdjecency);
			}
		}

		return maxCoinsAdjecency;
	}

	private static boolean checkIfNoMoreThanOneDifferentCoinExists(List<Integer> coins) {
		return coins.indexOf(0) == coins.lastIndexOf(0) || coins.indexOf(1) == coins.lastIndexOf(1);
	}

	private static int maxAdjecencyForNoMoreThanOneDifferentCoins(List<Integer> coins) {
		int maxCoinsAdjecency = coins.size();

		if(checkIfAllCoinsAreEqual(coins)){
			maxCoinsAdjecency = maxAdjecencyForAllCoinsEqual(coins, maxCoinsAdjecency);
		}
		return maxCoinsAdjecency;
	}

	private static boolean checkIfAllCoinsAreEqual(List<Integer> coins) {
		return coins.contains(0) != coins.contains(1);
	}

	private static int maxAdjecencyForAllCoinsEqual(List<Integer> coins, int maxCoinsAdjecency) {
		if(coins.size() == 2){
			maxCoinsAdjecency = 0;
		}
		if(coins.size() > 2){
			maxCoinsAdjecency = coins.size() - 1;
		}
		return maxCoinsAdjecency;
	}

	private static int maxAdjecencyForTwoOrMoreDifferentCoins(List<Integer> coins, int currentCoinsAdjecency, int maxCoinsAdjecency) {
		int firstDifferenceIndex = 0;

		int currentCoinIndex = 0;
		int coinToCompare = coins.get(0);

		List<Integer> adjecentCoinsSublist = new ArrayList<Integer>();

		while(currentCoinIndex < coins.size()){
			int currentCoin = coins.get(currentCoinIndex);

			if(checkIfSecondCoinDifferenceOccurs(adjecentCoinsSublist, currentCoin, coinToCompare)){
				currentCoinsAdjecency = getCoinsSublistAdjecency(adjecentCoinsSublist);

				currentCoinIndex = firstDifferenceIndex;
				coinToCompare = coins.get(currentCoinIndex);
				adjecentCoinsSublist.clear();
			}
			else{
				adjecentCoinsSublist.add(currentCoin);
				
				if(currentCoin != coinToCompare){
					firstDifferenceIndex = currentCoinIndex;
				}
				
				currentCoinIndex++;
			}

			maxCoinsAdjecency = (currentCoinsAdjecency >= maxCoinsAdjecency) ? currentCoinsAdjecency : maxCoinsAdjecency;
		}
		return maxCoinsAdjecency;
	}

	private static boolean checkIfSecondCoinDifferenceOccurs(List<Integer> adjecentCoinsSublist, int currentCoin, int coinToCompare) {
		return currentCoin != coinToCompare && adjecentCoinsSublist.contains(currentCoin);
	}

	private static int getCoinsSublistAdjecency(List<Integer> coins) {
		return coins.size();
	}
}
