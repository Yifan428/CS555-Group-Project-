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
		
		//earseDuplicate(tempIndividuals);

	

		return tempIndividuals;

	}
	
	//US02 Married before birth
	
	
	
	
	
	
	public static void printUS03(List<Individual> tempIndividuals) {
		
		
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




	

}
