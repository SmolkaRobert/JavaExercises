package com.capgemini.placeToSplit;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class PlaceToSplitTest {
	
	@Test
	public void shouldReturnFalseForArrayOfOneElement(){
		//given
		int[] numbers = {4}; 
		
		//when
		boolean possibleToSplit = PlaceToSplit.canBalance(numbers);
		
		//then
		assertThat(possibleToSplit).isEqualTo(false);
	}
	
	@Test
	public void shouldReturnFalseForArrayOfTwoDifferentElements(){
		//given
		int[] numbers = {4, 6}; 
		
		//when
		boolean possibleToSplit = PlaceToSplit.canBalance(numbers);
		
		//then
		assertThat(possibleToSplit).isEqualTo(false);
	}
	
	@Test
	public void shouldReturnTrueForArrayOfTwoEqualElements(){
		//given
		int[] numbers = {7, 7}; 
		
		//when
		boolean possibleToSplit = PlaceToSplit.canBalance(numbers);
		
		//then
		assertThat(possibleToSplit).isEqualTo(true);
	}
	
	@Test
	public void shouldReturnTrueForArraySplitableInTheMiddle(){
		//given
		int[] numbers = {1, 1, 1, 2, 1}; 
		
		//when
		boolean possibleToSplit = PlaceToSplit.canBalance(numbers);
		
		//then
		assertThat(possibleToSplit).isEqualTo(true);
	}
	
	@Test
	public void shouldReturnTrueForArraySplitableMovingRight(){
		//given
		int[] numbers = {1, 1, 1, 1, 1, 2, 7}; 
		
		//when
		boolean possibleToSplit = PlaceToSplit.canBalance(numbers);
		
		//then
		assertThat(possibleToSplit).isEqualTo(true);
	}
	
	@Test
	public void shouldReturnTrueForArraySplitableMovingLeft(){
		//given
		int[] numbers = {12, 1, 1, 1, 5, 2, 4}; 
		
		//when
		boolean possibleToSplit = PlaceToSplit.canBalance(numbers);
		
		//then
		assertThat(possibleToSplit).isEqualTo(true);
	}
	
	@Test
	public void shouldReturnFalseForArrayNotSplitableMovingRight(){
		//given
		int[] numbers = {2, 1, 1, 1, 1, 1, 1, 1, 8}; 
		
		//when
		boolean possibleToSplit = PlaceToSplit.canBalance(numbers);
		
		//then
		assertThat(possibleToSplit).isEqualTo(false);
	}
	
	@Test
	public void shouldReturnFalseForArrayNotSplitableMovingLeft(){
		//given
		int[] numbers = {2, 1, 1, 2, 1}; 
		
		//when
		boolean possibleToSplit = PlaceToSplit.canBalance(numbers);
		
		//then
		assertThat(possibleToSplit).isEqualTo(false);
	}
}
