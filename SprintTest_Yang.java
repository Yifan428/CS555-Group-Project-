package proj_04;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;


public class SprintTest_Yang {
	
	private Sprint1_Yang gr;
	List<Family> families = new ArrayList<Family>();
	List<Individual> individual = new ArrayList<Individual>();
	
	public SprintTest_Yang() {
		gr = new Sprint1_Yang();
		File filename = new File("D:\\eclipse-workspace\\CS555\\src\\proj_04\\Test_Family_Team wisdom of Mr Toad.ged");
        Sprint1_Yang.printINDIAndFAMTables(filename);
	}
	
    @Test
    public void testUserStory22() {
    	assertTrue("should be true", gr.uniqueId(Sprint1_Yang.ids));
    }
    
    @Test
 	public void testUserStory01ForIndividual() { 
 		List<Individual> individuals = Sprint1_Yang.allIndividuals; 
 		for (int i = 0; i < individuals.size(); i++) { 
 			Individual individual = individuals.get(i); 
 			String birthday = individual.getBirthDate(); 
 			assertTrue("ERROR: INDIVIDUAL: US01: " + individual.getId() + ": " + "Birthday " + birthday + " occurs in the future", gr.validateDate(birthday)); 
 			String death = individual.getDeathDate(); 
 			if (!death.equals("NA")) { 
 				assertTrue("ERROR: INDIVIDUAL: US01: " + individual.getId() + ": " + "Death " + death + " occurs in the future", gr.validateDate(death)); 
 			} 
 		} 
 	} 
 	 
 	@Test 
	public void testUserStory01ForFamily() { 
 		List<Family> families = Sprint1_Yang.allFamilies; 
 		for (int i = 0; i < families.size(); i++) { 
 			Family family = families.get(i); 
 			String marry = family.getMarriageDate(); 
 			assertTrue("ERROR: FAMILY: US01: " + family.getId() + ": " + "Marriage date " + marry + " occurs in the future", gr.validateDate(marry)); 
 			String divorce = family.getDivorceDate(); 
 			if (!divorce.equals("NA")) { 
				assertTrue("ERROR: FAMILY: US01: " + family.getId() + ": " + "Divorce date " + divorce + " occurs in the future", gr.validateDate(divorce)); 
 			} 
 		} 
 	} 
}
