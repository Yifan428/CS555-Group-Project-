package CS555;

import java.util.ArrayList;
import java.util.List;

public class sprint4_shi {

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
	
	public static List<Family> US04(List<Family> allFamilies) {
		List<Family> tempFamilies = new ArrayList<Family>();
		ArrayList<String> tempId = new ArrayList<String>();

		for (Family fam : allFamilies) {
			if(!fam.getDivorceDate().equals("NA")&&!fam.getMarriageDate().equals("NA")) {
			int famage = Integer.parseInt(fam.getmarryTodivorceage());
			if(famage < 0) {
				tempFamilies.add(fam);
			}
		}
		}
		return tempFamilies;
	}
	
	public static List<Individual> US06(List<Individual> allIndividuals, List<Family> allFamilies) {
		List<Individual> tempIndividuals = new ArrayList<Individual>();
		List<Family> tempFamilies = new ArrayList<Family>();
		ArrayList<String> tempDivorceId = new ArrayList<String>();
		ArrayList<String> tempId = new ArrayList<String>();

		for (Individual indi : allIndividuals) {
			for(Family fam : allFamilies) {					
				if(fam.getHusbandId()==null||fam.getWifeId()==null)
					continue;
				if(fam.getHusbandId().equals(indi.getId())||fam.getWifeId().equals(indi.getId())) {
					indi.setDivorceDate(fam.getDivorceDate());
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
	
	
	public static void printUS04(List<Family> tempFamilies) {
		for (Family fam : tempFamilies) {
			System.out.print("LINE "+ function_z.findwhichline(fam.getId())+ ": ");			
			System.out.println("ERROR: FAMILIY: US04: " + fam.getId() + ": marriage date " + fam.getMarriageDate()+ "occurs after divorce date " + fam.getDivorceDate() );
		}
	}
	
	public static void printUS06(List<Individual> tempIndividuals) {
		for (Individual currentIndv : tempIndividuals) {
				if(!currentIndv.getDivorceDate().equals("NA")&&!currentIndv.getDeathDate().equals("NA")) {
				int indidivTodeath = Integer.parseInt(currentIndv.getdivorceTodeathAge());
				if(indidivTodeath < 0) {
					System.out.print("LINE "+ function_z.findwhichline(currentIndv.getId())+ ": ");
					System.out.println("ERROR: Family: US06: " + currentIndv.getId() + ": divorce date " + currentIndv.getDivorceDate()+ " occurs after death date " + currentIndv.getDeathDate());
				}
			}
		}
	}

}
