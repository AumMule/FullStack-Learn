package com.Shapes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class ShapesTest {

	@Test
	void testComputeSquareArea() {
		
		Shapes obj = new Shapes();
		
		
		
		assertEquals(576,obj.ComputeSquareArea(24));
	}
	
void testComputeCircleArea() {
		
		Shapes obj = new Shapes();
		
		
		
		assertEquals("Area of circle calculation may be wrong",78.5,obj.ComputeCircleArea(5));
	}

}
