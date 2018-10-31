package CS555;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import javax.print.attribute.Size2DSyntax;

import org.junit.Test;


public class Story_YongchangYao {
	public static List<Individual> earseDuplicate(List<Individual> tempIndividuals) {

		for (int i = 0; i < tempIndividuals.size() - 1; i++) {
			for (int j = tempIndividuals.size() - 1; j > i; j--) {
				if (tempIndividuals.get(j).equals(tempIndividuals.get(i))) {
					tempIndividuals.remove(j);
				}
			}
		}
		return tempIndividuals;
	}

//	public static void printIndividuals(List<Individual> tempIndividuals) {
//		for (Individual currentIndv : tempIndividuals) {
//			
//
//			System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n",
//					currentIndv.getId(), currentIndv.getName(), currentIndv.getGender(), currentIndv.getBirthDate(),
//					currentIndv.getAge(), currentIndv.isAlive(), currentIndv.getDeathDate(),
//					currentIndv.getChildFamilyIdsAsString(), currentIndv.getSpouseFamilyIdsAsString());
//		}
//	}


	public static List<Individual> US30(List<Individual> allIndividuals, List<Family> allFamilies) {
		List<Individual> tempIndividuals = new ArrayList<Individual>();		
		ArrayList<String> tempId = new ArrayList<String>();

		for (Family fam : allFamilies) {
			tempId.add(fam.getHusbandId());
			tempId.add(fam.getWifeId());
		}
	
		for (Individual indi : allIndividuals) {
			for (String tId : tempId) {
				if (tId.equals(indi.getId())&&indi.isAlive().equals("True")) {
					tempIndividuals.add(indi);
				}
			}
		}
		earseDuplicate(tempIndividuals);

	

		return tempIndividuals;

	}

	// US31 List living single List all living people over 30 who have never been
	// married in a GEDCOM file
	public static List<Individual> US31(List<Individual> allIndividuals, List<Family> allFamilies) {
		List<Individual> tempIndividuals = new ArrayList<Individual>();
		List<Family> tempFamilies = new ArrayList<Family>();
		ArrayList<String> tempMarriedId = new ArrayList<String>();
		ArrayList<String> tempId = new ArrayList<String>();

		for (Individual indi : allIndividuals) {
			if (Integer.valueOf(indi.getAge()) > 30) {
				tempId.add(indi.getId());
			}
		}

		for (Family fam : allFamilies) {
			tempMarriedId.add(fam.getHusbandId());
			tempMarriedId.add(fam.getWifeId());
		}

		ArrayList<String> tempDel = new ArrayList<String>();

		for (String tId : tempId) {
			for (String tmarriedId : tempMarriedId) {
				if (tId.equals(tmarriedId)) {
					tempDel.add(tId);
				}
			}
		}
		for (String tdId : tempDel) {
			tempId.remove(tdId);
		}

		for (String tId : tempId) {
			for (Individual indi : allIndividuals) {
				if (tId.equals(indi.getId())&&indi.isAlive().equals("True")) {
					tempIndividuals.add(indi);
				}
			}
		}
		earseDuplicate(tempIndividuals);

		ArrayList<String> tempremoveId = new ArrayList<String>();

		for (Individual indi : tempIndividuals) {
			if(!indi.isAlive().equals("True")) {
				tempremoveId.add(indi.getId());
				tempIndividuals.remove(indi);
			}
		}		
		return tempIndividuals;		
	}
	
	
	//US 32 List Multiple births
	
	public static List<Individual> US32(List<Individual> allIndividuals, List<Family> allFamilies) {
		List<Individual> tempIndividuals = new ArrayList<Individual>();		
		ArrayList<String> tempId = new ArrayList<String>();

		for (Family fam : allFamilies) {
			tempId.add(fam.getHusbandId());
			tempId.add(fam.getWifeId());
		}	
		for (Individual indi : allIndividuals) {
			for (Individual indi2 : allIndividuals) {
				if (indi.getBirthDate().equals(indi2.getBirthDate())&&indi.getChildFamilyIdsAsString().equals(indi2.getChildFamilyIdsAsString())
						&&(indi.getName().equals(indi2.getName())==false)) {
					tempIndividuals.add(indi);
					
				}
			}
		}
		earseDuplicate(tempIndividuals);
		return tempIndividuals;
	}
	
	
	//US 33 List Recent births
	
