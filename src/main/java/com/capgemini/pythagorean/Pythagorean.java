package com.capgemini.pythagorean;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Pythagorean {

	private int a, b, c;
	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getC() {
		return c;
	}

	
	public void solution(){
		int elementSum = 1000;
		//condition a < b < c
		int limitA = elementSum/3 - 1;
		
		for(a = 1; a <= limitA; a++){
			//condition a < b < c
			int limitB = (elementSum - a)/2 - 1;
			
			for(b = a + 1; b <= limitB; b++){
				c = elementSum - a - b;
				
				if(a*a + b*b == c*c){
					return;
				}
			}
		}
	}

}