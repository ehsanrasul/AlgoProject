package Prims_and_Kruskals;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class FileHandling {

	public AdjacencyList adj = new AdjacencyList();
	
	public int numOfNodes;
	
	ArrayList<Node> nArr=new ArrayList<Node>();	
	
	public  void readfile() throws FileNotFoundException {	
		
		try {
			File myObj = new File("C:\\Users\\Ehsan Rasul\\Desktop\\Data.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] items= data.trim().split("\\s+");
				int source = Integer.parseInt(items[0]);
				int destination = Integer.parseInt(items[1]);
				int weight = 1 ;

				Node data1 =new Node(source,destination,1);
				nArr.add(data1);
				numOfNodes++;

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
	
	
	public void displayData() {
		for(int i=0; i<numOfNodes; i++) {
	
			System.out.println(nArr.get(i).toString());		
		}

	}
	
	
	
	public void addNodes() {
		
		for(int i = 0 ; i < nArr.size(); i++) {
			
			adj.addEdge(nArr.get(i));
			
		}
		
	}
	
	
		
	
	public void fileTrace(HashMap <Integer, ArrayList<Node>> adj)
	{
		
		  try {
			  FileWriter writer = new FileWriter("C:\\Users\\Ehsan Rasul\\eclipse-workspace\\ALGO_PROJECT\\src\\Trace.txt");
			  PrintWriter buffer = new PrintWriter(writer);
			  
			  
				writer.write("Adjacency List \n");
				
		    	for (Map.Entry <Integer, ArrayList<Node>> entry : adj.entrySet()) {
		    				    	
		    		writer.write(entry.getKey()+"\t");
					writer.write("Head\t");
					for(int i = 0 ; i < entry.getValue().size(); i++) {
						
						writer.write("-> "+entry.getValue().get(i).destination);
						
					}
					
					writer.write("\n");
		    		  
		    	}
			  
			  buffer.close();
			 
		  
		  }
			     catch (Exception e){
				 System.out.println("error occured ");
			     e.printStackTrace();
			  }
		
	}
	
	

	
	
	
	public void MinimumSpannigTree(ArrayList<Node> edgeList)
	{
		
		  try {
			  FileWriter writer = new FileWriter("C:\\Users\\Ehsan Rasul\\eclipse-workspace\\ALGO_PROJECT\\src\\Output.txt");
			  PrintWriter buffer = new PrintWriter(writer);
			  
			     writer.write("Minimum Spannig Tree \n");	
				 for (int i = 0; i <edgeList.size() ; i++) {
				 Node edge = edgeList.get(i);
				 writer.write("Edge-" + i + " source: " + edge.source +
				 " destination: " + edge.destination +
				 " weight: " + edge.weight+ "\n");
				 }
			  
			  buffer.close();
			 
		  
		  }
			     catch (Exception e){
				 System.out.println("error occured ");
			     e.printStackTrace();
			  }
		
	}
	
	
	
	public void outputExecutionTime(double executionTime)
	{
		
		  try {
			  FileWriter writer = new FileWriter("C:\\Users\\Ehsan Rasul\\eclipse-workspace\\ALGO_PROJECT\\src\\Output.txt", true);
			  PrintWriter buffer = new PrintWriter(writer);
			  
			  writer.write("\nThe Execution Time of the Function is : "+executionTime+" \n");
			     
			  
			  buffer.close();
			 
		  
		  }
			     catch (Exception e){
				 System.out.println("error occured ");
			     e.printStackTrace();
			  }
		
	}
	
	
	
	
	public void AverageDegree(double averageDegree)
	{
		
		  try {
			  FileWriter writer = new FileWriter("C:\\Users\\Ehsan Rasul\\eclipse-workspace\\ALGO_PROJECT\\src\\Output.txt");
			  PrintWriter buffer = new PrintWriter(writer);
			  
			  writer.write("Average Degree of the Graph is "+averageDegree);
			  buffer.close();
			 
		  
		  }
			     catch (Exception e){
				 System.out.println("error occured ");
			     e.printStackTrace();
			  }
		
	}
	


	
	

}


	

