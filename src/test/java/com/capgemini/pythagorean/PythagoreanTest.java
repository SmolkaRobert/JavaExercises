package com.capgemini.pythagorean;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class PythagoreanTest {
	
	@Test
	public void shouldBeFromLowestToHighestABC(){
		//given
		Pythagorean pythagoreanTriplet = new Pythagorean();
		pythagoreanTriplet.solution();
		
		//when
		int b = pythagoreanTriplet.getB();
		int a = pythagoreanTriplet.getA();
		int c = pythagoreanTriplet.getC();
		
		//then
		assertThat(b).isStrictlyBetween(a, c);
	}
	
	@Test
	public void shouldBe1000Total(){
		//given
		Pythagorean pythagoreanTriplet = new Pythagorean();
		pythagoreanTriplet.solution();
		
		//when
		int b = pythagoreanTriplet.getB();
		int a = pythagoreanTriplet.getA();
		int c = pythagoreanTriplet.getC();
		
		//then
		assertThat(a + b + c).isEqualTo(1000);
	}
	
	@Test
	public void shouldBePythagoreanTriplet(){
		//given
		Pythagorean pythagoreanTriplet = new Pythagorean();
		pythagoreanTriplet.solution();
		
		//when
		int b = pythagoreanTriplet.getB();
		int a = pythagoreanTriplet.getA();
		int c = pythagoreanTriplet.getC();
		
		//then
		assertThat(a*a + b*b).isEqualTo(c*c);
	}
}
