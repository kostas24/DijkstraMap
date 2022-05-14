// Project 2 - MAP
// Tester.java
// Konstantinos Georgiou
// 3/27/22
// This is project 2 where we will seek the shortest distances to different
// locations on a map. 

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Tester {
	String filename = "cities1.txt";
	@Test
	void test() {

	//DistanceFinder.java test cases
			
		//distanceFinder Method
		DistanceFinder df1 = new DistanceFinder(filename);
		assertNotNull(filename);
		
		//getStartingCity Method
		DistanceFinder df2 = new DistanceFinder(filename);
		
		assertEquals("Pierre",df2.getStartingCity());
		
		//shortestDistances Method
		DistanceFinder df3 = new DistanceFinder(filename);
		assertEquals("{Pendleton=2, Pensacola=11, Peoria=6, Phoenix=6, Pierre=0, Pittsburgh=11, Princeton=13, Pueblo=3}" ,df3.shortestDistances().toString());
		
	}

}
