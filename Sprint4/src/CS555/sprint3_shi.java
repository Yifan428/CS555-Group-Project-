package CS555;

import java.util.ArrayList;
import java.util.List;

public class sprint3_shi {
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
	
	public static List<Individual> US10(List<Individual> allIndividuals, List<Family> allFamilies) {
		List<Individual> tempIndividuals = new ArrayList<Individual>();		
		ArrayList<String> tempId = new ArrayList<String>();

		
		for (Family fam : allFamilies) {
			tempId.add(fam.getHusbandId());
			tempId.add(fam.getWifeId());
		}
	
		for (Individual indi : allIndividuals) {
			int indiage = Integer.parseInt(indi.getAge());
			for (String tId : tempId) {
				if(tId == null)
					continue;
				if (tId.equals(indi.getId())&&indi.isAlive().equals("True") && indiage <= 14) {
					tempIndividuals.add(indi);
				}
			}
		}
		earseDuplicate(tempIndividuals);
		
		return tempIndividuals;

	}
	
	public static List<Individual> US12(List<Individual> allIndividuals, List<Family> allFamilies) {
		List<Individual> tempIndividuals = new ArrayList<Individual>();	
		List<Family> tempFamilies1 = new ArrayList<Family>();
		List<Family> tempFamilies2 = new ArrayList<Family>();
		ArrayList<String> tempIddie = new ArrayList<String>();
		List<Individual> tempIndividualsout = new ArrayList<Individual>();
		//Find all families which have children return = this families
		for(Family fam : allFamilies) {
			ArrayList<String> tempId = new ArrayList<String>();
			if(fam.getChildrenname()!=null) {
				for(String name: fam.getChildrenname()) {
					tempId.add(name.replaceAll("@", "").trim());
				}
				fam.setChildrename(tempId);
				tempFamilies1.add(fam);
			}
		}
		//Set husband and wife age in this families
		for(Family fam : tempFamilies1) {
			for(Individual indi : allIndividuals) {
				if(indi.getId().equals(fam.getHusbandId())) {
					fam.setHusbandAge(Integer.parseInt(indi.getAge()));
					tempFamilies2.add(fam);
				}
				else if(indi.getId().equals(fam.getWifeId())) {
					fam.setWifeAge(Integer.parseInt(indi.getAge()));
					tempFamilies2.add(fam);
				}
			}
		}
	
		for(Family fam : tempFamilies2) {
			for(String childid : fam.getChildrenname()) {
				for(Individual indi : allIndividuals) {
					if(indi.getId().equals(childid)) {
						if(indi.getAge().equals("NA") == false){
							if((fam.getHusbandAge() - Integer.parseInt(indi.getAge()) > 80)||(fam.getWifeAge() - Integer.parseInt(indi.getAge()) > 60)) {
								tempIndividualsout.add(indi);
							}
						}
						
					}
			}
			}
		
		}
		
		earseDuplicate(tempIndividualsout);
		return tempIndividualsout;	
	
	}
	
	public static ArrayList<String> earseDuplicateid(ArrayList<String> tempids) {

		for (int i = 0; i < tempids.size() - 1; i++) {
			for (int j = tempids.size() - 1; j > i; j--) {
				if (tempids.get(j).equals(tempids.get(i))) {
					tempids.remove(j);
				}
			}
		}
		return tempids;
	}
	
	
	
	public static void printUS10(List<Individual> tempIndividuals) {
		for (Individual currentIndv : tempIndividuals) {
		System.out.println("ERROR: FAMILY: US10: " + currentIndv.getId() + ": " + currentIndv.getName() + "is married under 14");
	}
}
	public static void printUS12(List<Individual> tempIndividuals) {
		
		
		System.out.println("US12	 List US 12 Parents not too old in a GEDCOM file  test");
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
	
}
