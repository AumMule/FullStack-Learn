package com.learning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)//due to this only one instance is being created
class ShapesTest {

	Shapes obj ;
	
	ShapesTest(){
		System.out.print("Gets Executed on each object creating that is number of test cases");
	}
	
	@BeforeAll
	static void beforeAll() {//mostly used for static
		System.out.println("Before all the tests");
	}
	
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
	
	@AfterAll
	static void afterAll() {//mostly used for static
		System.out.println("After all the tests for destroying the memory");
	}

}
