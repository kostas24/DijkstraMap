// Project 2 - MAP
// DistanceFinder.java
// Konstantinos Georgiou
// 3/27/22
// This is project 2 where we will seek the shortest distances to different
// locations on a map. 
import java.util.*; 
import java.io.*;
/**
   Class for simulating finding the shortest distance
   from a city to all other cities.
*/
public class DistanceFinder
{
   private String startFrom;
   private Map<String, HashSet<DistanceTo>> directConnections;
  

   /**
      Construct a Distance finder.
      @param filename the file containing the connections.
    * @throws IOException 
   */
   public DistanceFinder(String filename) //read file
   {
	   
	   directConnections = new HashMap<>();
	   try (Scanner in = new Scanner(new File(filename))) {
		   while (in.hasNext()) {
			   	String from = in.next();
			   	String to = in.next();
			   	int distance = in.nextInt();
			   	// The starting point is the first city in the first line.
			   	if (startFrom == null) {
			   		startFrom = from;
			   	}
			   	if (directConnections.get(from) == null) {
			   		directConnections.put(from, new HashSet<>());
			   	}
			   	directConnections.get(from).add(new DistanceTo(to, distance));
			   	if (directConnections.get(to) == null) {
			   		directConnections.put(to, new HashSet<>());
			   	}
			   	directConnections.get(to).add(new DistanceTo(from, distance));
			   	//System.out.println(from + " " + to + " "+ distance);
			   	System.out.println(directConnections);
		   }
	   }
	   catch (FileNotFoundException e) {
		   System.out.println("File " + filename + " could not be opened.");
	   	}
   }

   /**
      Return the city that we start from.
   */
   public String getStartingCity()
   {
      return startFrom;
   }

   /**
      Return the shortest distances.
      @return the shortest distances.
   */
   public Map<String, Integer> shortestDistances() //find shortest distance from starting point aka first city in txt file
   {
	   String target;
	   PriorityQueue<DistanceTo> thePriorityQueue = new PriorityQueue<>();
	   
	   thePriorityQueue.add(new DistanceTo(startFrom, 0));
	   Map<String, Integer> shortestKnownDistances = new TreeMap<>();
	   
	   ArrayList<String> visited = new ArrayList<String>();
	   
	   DistanceTo smallest = null;
	 	while (thePriorityQueue.size() > 0) {

	 		 smallest = thePriorityQueue.remove();
	 		
	 		if(!shortestKnownDistances.containsKey(smallest.getTarget()))
	 		{
	 			visited.add(smallest.getTarget());
	 			target = smallest.getTarget();
	 		  
                int d=smallest.getDistance();              
                shortestKnownDistances.put(target, d);

                HashSet<DistanceTo> connectionFromTarget = new HashSet<DistanceTo>();

                connectionFromTarget = directConnections.get(smallest.getTarget());

                for (DistanceTo c : connectionFromTarget)
                {
                     if(!visited.contains(c.getTarget()))
                     {
                          DistanceTo next = new DistanceTo(c.getTarget(), d + c.getDistance());
                          if(!thePriorityQueue.contains(next))            	  
                        	  thePriorityQueue.add(next);       
                     }

                }

           }
	 	}	
	 return shortestKnownDistances;
   }
  
}