	public static List<Individual> US33(List<Individual> allIndividuals, List<Family> allFamilies) {
		List<Individual> tempIndividuals = new ArrayList<Individual>();		
		ArrayList<String> tempId = new ArrayList<String>();

		for (Individual indi : allIndividuals) {							 
    	if(indi.Getbrithtime().until(LocalDate.now(), ChronoUnit.DAYS)<30&&indi.Getbrithtime().until(LocalDate.now(), ChronoUnit.DAYS)>=0) {
    		tempIndividuals.add(indi);
			}
		}
		earseDuplicate(tempIndividuals);
		return tempIndividuals;
	}	
	
	
	//US 36 List Recent death
	
	public static List<Individual> US36(List<Individual> allIndividuals, List<Family> allFamilies) {
		List<Individual> tempIndividuals = new ArrayList<Individual>();		
		ArrayList<String> tempId = new ArrayList<String>();

		for (Individual indi : allIndividuals) {
			if(!indi.getDeathDate().equals("NA")) {
				if(indi.Getdeadtime().until(LocalDate.now(), ChronoUnit.DAYS)<30&&indi.Getdeadtime().until(LocalDate.now(), ChronoUnit.DAYS)>=0) {
					tempIndividuals.add(indi);
				}
			}
		}
		earseDuplicate(tempIndividuals);
		return tempIndividuals;
	}	
	
	
	//US 37 List Recent survivors	
	public static List<Individual> US37(List<Individual> allIndividuals, List<Family> allFamilies) {
		List<Individual> tempIndividuals = new ArrayList<Individual>();	
		List<Family> tempFamilies = new ArrayList<Family>();
		ArrayList<String> tempIddie = new ArrayList<String>();
		List<Individual> tempIndividualsout = new ArrayList<Individual>();	
		
		for(Family fam : allFamilies) {
			ArrayList<String> tempId = new ArrayList<String>();
			if(fam.getChildrenname()!=null) {
				for(String name: fam.getChildrenname()) {
					tempId.add(name.replaceAll("@", "").trim());
				}
				fam.setChildrename(tempId);
				tempFamilies.add(fam);
			}
			
				
			}
		for (Individual indi : allIndividuals) {
			if(!indi.getDeathDate().equals("NA")) {
				if(indi.Getdeadtime().until(LocalDate.now(), ChronoUnit.DAYS)<30&&indi.Getdeadtime().until(LocalDate.now(), ChronoUnit.DAYS)>=0) {
					tempIndividuals.add(indi);
				}
			}
		}
		
		for (Individual indi : tempIndividuals) {
			for(Family fam : allFamilies) {
				if(fam.getHusbandId().equals(indi.getId())) {
					tempIddie.add(fam.getWifeId());
					tempIddie.addAll(fam.getChildrenname());
				}
				else if(fam.getWifeId().equals(indi.getId())) {
					tempIddie.add(fam.getHusbandId());
					tempIddie.addAll(fam.getChildrenname());
				}
				
			}
		}
		

//		for (Individual indi : tempIndividuals) {
//			for(Family fam : tempFamilies) {
//				if(fam.getHusbandId().equals(indi.getId())) {
//					tempIddie.add(fam.getWifeId());
//				}
//				else if(fam.getWifeId().equals(indi.getId())) {
//					tempIddie.add(fam.getHusbandId());
//				}
//				
//			}
//		}
//		
		for (Individual indi : allIndividuals) {
			for(String id : tempIddie) {
				if(indi.getId().contentEquals(id)&&indi.isAlive().equals("True")) {
					tempIndividualsout.add(indi);
				}
			}
			
		}
		earseDuplicate(tempIndividualsout);
		
		return tempIndividualsout;
	}
	
	

