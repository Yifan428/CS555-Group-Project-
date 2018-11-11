package CS555;


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
		String pathname = "Test_Family_Team wisdom of Mr Toad.ged"; 
		File filename = new File(pathname);
		Sprint3_Yang.printINDIAndFAMTables(filename);
	}
	
	@Test
	public static void testUserStory38(List<Individual> allIndividuals) {
		List<Individual> individuals = allIndividuals;
		for (int i = 0; i < individuals.size(); i++) { 
			Individual individual = individuals.get(i); 
			String birthday = individual.getBirthDate(); 
			if(Sprint3_Yang.getUpcomingBirthday(birthday)) {
				System.out.println("ERROR: INDIVIDUAL: US38: The birthday of " +  individual.getId() +  " occur in the next 30 days");
			}
		}

	}


	@Test 
	public static void testUserStory21(List<Family> allFamilies) { 
		List<Family> families = allFamilies;	
		int num = 0;
		for (int i = 0; i < families.size(); i++) { 
			Family family = families.get(i); 
			String husbandId = family.getHusbandId(); 
			String wifeId = family.getWifeId();
			if(Sprint3_Yang.validateHusGender(husbandId)) {
				System.out.println("ERROR: FAMILY: US21: Husband " + husbandId + " has the wrong gender");
				num = num +1;
			}
			if(Sprint3_Yang.validateWifeGender(wifeId)) {
				System.out.println("ERROR: FAMILY: US21: Wife " + wifeId +  " has the wrong gender");
				num = num +1;
			}
		} 
		if (num == 0) {
			System.out.println("ERROR: FAMILY: US21: There is no wrong gender in family");
		}
	}
	
	@Test 
	public static void testUserStory27(List<Individual> allIndividuals) {
		
			
			System.out.println("US27: Include person's current age when listing individuals");
			System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", "----------",
					"-------------------------", "-------", "------------", "-----", "-------", "------------",
					"--------------------", "--------------------");
			System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", "ID", "Name",
					"Gender", "Birthday", "Age", "Alive", "Death", "Child", "Spouse");
			System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", "----------",
					"-------------------------", "-------", "------------", "-----", "-------", "------------",
					"--------------------", "--------------------");			
			for (Individual currentIndv : allIndividuals) {
			System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n",
					currentIndv.getId(), currentIndv.getName(), currentIndv.getGender(), currentIndv.getBirthDate(),
					currentIndv.getAge(), currentIndv.isAlive(), currentIndv.getDeathDate(),
					currentIndv.getChildFamilyIdsAsString(), currentIndv.getSpouseFamilyIdsAsString());
		}
	}
	
     @Test  
     public static void testUserStory29(List<Individual> allIndividuals) {  
		String ListYes = ""; 
        String ListNo = ""; 
		List<Individual> individuals = allIndividuals;  
 		for (int i = 0; i < individuals.size(); i++) {  
 			Individual individual = individuals.get(i);  
                      if (individual.isAlive()== "False") { 
            	        ListYes = "Y"; 
            	        System.out.println("ERROR: INDIVIDUAL: US29: " + individual.getId() + ": " + "This individual has already deceased");
                       }  else { 
                	ListNo = "Y"; 
                       }       
              }  
        if (ListYes.equals("") || ListNo.equals("") ) { 
        	assertTrue("ERROR: INDIVIDUALS: US29: Listing of all deceased individuals User Story processing is broken " ,true);  
        } 
 	}
		
    @Test
    public static void testUserStory22(List<Individual> allIndividuals, List<Family> allFamilies) {
    	List<Individual> individuals = allIndividuals;
    	List<Family> families = allFamilies;
    	ArrayList<String> IndvID = new ArrayList<>();
    	ArrayList<String> FamID = new ArrayList<>();
    	for (int i = 0; i < individuals.size(); i++) { 
 			Individual individual = individuals.get(i); 
 			String indvID = individual.getId(); 
 			IndvID.add(indvID);
 			if(!Sprint3_Yang.uniqueId(IndvID)) {
 				System.out.println("ERROR: INDIVIDUAL: US22: There are same ID in the Individuals. ");
 				break;
 			}
 		} 
    	for (int j = 0; j < families.size(); j++) { 
    		Family family = families.get(j); 
 			String famID = family.getId(); 
 			FamID.add(famID);
 			if(!Sprint3_Yang.uniqueId(FamID)) {
 				System.out.println("ERROR: Family: US22: There are same ID in the Families. ");
 				break;
 			}
 		} 
    }
    
    @Test
 	public static void testUserStory01(List<Individual> allIndividuals, List<Family> allFamilies) { 
 		List<Individual> individuals = allIndividuals;
 		for (int i = 0; i < individuals.size(); i++) { 
 			Individual individual = individuals.get(i); 
 			String birthday = individual.getBirthDate(); 
 			if(Sprint3_Yang.validateDate(birthday)) {
 				System.out.println("ERROR: INDIVIDUAL: US01: " + individual.getId() + ": " + "Birthday " + birthday + " occurs in the future");
 			}
 
 			String death = individual.getDeathDate(); 
 			if (Sprint3_Yang.validateDate(death)) { 
 				System.out.println("ERROR: INDIVIDUAL: US01: " + individual.getId() + ": " + "DeathDate " + death + " occurs in the future");
 			} 

 		} 
 	
 		List<Family> families = Sprint3_Yang.allFamilies; 
 		for (int i = 0; i < families.size(); i++) { 
 			Family family = families.get(i); 
 			String marry = family.getMarriageDate(); 
 			if(Sprint3_Yang.validateDate(marry)) {
 				System.out.println("ERROR: FAMILY: US01: " + family.getId() + ": " + "Marriage date " + marry + " occurs in the future");
 			}

 			String divorce = family.getDivorceDate(); 
 			if (Sprint3_Yang.validateDate(divorce)) { 
 				System.out.println("ERROR: FAMILY: US01: " + family.getId() + ": " + "Divorce date " + divorce + " occurs in the future"); 
 			} 
 		} 
 	} 
}
