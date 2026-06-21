package com.learning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ShapesTest {

	Shapes obj ;
	@BeforeEach
	void init() {
		obj = new Shapes();
		System.out.println("Before test");
	}
	
	@Test
	void testComputeSquareArea() {
	
		assertEquals(576,obj.ComputeSquareArea(24));
		System.out.println("Actual test Running");
		
	}
	@Test
	void testComputeCircleArea() {			
		assertEquals(78.5,obj.ComputeCircleArea(5),"Area of circle calculation may be wrong");
		System.out.println("Actual test Running");
	}
	
	@AfterEach
	void destroy() {
		System.out.println("After test for cleaning purpose");
	}

}
