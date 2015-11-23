package com.capgemini.fibonacci;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class FibonacciTest {
	
	@Test
	public void shouldReturn1ForFirstElement(){
		//given
		int elementNumber = 1;
		//when
		long elementValue = Fibonacci.fib(elementNumber);
		//then
		assertThat(elementValue).isEqualTo(1L);
	}
	
	@Test
	public void shouldReturn1ForSecondElement(){
		//given
		int elementNumber = 2;
		//when
		long elementValue = Fibonacci.fib(elementNumber);
		//then
		assertThat(elementValue).isEqualTo(1L);
	}
	
	@Test
	public void shouldReturn2ForThirdElement(){
		//given
		int elementNumber = 3;
		//when
		long elementValue = Fibonacci.fib(elementNumber);
		//then
		assertThat(elementValue).isEqualTo(2L);
	}
	
	@Test
	public void shouldReturn3ForFourthElement(){
		//given
		int elementNumber = 4;
		//when
		long elementValue = Fibonacci.fib(elementNumber);
		//then
		assertThat(elementValue).isEqualTo(3L);
	}
	
	@Test
	public void shouldReturn5ForFifthElement(){
		//given
		int elementNumber = 5;
		//when
		long elementValue = Fibonacci.fib(elementNumber);
		//then
		assertThat(elementValue).isEqualTo(5L);
	}
	
	@Test
	public void shouldReturn89ForEleventhElement(){
		//given
		int elementNumber = 11;
		//when
		long elementValue = Fibonacci.fib(elementNumber);
		//then
		assertThat(elementValue).isEqualTo(89L);
	}
	
	@Test
	public void shouldReturn4181ForNineteenthElement(){
		//given
		int elementNumber = 19;
		//when
		long elementValue = Fibonacci.fib(elementNumber);
		//then
		assertThat(elementValue).isEqualTo(4181L);
	}
}
