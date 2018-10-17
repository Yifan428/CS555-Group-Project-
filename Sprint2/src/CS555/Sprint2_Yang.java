package CS555;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Sprint2_Yang {
	static List<Individual> allIndividuals = new ArrayList<Individual>();
	static List<Family> allFamilies = new ArrayList<Family>();

     	//Sprint 2
	//US29
	public List<Individual> getDeceased() {
    	 List<Individual> res = new ArrayList<Individual>();
    	 for (Individual i : allIndividuals)
    		 if (i.isAlive()== "False")
    			 res.add(i);
    	 return res;
     }

    
    	//Sprint 1 
   	//US22
    	public static boolean uniqueId(List<String> ID) {
		ArrayList<String> list = new ArrayList<String>();
		for (String id : ID) {
			if (list.contains(id)) return false;
			else list.add(id);
		}
		return true;
	}
    
	//US01 
    	public static boolean validateDate(String inputDate) { 
    	
 		try { 
 			if (inputDate.equalsIgnoreCase("NA")) {
 				return false;
 			}
 			else { 
 				Date now = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy", Locale.ENGLISH); 
				String time = sdf.format(now.getTime());
 	            Date date1 = sdf.parse(inputDate);  
 	            if (date1.after(now)) { 
 	            	return true; 
 	            } 
 			
 			}
 		} catch(ParseException e) { 
 			System.out.println("Exception in parsing date " + inputDate); 
 			return false; 
 		}
		return false; 
 
 	} 
    
	public static void printINDIAndFAMTables(File f) {
        BufferedReader br = null;

        try {
	    	br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
	    	
	    	Individual indv = null;
	    	Family currentFamily = null;
	    	boolean readingBirthDate = false;
	    	boolean readingDeathDate = false;
	    	boolean readingMarriageDate = false;
	    	boolean readingDivorceDate = false;
	    	
	    	// read each line from the file
	    	for (String line = br.readLine(); line != null; line = br.readLine()) {

				// Split the line into words	
				String[] words = line.split(" ");

				// check if the line is valid
				if(words != null && words.length >= 2) {
					
					boolean isSpecialScenario = false;
					if(words.length >= 3 && (words[2].equals("INDI") || words[2].equals("FAM")) ) {
						isSpecialScenario = true;
					}
					
					// obtain level, tag and value from the line
					String level = words[0];
					String tag = "";
					String value = "";
					
					if(!isSpecialScenario) {
						tag = words[1];
						for(int i=2;i<words.length;i++) {
							value += words[i] + " ";
						}
					} else {
						tag = words[2];
						value = words[1];
						for(int i=3;i<words.length;i++) {
							value += " " +words[i];
						}
					}
					
					// Check if we encounter INDI record, 
					if(tag.equals("INDI")) {
						indv = new Individual();
						indv.setId(value);
						
						allIndividuals.add(indv);
					
					}
					
					if(tag.equals("NAME") && indv != null) {
						indv.setName(value);
					}
					if(tag.equals("SEX")) {
						indv.setGender(value);
					}
					
					if(tag.equals("BIRT")) {
						readingBirthDate = true;
						continue;
					}
					if(tag.equals("DATE") && readingBirthDate) {
						readingBirthDate = false;
						indv.setBirthDate(value);
					}
					
					if(tag.equals("MARR")) {
						readingMarriageDate = true;
						continue;
					}
					if(tag.equals("DATE") && readingMarriageDate) {
						readingMarriageDate = false;
						currentFamily.setMarriageDate(value);
					}

					if(tag.equals("DIV")) {
						readingDivorceDate = true;
						continue;
					}
					if(tag.equals("DATE") && readingDivorceDate) {
						readingDivorceDate = false;
						currentFamily.setDivorceDate(value);
					}

					if(tag.equals("DEAT")) {
						readingDeathDate = true;
						continue;
					}
					if(tag.equals("DATE") && readingDeathDate) {
						readingDeathDate = false;
						indv.setDeathDate(value);
					}
					
					if(tag.equals("FAM")) {
						currentFamily = null;
						for (Family family:allFamilies) {
							if(family.getId().trim().equals((value.replaceAll("@", "")).trim()))
								currentFamily = family;
						}
						if(currentFamily == null) {
							currentFamily = new Family();
							currentFamily.setId(value.replaceAll("@", ""));
							allFamilies.add(currentFamily);
						}
					}
					
					if(tag.equals("FAMS")) {
						indv.getSpouseFamilyIds().add(value);
						
						// Let's add the spouse to family table
						Family fam = null;
						for (Family family:allFamilies) {
							if(family.getId().equals(value.replaceAll("@", "")))
								fam = family;
						}
						if(fam == null) {
							fam = new Family();
							fam.setId(value.replaceAll("@", ""));
							allFamilies.add(fam);
						}
						if(indv.getGender().trim().equals("M")) {
							fam.setHusbandName(indv.getName());
							fam.setHusbandId(indv.getId());
						} else {
							fam.setWifeName(indv.getName());
							fam.setWifeId(indv.getId());
						}
					}
					
					if(tag.equals("FAMC")) {
						indv.getChildFamilyIds().add(value);
						
						// Let's add the children IDs to the family table
						Family fam = null;
						for (Family family:allFamilies) {
							if(family.getId().equals(value.replaceAll("@", "")))
								fam = family;
						}
						if(fam == null) {
							fam = new Family();
							fam.setId(value.replaceAll("@", ""));
							allFamilies.add(fam);
						}
						if(fam.getChildrenId() == null) {
							List<String> childrenIds = new ArrayList<String>();
							fam.setChildrenId(childrenIds);
						} else {
							if(!fam.getChildrenId().contains(value))
								fam.getChildrenId().add(value);
						}
					}
					
				}
	    	}
	    	
	    	// at this stage we have all Individuals stored in list named allIndividuals
	    	System.out.println("Individuals");
	    	System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", 
	    			"----------", "-------------------------", "-------", "------------", "-----", "-------", "------------", "--------------------", "--------------------");
	    	System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", 
	    			"ID", "Name", "Gender", "Birthday", "Age", "Alive", "Death", "Child", "Spouse");
	    	System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", 
	    			"----------", "-------------------------", "-------", "------------", "-----", "-------", "------------", "--------------------", "--------------------");
	    			
	    	for(int i=0;i<allIndividuals.size();i++) {
	    		Individual currentIndv = allIndividuals.get(i);
	    		System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", 
	    				currentIndv.getId(), currentIndv.getName(), currentIndv.getGender(),
	    				currentIndv.getBirthDate(), currentIndv.getAge(), currentIndv.isAlive(),
	    				currentIndv.getDeathDate(), currentIndv.getChildFamilyIdsAsString(), currentIndv.getSpouseFamilyIdsAsString());
	    	}
	    	System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", 
	    			"----------", "-------------------------", "-------", "------------", "-----", "-------", "------------", "--------------------", "--------------------");
	    	
	    	// Now, let's print all families stored in list named allFamilies
	    	System.out.println("Families");
	    	System.out.format("|%1$-10s|%2$-12s|%3$-12s|%4$-5s|%5$-25s|%6$-10s|%7$-25s|%8$-20s|\n", 
	    			"----------", "------------", "------------", "----------", "-------------------------", "----------", "-------------------------", "--------------------");
	    	
	    	
	    	System.out.format("|%1$-10s|%2$-12s|%3$-12s|%4$-5s|%5$-25s|%6$-10s|%7$-25s|%8$-20s|\n", 
	    			"ID", "Married", "Divorced", "Husband ID", "Husband Name", "Wife ID", "Wife Name", "Children");
	    	System.out.format("|%1$-10s|%2$-12s|%3$-12s|%4$-5s|%5$-25s|%6$-10s|%7$-25s|%8$-20s|\n", 
	    			"----------", "------------", "------------", "----------", "-------------------------", "----------", "-------------------------", "--------------------");
	    	for(Family fam: allFamilies)
	    		System.out.format("|%1$-10s|%2$-12s|%3$-12s|%4$-10s|%5$-25s|%6$-10s|%7$-25s|%8$-20s|\n", 
	    				fam.getId(), fam.getMarriageDate() == null ? "NA" : fam.getMarriageDate(), fam.getDivorceDate() == null ? "NA" : fam.getDivorceDate(), fam.getHusbandId(),
	    								fam.getHusbandName(),fam.getWifeId(), fam.getWifeName(),fam.getChildrenIdAsString());
	    	System.out.format("|%1$-10s|%2$-12s|%3$-12s|%4$-10s|%5$-25s|%6$-10s|%7$-25s|%8$-20s|\n", 
	    			"----------", "------------", "------------", "----------", "-------------------------", "----------", "-------------------------", "--------------------");
	    							
        
        }  catch (IOException e) {
        	//e.printStackTrace();
        	System.out.println("Look like you passed incorrect file name");
        }  finally {
        	try {
        		if (br != null)br.close();
        		
        	} catch (IOException ex) {
        		ex.printStackTrace();
        	}
        }

	}
}
