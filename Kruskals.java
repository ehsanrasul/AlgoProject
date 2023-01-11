package Prims_and_Kruskals;
import java.util.*;
import java.util.Map.Entry;

public class Kruskals {
	 

	 ArrayList<Node> allEdges = new ArrayList<>();
	 
	 static int vertices = 0;
	
	 
	 public void addEdge(Node newNode) {
	 
	 allEdges.add(newNode); //add to total edges
	 
	 }
	 
	 public void kruskalsMST(HashMap<Integer, ArrayList<Node>> adj){
	 PriorityQueue<Node> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));
	 for (int i = 0; i <allEdges.size() ; i++) {
		 pq.add(allEdges.get(i));
	 }
	 HashMap<Integer, Integer> parent = new HashMap<Integer, Integer>();
	 for (Entry<Integer, ArrayList<Node>> v : adj.entrySet()) {
		 parent.put(v.getKey(), v.getKey());
	 }
	 ArrayList<Node> mst = new ArrayList<>();
	 int index = 0;
	 while(index < vertices-1){
	 Node edge = pq.remove();
	 int x_set = find(parent, edge.source);
	 int y_set = find(parent, edge.destination);
	 if(x_set==y_set){
	 }else {
	 mst.add(edge);
	 index++;
	 union(parent,x_set,y_set);
	 }
	 }
	 //print MST
	 System.out.println("Minimum Spanning Tree: ");
	 printGraph(mst);
	 
	 }



	 public int find(HashMap <Integer, Integer> parent, int vertex){
	 //chain of parent pointers from x upwards through the tree
	 // until an element is reached whose parent is itself
	 
	 if(parent.get(vertex) != null)	 
     if(parent.get(vertex)!= vertex)
	 return find(parent, parent.get(vertex));
	 return vertex;
	 }

	 public void union(HashMap<Integer, Integer> parent, int x, int y){
	 int x_set_parent = find(parent, x);
	 int y_set_parent = find(parent, y);
	 parent.put(y_set_parent, x_set_parent);
	 
	 }

	 
	 
	 public void printGraph(ArrayList<Node> edgeList){
		 
	 FileHandling fh = new FileHandling();
	 fh.MinimumSpannigTree(edgeList);
	 
	 System.out.println("Size "+edgeList.size());	 
	 for (int i = 0; i <edgeList.size() ; i++) {
	 Node edge = edgeList.get(i);
	 System.out.println("Edge-" + i + " source: " + edge.source +
	 " destination: " + edge.destination +
	 " weight: " + edge.weight);
	 }
	 
	}
	 
	 
	 
	 public void addNodes(HashMap <Integer, ArrayList<Node>> adj) {
		 
			for (Entry<Integer, ArrayList<Node>> v : adj.entrySet()) {
				
				for(int i = 0; i < v.getValue().size(); i++) {			
				
					addEdge(v.getValue().get(i));
				
				}
	   	    }

	 }
	 
  }
