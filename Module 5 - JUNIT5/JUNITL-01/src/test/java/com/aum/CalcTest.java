package com.aum;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTest {

	@Test
	public void test() {
		Calc obj  = new Calc();
		int actual = obj.divide(10, 5);
		int expectedResult = 2;
		
		assertEquals(actual,expectedResult);
	}

}
