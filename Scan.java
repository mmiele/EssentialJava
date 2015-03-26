package com.tutorial.essentials;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

/**
 * Demonstrates how to use the Scanner type for breaking down formatted input into tokens and 
 * translating individual tokens according to their data type.
 * @author Michael
 * @see java.util.Scanner
 */
public class Scan {
	
	/*
	 * Gets the absolute path of the files used in the 
	 * I/O stream examples.
	 * The files directory is assumed to be /test/.
	 * @param fileName - the name of the file for which to get the absolute path.
	 * @return - the absolute path of the file.
	 */
	private String getFilePath (String fileName) {
		
		String workDir = "/test/";
		
		// Get the current working directory path.
        String dir = System.getProperty("user.dir");
        
		// Return the file path.
        return dir.concat(workDir.concat(fileName));
		
	}
	
	/**
	 * Reads a text file containing words and print one word per line.
	 * Notice that this method uses the Scanner default values for the tokens delimiter
	 * and type that are whitespace and String respectively.
	 * @param inFileName - The input file name.
	 */
	public void readWords(String inFileName){
		 Scanner s = null;
		 String inFilePath = this.getFilePath(inFileName);

	        try {
	        	// Create a Scanner object and initialize it with
	        	// a buffered text file containing words.
	            s = new Scanner(new BufferedReader(new FileReader(inFilePath)));

	            // Scan the file and print each word.
	            // By default, a scanner uses white space to separate tokens.
	            while (s.hasNext()) {
	                System.out.println(s.next());
	            }
	        } catch (FileNotFoundException e) {
	        	System.out.println(String.format("%s", e.getMessage()));
			} finally {
	            if (s != null) {
	                s.close();
	            }
	        }
		
	}

	/**
	 * Reads a a text file containing a list of double values and add them.
	 * Notice that this method uses the Scanner default values for the tokens delimiter
	 * and type that are whitespace and String respectively.
	 * @param inFileName - The input file name.
	 */
	public void readDouble(String inFileName){
		 Scanner s = null;
		 String inFilePath = this.getFilePath(inFileName);
		 Double sum = (double) 0;
		 
	        try {
	        	// Create a Scanner object and initialize it with
	        	// a buffered text file containing numbers.
	            s = new Scanner(new BufferedReader(new FileReader(inFilePath)));
	            s.useLocale(Locale.US);
	            
	            // Scan the file and print each word.
	            // By default, a scanner uses white space to separate tokens.
	            while (s.hasNext()) {
	            	if (s.hasNextDouble()) {
	            		sum += s.nextDouble();
	            	} else {
	            		s.next();
	            	}
	            }
	        } catch (FileNotFoundException e) {
	        	System.out.println(String.format("%s", e.getMessage()));
			} finally {
	            if (s != null) {
	                s.close();
	            }
	            System.out.println(String.format("The sum of all the doubles is: %.8f" , sum));
	        }
		
	}
}
