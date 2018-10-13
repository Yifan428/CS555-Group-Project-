package proj_04;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;


public class SprintTest_Yang {
	
	
	public SprintTest_Yang() {
		
		File filename = new File("D:\\eclipse-workspace\\CS555\\src\\proj_04\\Test_Family_Team wisdom of Mr Toad.ged");
		Sprint1_Yang.printINDIAndFAMTables(filename);
	}
	
    @Test
    public void testUserStory22() {
    	List<Individual> individuals = Sprint1_Yang.allIndividuals;
    	List<Family> families = Sprint1_Yang.allFamilies;
    	ArrayList<String> IndvID = new ArrayList<>();
    	ArrayList<String> FamID = new ArrayList<>();
    	for (int i = 0; i < individuals.size(); i++) { 
 			Individual individual = individuals.get(i); 
 			String indvID = individual.getId(); 
 			IndvID.add(indvID);
 			if(!Sprint1_Yang.uniqueId(IndvID)) {
 				System.out.println("ERROR: INDIVIDUAL: US22: There are same ID in the Individuals. ");
 				break;
 			}
 		} 
    	for (int j = 0; j < families.size(); j++) { 
    		Family family = families.get(j); 
 			String famID = family.getId(); 
 			FamID.add(famID);
 			if(!Sprint1_Yang.uniqueId(FamID)) {
 				System.out.println("ERROR: Family: US22: There are same ID in the Families. ");
 				break;
 			}
 		} 
    }
    
    @Test
 	public void testUserStory01() { 
 		List<Individual> individuals = Sprint1_Yang.allIndividuals; 
 		for (int i = 0; i < individuals.size(); i++) { 
 			Individual individual = individuals.get(i); 
 			String birthday = individual.getBirthDate(); 
 			if(Sprint1_Yang.validateDate(birthday)) {
 				System.out.println("ERROR: INDIVIDUAL: US01: " + individual.getId() + ": " + "Birthday " + birthday + " occurs in the future");
 			}
 
 			String death = individual.getDeathDate(); 
 			if (Sprint1_Yang.validateDate(death)) { 
 				System.out.println("ERROR: INDIVIDUAL: US01: " + individual.getId() + ": " + "DeathDate " + death + " occurs in the future");
 			} 

 		} 
 	
 		List<Family> families = Sprint1_Yang.allFamilies; 
 		for (int i = 0; i < families.size(); i++) { 
 			Family family = families.get(i); 
 			String marry = family.getMarriageDate(); 
 			if(Sprint1_Yang.validateDate(marry)) {
 				System.out.println("ERROR: FAMILY: US01: " + family.getId() + ": " + "Marriage date " + marry + " occurs in the future");
 			}

 			String divorce = family.getDivorceDate(); 
 			if (Sprint1_Yang.validateDate(divorce)) { 
 				System.out.println("ERROR: FAMILY: US01: " + family.getId() + ": " + "Divorce date " + divorce + " occurs in the future"); 
 			} 
 		} 
 	} 
}
