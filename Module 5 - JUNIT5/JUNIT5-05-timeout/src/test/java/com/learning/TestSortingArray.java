package com.learning;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;

class TestSortingArray {
	
	@Test
	void testSortingMethod_Performance() {
		SortingArray arr = new SortingArray();
		
		int unsorted[] = {4,5,8,6,2};
		
		assertTimeout(Duration.ofMillis(100),()->arr.SortingArray(unsorted));
		
	}

}
