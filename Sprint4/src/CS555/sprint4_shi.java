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
		//First get all individuals' ids
//		for (Individual indi : allIndividuals) {			
//			tempId.add(indi.getId());			
//		}
//		//Then get all family member's id
//		for (Family fam : allFamilies) {
//			tempDivorceId.add(fam.getHusbandId());
//			tempDivorceId.add(fam.getWifeId());
//		}
//		//Compare this two id arraies to get a new array
//		ArrayList<String> tempDel = new ArrayList<String>();
//
//		for (String tId : tempId) {
//			for (String tdivorceId : tempDivorceId) {
//				if (tId.equals(tdivorceId)) {
//					tempDel.add(tId);
//				}
//			}
//		}
//
//		for (Individual indi : allIndividuals) {
//			for (String tdivorceId : tempDivorceId) {
//				if (indi.getId().equals(tdivorceId)) {
//					tempIndividuals.add(indi);
//				}
//			}
//		}

		for (Individual indi : allIndividuals) {
			for(Family fam : allFamilies) {					
				if(fam.getHusbandId()==null||fam.getWifeId()==null)
					continue;
//				if(!fam.getMarriageDate().equals("NA")&&fam.getDivorceDate().equals("NA")) {
				if(fam.getHusbandId().equals(indi.getId())||fam.getWifeId().equals(indi.getId())) {
					indi.setDivorceDate(fam.getDivorceDate());
//					if(LocalDate.now().until(indi.Getmarrytime(), ChronoUnit.DAYS)<30&&LocalDate.now().until(indi.Getmarrytime(), ChronoUnit.DAYS)>=0){
//					indi.setdaytomarryanni((int)(LocalDate.now().until(indi.Getmarrytime(), ChronoUnit.DAYS)));	
//					tempIndividuals.add(indi);
//					}
					tempIndividuals.add(indi);
				}
//				else if(fam.getWifeId().equals(indi.getId())) {
//					indi.setMarriageDate(fam.getMarriageDate());
//					if(!indi.getMarriageDate().equals("NA")&&LocalDate.now().until(indi.Getmarrytime(), ChronoUnit.DAYS)<30&&LocalDate.now().until(indi.Getmarrytime(), ChronoUnit.DAYS)>=0) {
//					indi.setdaytomarryanni((int)(LocalDate.now().until(indi.Getmarrytime(), ChronoUnit.DAYS)));	
//					tempIndividuals.add(indi);	
//				}					
//			}
		}
			}
		//}

		//earseDuplicateid(tempDel);
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
			//System.out.println("LINE----------- "+ currentIndv.getName() + currentIndv.getDivorceDate());
	}

}
