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
				if (tId.equals(indi.getId())&&indi.isAlive().equals("True") && indiage <= 14) {
					tempIndividuals.add(indi);
				}
			}
		}
		earseDuplicate(tempIndividuals);

	

		return tempIndividuals;

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
	
}
