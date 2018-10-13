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
	
}