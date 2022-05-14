// Project 2 - MAP
// DistanceFinderDemo.java
// Konstantinos Georgiou
// 3/27/22
// This is project 2 where we will seek the shortest distances to different
// locations on a map. 
import java.util.Scanner;

public class DistanceFinderDemo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("File with city names: ");
		String filename = in.nextLine();
		DistanceFinder d = new DistanceFinder(filename);

		System.out.println("Shortest distance from " + d.getStartingCity());
		System.out.println(d.shortestDistances());
		
	}
}
