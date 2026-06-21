package com.Shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


class ShapesTest {

	@Test
	void testComputeSquareArea() {
		
		Shapes obj = new Shapes();
		
		
		
		assertEquals(576,obj.ComputeSquareArea(24));
	}
	
void testComputeCircleArea() {
		
		Shapes obj = new Shapes();
		
		
		
		assertEquals(78.5,obj.ComputeCircleArea(5),"Area of circle calculation may be wrong");
	}

}
