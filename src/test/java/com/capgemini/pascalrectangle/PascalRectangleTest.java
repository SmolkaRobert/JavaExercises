package com.capgemini.pascalrectangle;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class PascalRectangleTest {
	
	@Test
	public void shouldReturn1ForRow0Column0(){
		//given
		int pascalRow = 0;
		int pascalColumn = 0;
		//when
		PascalRectangle simplePascalRect = new PascalRectangle();
		long pascalValue = simplePascalRect.pascal(pascalColumn, pascalRow);
		//then
		assertThat(pascalValue).isEqualTo(1L);
	}
	
	@Test
	public void shouldReturn1ForAllElementsOfRow1(){
		//given
		int pascalRow1 = 1;
		int pascalColumn0 = 0;
		int pascalColumn1 = 1;
		//when
		PascalRectangle simplePascalRect = new PascalRectangle();
		long pascalValue0 = simplePascalRect.pascal(pascalColumn0, pascalRow1);
		long pascalValue1 = simplePascalRect.pascal(pascalColumn1, pascalRow1);
		//then
		assertThat(pascalValue0).isEqualTo(1L);
		assertThat(pascalValue1).isEqualTo(1L);
	}
	
	@Test
	public void shouldReturn6ForRow4Column2(){
		//given
		int pascalRow = 4;
		int pascalColumn = 2;
		//when
		PascalRectangle simplePascalRect = new PascalRectangle();
		long pascalValue = simplePascalRect.pascal(pascalColumn, pascalRow);
		//then
		assertThat(pascalValue).isEqualTo(6L);
	}
	
	@Test
	public void shouldReturn126ForRow9Column5(){
		//given
		int pascalRow = 9;
		int pascalColumn = 5;
		//when
		PascalRectangle simplePascalRect = new PascalRectangle();
		long pascalValue = simplePascalRect.pascal(pascalColumn, pascalRow);
		//then
		assertThat(pascalValue).isEqualTo(126L);
	}
}
