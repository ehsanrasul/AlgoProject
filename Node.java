package Prims_and_Kruskals;


public class Node {

	int source;
	int destination;
	int weight;
	
	public Node(int source, int destination, int weight) {
		super();
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	
	@Override
	public String toString() {
		return "Node [source=" + source + ", destination=" + destination + ", weight=" + weight + "]";
	}
	
	
	
	
}
