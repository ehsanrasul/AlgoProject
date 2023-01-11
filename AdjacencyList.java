package Prims_and_Kruskals;

import java.util.ArrayList;
import java.util.HashMap;

public class AdjacencyList {

	HashMap<Integer, ArrayList<Node>> adj = new HashMap<>();
	public void addEdge(Node newNode) {
		if(adj.isEmpty()) {
			adj.put(newNode.source, new ArrayList<>());
			adj.get(newNode.source).add(new Node(newNode.source,newNode.destination,1));
			adj.put(newNode.destination, new ArrayList<>());
			adj.get(newNode.destination).add(new Node(newNode.destination,newNode.source,1));
		}		
		else if(adj.get(newNode.source) != null) {
			adj.get(newNode.source).add(new Node(newNode.source,newNode.destination,1));
			if(adj.get(newNode.destination) != null) {
				adj.get(newNode.destination).add(new Node(newNode.destination,newNode.source,1));
			}else {
				adj.put(newNode.destination, new ArrayList<>());
				adj.get(newNode.destination).add(new Node(newNode.destination,newNode.source,1));
			}
		}else {
			adj.put(newNode.source, new ArrayList<>());
			adj.get(newNode.source).add(new Node(newNode.source,newNode.destination,1));
		}		
	}
	
	
	
	public void displayAdjacencyList() {
		
		
		System.out.println("Adjacency List");
		
		adj.entrySet().forEach(entry ->{
			
			System.out.print(entry.getKey()+" ");
			System.out.print("Head  ");
			for(int i = 0 ; i < entry.getValue().size(); i++) {
				
				System.out.print("-> "+entry.getValue().get(i).destination);
				
			}
			
			System.out.println();
			
		});

		
		
	}
	
	
	
	
}
