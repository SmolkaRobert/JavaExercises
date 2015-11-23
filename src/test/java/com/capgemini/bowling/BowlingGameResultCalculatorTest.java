package com.capgemini.bowling;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class BowlingGameResultCalculatorTest {

	@Test
	public void shouldReturn6WhenThrown4And2Pins() {
		//given
		BowlingGameResultCalculator calculator = new BowlingGameResultCalculatorImpl();
		calculator.roll(4);
		calculator.roll(2);
		//when
		Integer result = calculator.score();
		//then
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void shouldReturn22WhenThrownSpareThen5And2Pins() {
		//given
		BowlingGameResultCalculator calculator = new BowlingGameResultCalculatorImpl();
		calculator.roll(9);
		calculator.roll(1);

		calculator.roll(5);
		calculator.roll(2);
		//when
		Integer result = calculator.score();
		//then	
		assertThat(result).isEqualTo(22);
	}

	@Test
	public void shouldReturn26WhenThrownStrikeThen7And1Pins() {
		//given
		BowlingGameResultCalculator calculator = new BowlingGameResultCalculatorImpl();
		calculator.roll(10);

		calculator.roll(7);
		calculator.roll(1);
		//when
		Integer result = calculator.score();
		//then	
		assertThat(result).isEqualTo(26);
	}

	@Test
	public void shouldReturn83WhenThrownThreeTimesStrikeThen7And1Pins() {
		//given
		BowlingGameResultCalculator calculator = new BowlingGameResultCalculatorImpl();
		calculator.roll(10);

		calculator.roll(10);

		calculator.roll(10);

		calculator.roll(7);
		calculator.roll(1);
		//when
		Integer result = calculator.score();
		//then	
		assertThat(result).isEqualTo(83);
	}

	@Test
	public void shouldReturn76WhenGameFinishedWithStrikeBonus() {
		//given
		BowlingGameResultCalculator calculator = new BowlingGameResultCalculatorImpl();
		calculator.roll(0);
		calculator.roll(0);
		
		calculator.roll(5);
		calculator.roll(4);
		
		calculator.roll(6);
		calculator.roll(2);
		
		calculator.roll(0);
		calculator.roll(4);
		
		calculator.roll(8);
		calculator.roll(1);
		
		calculator.roll(5);
		calculator.roll(0);
		
		calculator.roll(3);
		calculator.roll(4);
		
		calculator.roll(7);
		calculator.roll(0);
		
		calculator.roll(4);
		calculator.roll(4);
		
		calculator.roll(10);
		calculator.roll(8);
		calculator.roll(1);
		
		//when
		Integer result = calculator.score();
		//then	
		assertThat(result).isEqualTo(76);
	}

	@Test
	public void shouldReturn300WhenThrown12Strikes() {
		//given
		BowlingGameResultCalculator calculator = new BowlingGameResultCalculatorImpl();
		
		int numberOfStrikes = 12;
		for(int i=0; i<numberOfStrikes ; i++){
			calculator.roll(10);
		}
		
		//when
		Integer result = calculator.score();
		//then	
		assertThat(result).isEqualTo(300);
	}
	
	
	
	
	@Test
	public void shouldReturnFalseWhenNotInLastRound() {
		//given
		BowlingGameResultCalculator calculator = new BowlingGameResultCalculatorImpl();
		calculator.roll(10);

		calculator.roll(5);
		calculator.roll(4);
		//when
		boolean result = calculator.isFinished();
		//then	
		assertThat(result).isEqualTo(false);
	}

	@Test
	public void shouldReturnFalseWhenNotDoneWithLastRound() {
		//given
		BowlingGameResultCalculator calculator = new BowlingGameResultCalculatorImpl();
		calculator.roll(10);

		calculator.roll(5);
		calculator.roll(4);

		calculator.roll(6);
		calculator.roll(2);

		calculator.roll(0);
		calculator.roll(4);

		calculator.roll(8);
		calculator.roll(1);

		calculator.roll(0);
		calculator.roll(0);

		calculator.roll(10);

		calculator.roll(10);

		calculator.roll(4);
		calculator.roll(4);

		calculator.roll(7);

		//when
		boolean result = calculator.isFinished();
		//then	
		assertThat(result).isEqualTo(false);
	}

	@Test
	public void shouldReturnFalseWhenThereIsStillBonusThrowInLastRound() {
		//given
		BowlingGameResultCalculator calculator = new BowlingGameResultCalculatorImpl();
		calculator.roll(10);

		calculator.roll(5);
		calculator.roll(4);

		calculator.roll(6);
		calculator.roll(2);

		calculator.roll(0);
		calculator.roll(4);

		calculator.roll(8);
		calculator.roll(1);

		calculator.roll(0);
		calculator.roll(0);

		calculator.roll(10);

		calculator.roll(10);

		calculator.roll(4);
		calculator.roll(4);

		calculator.roll(10);
		calculator.roll(8);

		//when
		boolean result = calculator.isFinished();
		//then	
		assertThat(result).isEqualTo(false);
	}

	@Test
	public void shouldReturnTrueWhenGameFinishedBonusExcluded() {
		//given
		BowlingGameResultCalculator calculator = new BowlingGameResultCalculatorImpl();
		calculator.roll(10);

		calculator.roll(5);
		calculator.roll(4);

		calculator.roll(6);
		calculator.roll(2);

		calculator.roll(0);
		calculator.roll(4);

		calculator.roll(8);
		calculator.roll(1);

		calculator.roll(0);
		calculator.roll(0);

		calculator.roll(10);

		calculator.roll(10);

		calculator.roll(4);
		calculator.roll(4);

		calculator.roll(1);
		calculator.roll(8);

		//when
		boolean result = calculator.isFinished();
		//then	
		assertThat(result).isEqualTo(true);
	}
	
	@Test
	public void shouldReturnTrueWhenGameFinishedSpareBonusIncluded() {
		//given
		BowlingGameResultCalculator calculator = new BowlingGameResultCalculatorImpl();
		calculator.roll(10);
		
		calculator.roll(5);
		calculator.roll(4);
		
		calculator.roll(6);
		calculator.roll(2);
		
		calculator.roll(0);
		calculator.roll(4);
		
		calculator.roll(8);
		calculator.roll(1);
		
		calculator.roll(0);
		calculator.roll(0);
		
		calculator.roll(10);
		
		calculator.roll(10);
		
		calculator.roll(4);
		calculator.roll(4);
		
		calculator.roll(9);
		calculator.roll(1);
		calculator.roll(1);
		
		//when
		boolean result = calculator.isFinished();
		//then	
		assertThat(result).isEqualTo(true);
	}

	@Test
	public void shouldReturnTrueWhenGameFinishedStrikeBonusIncluded() {
		//given
		BowlingGameResultCalculator calculator = new BowlingGameResultCalculatorImpl();
		calculator.roll(10);

		calculator.roll(5);
		calculator.roll(4);

		calculator.roll(6);
		calculator.roll(2);

		calculator.roll(0);
		calculator.roll(4);

		calculator.roll(8);
		calculator.roll(1);

		calculator.roll(0);
		calculator.roll(0);

		calculator.roll(10);

		calculator.roll(10);

		calculator.roll(4);
		calculator.roll(4);

		calculator.roll(10);
		calculator.roll(8);
		calculator.roll(1);

		//when
		boolean result = calculator.isFinished();
		//then	
		assertThat(result).isEqualTo(true);
	}
	
}
