package cisc3130;

import java.io.*;

public class MovieTitles {
	public static void main (String []args) throws IOException{
		
		String file="/Users/azizagulyamova/Downloads/ml-latest-small-2/movies.csv";//file path
		PrintWriter output=new PrintWriter ("ListOfAllSubsets.txt");//output file to print out the Subset of tree
		
		MovieTree tree=new MovieTree(); //Tree
		
		tree.readData(file, tree);// read in file into Tree
		tree.display();// print out whole Tree in Sorted Way
		
		output.println("The first subset of the Movie Tree");
		tree.subSet(tree.getRoot(),"10","102", output);// first subset
		output.println("\nThe second Subset of th Movie Tree");
		tree.subSet(tree.getRoot(), "Creep", "Evelyn", output);//second subset
		output.println("\nThe third Subset of th Movie Tree");
		tree.subSet(tree.getRoot(), "Perfect", "Pscyho", output);//third subset

		output.close();
	}

}
