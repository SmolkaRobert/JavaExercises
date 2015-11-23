package com.capgemini.placeToSplit;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
 * Example:
 * {{{
 * canBalance({1, 1, 1, 2, 1}) → true
 * canBalance({2, 1, 1, 2, 1}) → false
 * canBalance({10, 10}) → true
 * }}}
 */
public final class PlaceToSplit {
	private PlaceToSplit() {
	}

	public static boolean canBalance(int[] nums) {

		boolean possibleToSplit = false;

		ArrayList<Integer> numsList = convertIntArrayToArrayList(nums);
		int numsLength = numsList.size();

		if(numsLength > 1){
			int splitIndex = getStartingSplitIndex(numsLength);

			int leftSum = sumOfListInteger(numsList.subList(0, splitIndex));
			int rightSum = sumOfListInteger(numsList.subList(splitIndex, numsLength));
			
			possibleToSplit = checkIfSumsAreEqual(leftSum, rightSum);

			if(leftSum > rightSum){
				possibleToSplit = searchLeftForPlaceToSplit(numsList, splitIndex);
			}

			if(leftSum < rightSum){
				possibleToSplit = searchRightForPlaceToSplit(numsList, splitIndex);
			}
		}

		return possibleToSplit;
	}

	private static int getStartingSplitIndex(int numsLength) {
		return (numsLength/2) + (numsLength%2);
	}

	private static ArrayList<Integer> convertIntArrayToArrayList(int[] nums) {
		ArrayList<Integer> numsList = new ArrayList<Integer>();
		for(int number : nums){
			numsList.add(number);
		}
		return numsList;
	}
	
	private static int sumOfListInteger(List<Integer> numbersList) {
		int sum = 0;
		for(Integer number : numbersList){
			sum += number;
		}
		return sum;
	}
	
	private static boolean checkIfSumsAreEqual(int leftSum, int rightSum) {
		return leftSum == rightSum;
	}

	private static boolean searchRightForPlaceToSplit(ArrayList<Integer> numsList, int splitIndex) {

		int numsLength = numsList.size();
		int leftSum;
		int rightSum;

		do{
			leftSum = sumOfListInteger(numsList.subList(0, splitIndex));
			rightSum = sumOfListInteger(numsList.subList(splitIndex, numsLength));

			splitIndex++;
		}while(splitIndex < numsLength  && leftSum < rightSum);
		
		return checkIfSumsAreEqual(leftSum, rightSum);
	}

	private static boolean searchLeftForPlaceToSplit(ArrayList<Integer> numsList, int splitIndex) {
		
		int numsLength = numsList.size();
		int leftSum;
		int rightSum;

		do{
			leftSum = sumOfListInteger(numsList.subList(0, splitIndex));
			rightSum = sumOfListInteger(numsList.subList(splitIndex, numsLength));

			splitIndex--;
		}while(splitIndex > 0 && leftSum > rightSum);
		
		return checkIfSumsAreEqual(leftSum, rightSum);
	}
}
