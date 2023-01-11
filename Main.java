package Prims_and_Kruskals;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	Scanner cin = new Scanner(System.in);
	
	public void Menu() throws FileNotFoundException {

		Prims p = new Prims();
		AverageDegree ad = new AverageDegree();
		FileHandling fhPrims = new FileHandling();
		fhPrims.readfile();	
		fhPrims.addNodes();
	    long  startTime ;
	    long finishTime;
	    long diff;
		 
		while(true) {
		 
		 System.out.println("\n\n");	
		 System.out.println("<------------Menu------------>\t\t");	
		 System.out.println("Press 1 : To Display Adjacency List");
		 System.out.println("Press 2 : To Calculate MST using Kruskals");
		 System.out.println("Press 3 : To Calculate MST using Prims");
		 System.out.println("Press 4 : Calculate the Average Degree of Graph ");
		 	
		 int choice = cin.nextInt();
		 switch(choice) {
		 
		 case 1:
		 
			    startTime = System.nanoTime();
			 	fhPrims.adj.displayAdjacencyList();
			    finishTime = System.nanoTime();
			    diff= finishTime - startTime;
			    System.out.println("\nThe execution time of a program is:  "+diff+" nanoseconds");	
			    fhPrims.fileTrace(fhPrims.adj.adj);
			    
		 break;
		 case 2:
			 
			    startTime = System.nanoTime();
				FileHandling fhKruskals = new FileHandling();
				fhKruskals.readfile();
				Kruskals k = new Kruskals();
			    fhKruskals.addNodes();
			    k.vertices = fhKruskals.adj.adj.size();				   
			    k.addNodes(fhKruskals.adj.adj);
				
			    k.kruskalsMST(fhKruskals.adj.adj);

			    finishTime=System.nanoTime();
			    diff= finishTime - startTime;
			    System.out.println("\nThe execution time of a program is:  "+diff+" nanoseconds");	
			    fhPrims.outputExecutionTime(diff);			    

			 
			 
		 break;
		 case 3:

			    startTime = System.nanoTime();
				p.primMST(fhPrims.adj.adj);
			    finishTime=System.nanoTime();
			    diff= finishTime - startTime;
			    System.out.println(" \nThe execution time of Funtion program is:  "+diff+" nanoseconds");	
			    fhPrims.outputExecutionTime(diff);
			 
		 break;
		 case 4:
			 
				ad.averageDegree(fhPrims.adj.adj);
			    startTime = System.nanoTime();;
			    finishTime=System.nanoTime();
			    diff= finishTime - startTime;
			    System.out.println("\nThe execution time of a program is:  "+diff+" nanoseconds");	
			    fhPrims.outputExecutionTime(diff);
			    
			 
		 break;
		 
		 }
		 		
		}
		
	}

	public static void main(String[] args) throws FileNotFoundException {

		
		Main m = new Main();
		m.Menu();		
		
	}

}
