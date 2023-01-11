package Prims_and_Kruskals;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;
 
class Prims {
 
    int minKey(HashMap<Integer, Integer> key, HashMap<Integer,Boolean> mstSet)
    {
        int min = Integer.MAX_VALUE;
        int min_index = -1;	
    	
    	for (Map.Entry<Integer, Integer> entry : key.entrySet()) {
    		
    		if(mstSet.get(entry.getKey()) == false && entry.getValue() < min) {
    			
    			min = entry.getValue();
    			min_index = entry.getKey();
    			
    		}
    		  
    	}
    	        
       return min_index;
    
    }

    
    void printMST(HashMap <Integer, Integer> parent, HashMap<Integer, ArrayList<Node>> adj)
    {
        System.out.println("Edge \tWeight");
        
		for (Entry<Integer, ArrayList<Node>> v : adj.entrySet()) {
			
            System.out.println(v.getKey() + " - " + v.getKey() + "\t");
                  //  + graph[i][parent[i]]);

	   }
                   
    }
   
    void primMST(HashMap<Integer, ArrayList<Node>> adj)
    {
        	HashMap<Integer, Integer> parent = new HashMap<>();

        	HashMap<Integer, Integer> key = new HashMap<>();
        
        	HashMap<Integer, Boolean> mstSet = new HashMap<>();

        	adj.entrySet().forEach(entry ->{
					
            key.put(entry.getKey(), Integer.MAX_VALUE);         
            mstSet.put(entry.getKey(), false);
			
        	});

        	
        key.put(10000,0);

        parent.put(10000,-1);

    {   
        	Kruskals k = new Kruskals();
    		k.addNodes(adj);
    		k.vertices = adj.size();
    		k.kruskalsMST(adj);
    		
    }    		
        	for (Map.Entry<Integer, Integer> c : key.entrySet()) {
    		
        		int u = minKey(key, mstSet);
        		mstSet.put(u, true);
        	
        		int i = 0; 
        		for (Map.Entry<Integer, Integer> v : key.entrySet()) {
        			
        			if(i < adj.get(c.getKey()).size()) {
        				
        				if(adj.get(c.getKey()).get(i).weight != 0 
        	        			&& mstSet.get(v.getKey()) == false && 
        	        			adj.get(c.getKey()).get(i).weight < v.getValue()){
        	        				
        	        		 		parent.put(v.getKey(), u);
        	        		 		key.put(v.getKey(), adj.get(c.getKey()).get(i).weight);
        	       				
        	        			}
        				
        			}
        		
        			
        		i++;
        		
        	}
        		
       }
        
        //printMST(parent, adj);	
        
    }
 
}