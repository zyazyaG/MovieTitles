package cisc3130;
import java.io.*;
import java.util.Scanner;

//class MovieTree represents Binary Search Tree
class MovieTree {
	private Movie root;
	
	//constructor method
	MovieTree(String key, int year) {
		root=new Movie(key, year);
	}
	
	//constructor method
	MovieTree(){
		root=null;
	}
	
	//method to add Node in Tree
	public void add(Movie movie) {
		root=addMovie(root, movie);
	}
	
	//method to return the Node
	public Movie getRoot() {
		return root;
	}
	
	//method to fill up the Tree
	public Movie addMovie(Movie root, Movie movie) {
		if (root==null) {
			root=movie;
			return root;
		}
		//if node value is less than root go to the left side
		if (movie.getTitle().compareTo(root.getTitle())<0) {
			root.left=addMovie(root.left,movie);
		}
		//if node value is greater than root go to the right side
		else if (movie.getTitle().compareTo(root.getTitle())>0) {
			root.right=addMovie(root.right,movie);
		}
		
		return root;
	}
	
	//method to display whole Tree
	public void display() throws IOException{
		PrintWriter output=new PrintWriter("ListOfAllMovies.txt");
		displayTree(root, output);
	}
	
	//method to traverse through Tree
	public void displayTree(Movie movie, PrintWriter output) throws IOException {
		
		if (movie!=null) {
			displayTree(movie.left, output);
			movie.displayMovie(output);
			displayTree(movie.right, output);
			
		}
	}

	//method to read in all data into the Tree
	public void readData(String fileName, MovieTree tree) throws IOException{
		PrintWriter output=new PrintWriter ("output.txt");// output file
		Scanner input=new Scanner(new File(fileName));//Scanner to read file
		String empt=input.nextLine();//reads in first line 
	    //loop though the Tree
		while (input.hasNextLine()) {
			if (input.hasNextLine()) {
				String [] temp=input.nextLine().split("''");//temporary array to store line
				String line=temp[1].replaceAll("\"", "");
				if (line.indexOf("(")!=-1&line.indexOf("–")==-1) {
					String yearS=line.substring(line.lastIndexOf("(")+1, line.lastIndexOf(")"));
					int year=Integer.parseInt(yearS);// read in year as a int
					String line1=line.substring(0,line.lastIndexOf("("));// trim the Title and Store only title
					Movie movie=new Movie(line1, year);// create a node
					tree.add(movie);//add Node into Tree
				}
			}
		}
	}
	
	//method to display subset of Tree in the given Range
	public void subSet (Movie movie, String begin, String end, PrintWriter output) throws IOException{
		if (movie==null)
			return;
		subSet(movie.left, begin, end, output);
		if (begin.compareToIgnoreCase(movie.getTitle())<=0&&end.compareToIgnoreCase(movie.getTitle())>=0) {
			movie.displayMovie(output);
		}
		subSet(movie.right, begin, end,output);
	}
	
}//close Tree class
