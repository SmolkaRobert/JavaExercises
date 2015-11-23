package com.capgemini.coins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class CoinsTest {
	
	@Test
	public void shouldReturnZeroForEmptyList(){
		//given
		List<Integer> coinValues = new ArrayList<Integer>();
		
		//when
		int adjecentCoinsNumber = Coins.solution(coinValues);
		
		//then
		assertThat(adjecentCoinsNumber).isEqualTo(0);
	}
	
	@Test
	public void shouldReturnZeroForOneElementList(){
		//given
		List<Integer> coinValues = new ArrayList<Integer>();
		coinValues.add(1);
		
		//when
		int adjecentCoinsNumber = Coins.solution(coinValues);
		
		//then
		assertThat(adjecentCoinsNumber).isEqualTo(0);
	}
	
	@Test
	public void shouldReturnZeroForTwoEqualElements(){
		//given
		List<Integer> coinValuesZeroes = Arrays.asList(0, 0);
		List<Integer> coinValuesOnes = Arrays.asList(1, 1);
		
		//when
		int adjecentCoinsNumberZeroes = Coins.solution(coinValuesZeroes);
		int adjecentCoinsNumberOnes = Coins.solution(coinValuesOnes);
		
		//then
		assertThat(adjecentCoinsNumberZeroes).isEqualTo(0);
		assertThat(adjecentCoinsNumberOnes).isEqualTo(0);
	}
	
	@Test
	public void shouldReturnTwoForTwoDifferenElements(){
		//given
		List<Integer> coinValues0 = Arrays.asList(0, 1);
		List<Integer> coinValues1 = Arrays.asList(1, 0);
		
		//when
		int adjecentCoins0 = Coins.solution(coinValues0);
		int adjecentCoins1 = Coins.solution(coinValues1);
		
		//then
		assertThat(adjecentCoins0).isEqualTo(2);
		assertThat(adjecentCoins1).isEqualTo(2);
	}
	
	@Test
	public void shouldReturnSevenForEightOnes(){
		//given
		List<Integer> coinValues = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1);
		
		//when
		int adjecentCoinsNumberOnes = Coins.solution(coinValues);
		
		//then
		assertThat(adjecentCoinsNumberOnes).isEqualTo(7);
	}
	
	@Test
	public void shouldReturnElevenForTwelveZeroes(){
		//given
		List<Integer> coinValues = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
		//when
		int adjecentCoinsNumberOnes = Coins.solution(coinValues);
		
		//then
		assertThat(adjecentCoinsNumberOnes).isEqualTo(11);
	}
	
	@Test
	public void shouldReturnFourForThreeOnesOneZero(){
		//given
		List<Integer> coinValues = Arrays.asList(1, 1, 1, 0);
		
		//when
		int adjecentCoinsNumberOnes = Coins.solution(coinValues);
		
		//then
		assertThat(adjecentCoinsNumberOnes).isEqualTo(4);
	}
	
	@Test
	public void shouldReturnThreeForAlteringZeroesAndOnes(){
		//given
		List<Integer> coinValues0 = Arrays.asList(0, 1, 0, 1, 0, 1, 0);
		List<Integer> coinValues1 = Arrays.asList(1, 0, 1, 0, 1, 0, 1);
		
		//when
		int adjecentCoinsNumber0 = Coins.solution(coinValues0);
		int adjecentCoinsNumber1 = Coins.solution(coinValues1);
		
		//then
		assertThat(adjecentCoinsNumber0).isEqualTo(3);
		assertThat(adjecentCoinsNumber1).isEqualTo(3);
	}
	
	@Test
	public void shouldReturnFourForGivenCoinList(){
		//given
		List<Integer> coinValues = Arrays.asList(1, 1, 0, 1, 0, 0, 0);
		
		//when
		int adjecentCoinsNumberOnes = Coins.solution(coinValues);
		
		//then
		assertThat(adjecentCoinsNumberOnes).isEqualTo(4);
	}
	
	@Test
	public void shouldReturnSevenForOne0Five1sAnd010(){
		//given
		List<Integer> coinValues = Arrays.asList(0, 1, 1, 1, 1, 1, 0, 1, 0);
		
		//when
		int adjecentCoinsNumberOnes = Coins.solution(coinValues);
		
		//then
		assertThat(adjecentCoinsNumberOnes).isEqualTo(7);
	}
	
	@Test
	public void shouldReturnFiveForOne1Four0sAndTwo1s(){
		//given
		List<Integer> coinValues = Arrays.asList(1, 0, 0, 0, 0, 1, 1);
		
		//when
		int adjecentCoinsNumberOnes = Coins.solution(coinValues);
		
		//then
		assertThat(adjecentCoinsNumberOnes).isEqualTo(5);
	}
}

