package com.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSortingArray {
	
	@Test
	void test() {
		try {
			SortingArray arr = new SortingArray();
			
			int[] unsorted ={1,5,7,9,5,3,4};
//			int[] unsorted =null;
			int[] sorted = arr.SortingArray(unsorted);
			
			System.out.print("Statments below exxception");
			
		}
		catch(NullPointerException e){
			System.out.print("Exception generated : "+e);
		}
		
		
		
	}

}