	public static void printUS30(List<Individual> tempIndividuals) {
		
			
			System.out.println("US30	 List living married	List all living married people in a GEDCOM file  test");
			System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", "----------",
					"-------------------------", "-------", "------------", "-----", "-------", "------------",
					"--------------------", "--------------------");
			System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", "ID", "Name",
					"Gender", "Birthday", "Age", "Alive", "Death", "Child", "Spouse");
			System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", "----------",
					"-------------------------", "-------", "------------", "-----", "-------", "------------",
					"--------------------", "--------------------");			
			for (Individual currentIndv : tempIndividuals) {
			System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n",
					currentIndv.getId(), currentIndv.getName(), currentIndv.getGender(), currentIndv.getBirthDate(),
					currentIndv.getAge(), currentIndv.isAlive(), currentIndv.getDeathDate(),
					currentIndv.getChildFamilyIdsAsString(), currentIndv.getSpouseFamilyIdsAsString());
		}
	}
	
	public static void printUS31(List<Individual> tempIndividuals) {
		System.out.println(
				"US31 List living single	List all living people over 30 who have never been married in a GEDCOM file ");
		System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", "----------",
				"-------------------------", "-------", "------------", "-----", "-------", "------------",
				"--------------------", "--------------------");
		System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", "ID", "Name",
				"Gender", "Birthday", "Age", "Alive", "Death", "Child", "Spouse");
		System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", "----------",
				"-------------------------", "-------", "------------", "-----", "-------", "------------",
				"--------------------", "--------------------");
		for (int i = 0; i < tempIndividuals.size(); i++) {
			Individual currentIndv = tempIndividuals.get(i);
			System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n",
					currentIndv.getId(), currentIndv.getName(), currentIndv.getGender(), currentIndv.getBirthDate(),
					currentIndv.getAge(), currentIndv.isAlive(), currentIndv.getDeathDate(),
					currentIndv.getChildFamilyIdsAsString(), currentIndv.getSpouseFamilyIdsAsString());
			
		}
	}	
	
	public static void printUS32(List<Individual> tempIndividuals) {
		System.out.println(
				"US32 List all Multiple births in a GEDCOM file ");
		System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", "----------",
				"-------------------------", "-------", "------------", "-----", "-------", "------------",
				"--------------------", "--------------------");
		System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", "ID", "Name",
				"Gender", "Birthday", "Age", "Alive", "Death", "Child", "Spouse");
		System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n", "----------",
				"-------------------------", "-------", "------------", "-----", "-------", "------------",
				"--------------------", "--------------------");
		for (int i = 0; i < tempIndividuals.size(); i++) {
			Individual currentIndv = tempIndividuals.get(i);
			System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n",
					currentIndv.getId(), currentIndv.getName(), currentIndv.getGender(), currentIndv.getBirthDate(),
					currentIndv.getAge(), currentIndv.isAlive(), currentIndv.getDeathDate(),
					currentIndv.getChildFamilyIdsAsString(), currentIndv.getSpouseFamilyIdsAsString());
			
		}
	}	
	
	public static void printUS33(List<Individual> tempIndividuals) {
		System.out.println(
				"US33 List all Recent births <30 days in a GEDCOM file ");
		System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|%10$-12s|\n", "----------",
				"-------------------------", "-------", "------------", "-----", "-------", "------------",
				"--------------------", "--------------------","------------");
		System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|%10$-12s|\n", "ID", "Name",
				"Gender", "Birthday", "Age", "Alive", "Death", "Child", "Spouse","Daysfrombrith");
		System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|%10$-12s|\n", "----------",
				"-------------------------", "-------", "------------", "-----", "-------", "------------",
				"--------------------", "--------------------","------------");
		for (int i = 0; i < tempIndividuals.size(); i++) {
			Individual currentIndv = tempIndividuals.get(i);
			System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|%10$-12s|\n",
					currentIndv.getId(), currentIndv.getName(), currentIndv.getGender(), currentIndv.getBirthDate(),
					currentIndv.getAge(), currentIndv.isAlive(), currentIndv.getDeathDate(),
					currentIndv.getChildFamilyIdsAsString(), currentIndv.getSpouseFamilyIdsAsString(),currentIndv.Getdaysfrombrith());
			
		}
	}	
	
	public static void printUS36(List<Individual> tempIndividuals) {
		System.out.println(
				"US36 List all Recent deaths <30 days in a GEDCOM file ");
		System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|%10$-12s|\n", "----------",
				"-------------------------", "-------", "------------", "-----", "-------", "------------",
				"--------------------", "--------------------","------------");
		System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|%10$-12s|\n", "ID", "Name",
				"Gender", "Birthday", "Age", "Alive", "Death", "Child", "Spouse","Daysfromdeath");
		System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|%10$-12s|\n", "----------",
				"-------------------------", "-------", "------------", "-----", "-------", "------------",
				"--------------------", "--------------------","------------");
		for (int i = 0; i < tempIndividuals.size(); i++) {
			Individual currentIndv = tempIndividuals.get(i);
			System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|%10$-12s|\n",
					currentIndv.getId(), currentIndv.getName(), currentIndv.getGender(), currentIndv.getBirthDate(),
					currentIndv.getAge(), currentIndv.isAlive(), currentIndv.getDeathDate(),
					currentIndv.getChildFamilyIdsAsString(), currentIndv.getSpouseFamilyIdsAsString(),currentIndv.Getdaysfromdeath());
			
		}
	}	
	
	public static void printUS35(List<Family> tempFamilies) {
		System.out.println("Families");
    	System.out.format("|%1$-10s|%2$-12s|%3$-12s|%4$-5s|%5$-25s|%6$-10s|%7$-25s|%8$-20s|\n", 
    			"----------", "------------", "------------", "----------", "-------------------------", "----------", "-------------------------", "--------------------");
    	
    	
    	System.out.format("|%1$-10s|%2$-12s|%3$-12s|%4$-5s|%5$-25s|%6$-10s|%7$-25s|%8$-20s|\n", 
    			"ID", "Married", "Divorced", "Husband ID", "Husband Name", "Wife ID", "Wife Name", "Children");
    	System.out.format("|%1$-10s|%2$-12s|%3$-12s|%4$-5s|%5$-25s|%6$-10s|%7$-25s|%8$-20s|\n", 
    			"----------", "------------", "------------", "----------", "-------------------------", "----------", "-------------------------", "--------------------");
		for (int i = 0; i < tempFamilies.size(); i++) {
			Family currentfam = tempFamilies.get(i);
//			System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|%10$-12s|\n",
//					currentIndv.getId(), currentIndv.getName(), currentIndv.getGender(), currentIndv.getBirthDate(),
//					currentIndv.getAge(), currentIndv.isAlive(), currentIndv.getDeathDate(),
//					currentIndv.getChildFamilyIdsAsString(), currentIndv.getSpouseFamilyIdsAsString(),currentIndv.Getdaysfromdeath());

	    	//for(Family fam: allFamilies) {
	    		System.out.format("|%1$-10s|%2$-12s|%3$-12s|%4$-10s|%5$-25s|%6$-10s|%7$-25s|%8$-20s|\n", 
	    				currentfam.getId(), currentfam.getMarriageDate() == null ? "NA" : currentfam.getMarriageDate(), currentfam.getDivorceDate() == null ? "NA" : currentfam.getDivorceDate(), currentfam.getHusbandId(),
	    						currentfam.getHusbandName(),currentfam.getWifeId(), currentfam.getWifeName(),currentfam.getChildrenNameAsString());
//	    	if(fam.getChildrenname().contains("@I1@")) {
//	    		System.out.println("My home");
//	    		
//	    	}
	    	}
	    	System.out.format("|%1$-10s|%2$-12s|%3$-12s|%4$-10s|%5$-25s|%6$-10s|%7$-25s|%8$-20s|\n", 
	    			"----------", "------------", "------------", "----------", "-------------------------", "----------", "-------------------------", "--------------------");
		}
		
	
	public static void printUS37(List<Individual> tempIndividuals) {
		System.out.println(
				"US37 List all living spouses and descendants of people in a GEDCOM file who died in the last 30 days");
		System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|%10$-12s|\n", "----------",
				"-------------------------", "-------", "------------", "-----", "-------", "------------",
				"--------------------", "--------------------","------------");
		System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|%10$-12s|\n", "ID", "Name",
				"Gender", "Birthday", "Age", "Alive", "Death", "Child", "Spouse","Daysfromdeath");
		System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|%10$-12s|\n", "----------",
				"-------------------------", "-------", "------------", "-----", "-------", "------------",
				"--------------------", "--------------------","------------");
		for (int i = 0; i < tempIndividuals.size(); i++) {
			Individual currentIndv = tempIndividuals.get(i);
			System.out.format("|%1$-10s|%2$-25s|%3$-7s|%4$-12s|%5$-5s|%6$-7s|%7$-12s|%8$-20s|%9$-20s|\n",
					currentIndv.getId(), currentIndv.getName(), currentIndv.getGender(), currentIndv.getBirthDate(),
					currentIndv.getAge(), currentIndv.isAlive(), currentIndv.getDeathDate(),
					currentIndv.getChildFamilyIdsAsString(), currentIndv.getSpouseFamilyIdsAsString());
			
		}
	}	
	
	
}