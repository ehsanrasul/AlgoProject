package Prims_and_Kruskals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class AverageDegree {
	
	public int Degree(ArrayList<Node> nodes) {		
		int count = 0;
		for(int i = 0; i < nodes.size(); i++) {			
			count++;			
		}
		return count;		
	}
	
	public void averageDegree(HashMap<Integer, ArrayList<Node>> adj) {
		
		
		int sumDegree = 0 ; 
		
		for (Entry<Integer, ArrayList<Node>> v : adj.entrySet()) {
			
			sumDegree+= Degree(v.getValue()); 

   	    }
	
		
		double averageDegree = (double) sumDegree/adj.size();
		
		System.out.println("Average Degree of the Graph is "+averageDegree);
		FileHandling fh = new FileHandling();
		fh.AverageDegree(averageDegree);
		
		
	}
	
	
	
}
