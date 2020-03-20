package cisc3130;

import java.io.*;
import java.util.Scanner;


//class Movie represents Node
class Movie {
	private String title;
	private int releaseYear;
	Movie left;
	Movie right;
	
	//constructor method
	public Movie (String title, int releaseYear){
		this.title=title;
		this.releaseYear=releaseYear;
		right=null;
		left=null;
	}
	//method to printout the Node
	public void displayMovie(PrintWriter output)throws IOException{
		
		output.printf("%-100s   \t%5d\n", title, releaseYear);
		
	}
	//method to return the value of Node Title
	public String getTitle() {
		return title;
	}

}
