// Project 2 - MAP
// DistanceTo.java
// Konstantinos Georgiou
// 3/27/22
// This is project 2 where we will seek the shortest distances to different
// locations on a map. 
public class DistanceTo implements Comparable<DistanceTo> {
	private String target;
	private int distance;

	public DistanceTo(String city, int dist) {
		target = city;
		distance = dist;	
	}

	public String getTarget() {
		return target;
	}

	public int getDistance() {
		return distance;
	}

	public int compareTo(DistanceTo other) {
		return distance - other.distance;
	}

	public String toString() {
		return "Distance to " + target + " is " + distance;
	}
}
