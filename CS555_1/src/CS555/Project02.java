package CS555;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.io.BufferedReader;
import static CS555.GedcomLint.*;

public class Project02 {
	
	public static void parseAndPrintGEDCOMData(File ged) {
        BufferedReader br = null;
        try {
	    	br = new BufferedReader(new InputStreamReader(new FileInputStream(ged)));
	    	
	    	// read line by line
	    	for (String line = br.readLine(); line != null; line = br.readLine()) {
				
				// Print the input line 
				System.out.println("--> " + line);
				
				// Print the output line
				System.out.print("<-- "); 
				// Split the line into words	
				String[] words = line.split(" ");
				
				// check if the line is valid
				if(words != null && words.length >= 2) {
					
					boolean isSpecialScenario = false;
					if(words.length >= 3 && (words[2].equals("INDI") || words[2].equals("FAM")) ) {
						isSpecialScenario = true;
					}
					
					String level = words[0];
					String tag = "";
					if(!isSpecialScenario) {
						tag = words[1];
					} else {
						tag = words[2];
					}
					
					System.out.print(level + "|" + tag);	
					
					// check if level target
					if ( VALID_LEVEL.containsKey(level) 
							&& VALID_LEVEL.get(level).contains(tag) ) {
						System.out.print("|Y");
					} else {
						System.out.print("|N");
					}
					
					if(words.length > 2) {
						System.out.print("|");
						if(isSpecialScenario) {
							System.out.print(words[1]);
							for(int i=3; i<words.length; i++) {
								System.out.print(" " + words[i]);
							}
						} else {
							for(int i=2; i<words.length; i++) {
								System.out.print(words[i]+ " ");
							}
						}
					}
				}
				System.out.println("");
	    	}
        }  catch (IOException e) {
       
        	System.out.println("File cant find...");
        }  finally {
        	try {
        		if (br != null)br.close();
        		
        	} catch (IOException ex) {
        		ex.printStackTrace();
        	}
        }
	}

	
	public static void main(String[] args) {
		
		String pathname = "My-Family-5-Sep-2018_Yongchang Yao.ged"; 
		
		File filename = new File(pathname);
		System.out.println("Test my GEDCOM file...");
		Project02.parseAndPrintGEDCOMData(filename);
		System.out.println("Test given GEDCOM file...");
		String pathname2 = "proj02test.ged"; 
		
		File filename2 = new File(pathname2);
		Project02.parseAndPrintGEDCOMData(filename2);
	}
	
}