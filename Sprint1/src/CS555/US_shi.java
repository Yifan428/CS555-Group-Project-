package CS555;

import java.util.ArrayList;
import java.util.List;

public class US_shi {

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

	//Death before brith
	public static List<Individual> US03(List<Individual> allIndividuals) {
		List<Individual> tempIndividuals = new ArrayList<Individual>();		
		ArrayList<String> tempId = new ArrayList<String>();


		for (Individual indi : allIndividuals) {
			//for (String tId : tempId) {
			//if (tId.equals(indi.getId())&&indi.isAlive().equals("True")) {
			int indiage = Integer.parseInt(indi.getAge());
			if(indiage <= 0) {
				tempIndividuals.add(indi);
			}
		}
		return tempIndividuals;
	}

	//US02 Married before birth

	public static List<Individual> US02(List<Individual> allIndividuals, List<Family> allFamilies) {
		//public static ArrayList<String> US02(List<Individual> allIndividuals, List<Family> allFamilies) {
		List<Individual> tempIndividuals = new ArrayList<Individual>();
		List<Family> tempFamilies = new ArrayList<Family>();
		ArrayList<String> tempMarriedId = new ArrayList<String>();
		ArrayList<String> tempId = new ArrayList<String>();
		//First get all individuals' ids
		for (Individual indi : allIndividuals) {			
			tempId.add(indi.getId());			
		}
		//Then get all family member's id
		for (Family fam : allFamilies) {
			tempMarriedId.add(fam.getHusbandId());
			tempMarriedId.add(fam.getWifeId());
		}
		//Compare this two id arraies to get a new array
		ArrayList<String> tempDel = new ArrayList<String>();

		for (String tId : tempId) {
			for (String tmarriedId : tempMarriedId) {
				if (tId.equals(tmarriedId)) {
					tempDel.add(tId);
				}
			}
		}

		for (Individual indi : allIndividuals) {
			for (String tmarriedId : tempMarriedId) {
				if (indi.getId().equals(tmarriedId)) {
					tempIndividuals.add(indi);
				}
			}
		}

		for (Individual indit : tempIndividuals) {
			for (Family famt : allFamilies) {
				if (indit.getId().equals(famt.getHusbandId())||indit.getId().equals(famt.getWifeId())) {
					indit.setMarriageDate(famt.getMarriageDate());
				}

			}

		}

		earseDuplicateid(tempDel);
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

	public static void printUS03(List<Individual> tempIndividuals) {
		for (Individual currentIndv : tempIndividuals) {
			System.out.println("ERROR: INDIVIDUAL: US03: " + currentIndv.getId() + ": birthday " + currentIndv.getBirthDate()+ "occurs after death date " + currentIndv.getDeathDate());
		}
	}

	public static void printUS02(List<Individual> tempIndividuals) {
		for (Individual currentIndv : tempIndividuals) {
			if(currentIndv.getmarrAge()!="NA") {
				int indimarr = Integer.parseInt(currentIndv.getmarrAge());
				if(indimarr <= 0) {
					System.out.println("ERROR: Family: US02: " + currentIndv.getId() + ": birthday " + currentIndv.getBirthDate()+ " occurs after marriage date " + currentIndv.getMarriageDate());
				}
			}
		}
	}
}