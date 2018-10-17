package CS555;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Storytest_YYC {
	String pathname = "Test_Family_Team wisdom of Mr Toad.ged"; 
	File filename = new File(pathname);
    //Project03.printINDIAndFAMTables(filename);
    List<Individual> allIndividuals = Project03.getIndividuals();
    List<Family> allFamilies = Project03.getFamilies();  	
    

	public static void main(String[] args) {

		String pathname = "Test_Family_Team wisdom of Mr Toad.ged"; 
		
		File filename = new File(pathname);
        Project03.printINDIAndFAMTables(filename);
	}
	
	@Test
	//Test number of not Married name list    
	public void testnumber31() {
		List<Individual> allIndividuals31 = read.getIndividuals();
        List<Family> allFamilies31 = read.getFamilies();    
      //Test number of not Married name list        
		 ArrayList<String> testnamenumber31 = new ArrayList<String>();
				for (int i = 0; i < Story_YongchangYao.US31(allIndividuals31, allFamilies31).size(); i++) {
			Individual currentIndv = Story_YongchangYao.US31(allIndividuals31, allFamilies31).get(i);
			testnamenumber31.add(currentIndv.getName());		
		}
				int expectnumber = 3;
				//System.out.println("bbbbaaaaa" + testnamenumber31.size());
				assertEquals(expectnumber,  testnamenumber31.size());
		
	}
        
  
	
	@Test
	//Test not Married name list   
	public void testnamelist31() {
		String pathname = "Test_Family_Team wisdom of Mr Toad.ged"; 
		File filename = new File(pathname);
		//read.readfile(filename);
        List<Individual> allIndividuals31 = read.getIndividuals();
        List<Family> allFamilies31 = read.getFamilies();    
		
      //Test not Married name list        
		 ArrayList<String> testname31 = new ArrayList<String>();
				for (int i = 0; i < Story_YongchangYao.US31(allIndividuals31, allFamilies31).size(); i++) {
			Individual currentIndv = Story_YongchangYao.US31(allIndividuals31, allFamilies31).get(i);
			testname31.add(currentIndv.getName());		
		}
				//System.out.println("aaaaa" + testname31.size());
				//System.out.println(testname31);
		String expectnamelist = "[Dongping /Yao/ , Wei /Yao/ , Yuping /Tian/ ]";	
		assertEquals(expectnamelist,  testname31.toString());
	}
	
	@Test
	//Test number of all living married people 
	public void testnumber30() {
		String pathname = "Test_Family_Team wisdom of Mr Toad.ged"; 
		File filename = new File(pathname);
		read.readfile(filename);
        List<Individual> allIndividuals = read.getIndividuals();
        List<Family> allFamilies = read.getFamilies();   
     
		 ArrayList<String> testnamenumber30 = new ArrayList<String>();
				for (int i = 0; i < Story_YongchangYao.US30(allIndividuals, allFamilies).size(); i++) {
			Individual currentIndv = Story_YongchangYao.US30(allIndividuals, allFamilies).get(i);
			testnamenumber30.add(currentIndv.getName());		
		}
				int expectnumber = 13;
				//System.out.println("bbbbaaaaa" + testnamenumber31.size());
				assertEquals(expectnumber,  testnamenumber30.size());	
	}	
	
	@Test
	//Test maximal age of all living married people  
	public void testmaximalage30() {
		List<Individual> allIndividuals30 = read.getIndividuals();
        List<Family> allFamilies30 = read.getFamilies();    
      
		 ArrayList<String> testnamenumber30 = new ArrayList<String>();
				for (int i = 0; i < Story_YongchangYao.US30(allIndividuals30, allFamilies30).size(); i++) {
			Individual currentIndv = Story_YongchangYao.US30(allIndividuals30, allFamilies30).get(i);
			testnamenumber30.add(currentIndv.getAge());		
		}
				int expectage = 83;
//				System.out.println("bbbbaaaaa" + testnamenumber30);
//				System.out.println(Collections.max(testnamenumber30));
				int age = Integer.parseInt(Collections.max(testnamenumber30));
				assertEquals(expectage,  age);	
	}	
	@Test
	//Test minimum age of all not married people  
		public void testminage31() {
			List<Individual> allIndividuals30 = read.getIndividuals();
	        List<Family> allFamilies30 = read.getFamilies();    
	      
			 ArrayList<String> testnamenumber30 = new ArrayList<String>();
					for (int i = 0; i < Story_YongchangYao.US31(allIndividuals30, allFamilies30).size(); i++) {
				Individual currentIndv = Story_YongchangYao.US31(allIndividuals30, allFamilies30).get(i);
				testnamenumber30.add(currentIndv.getAge());		
			}
					int expectage = 48;
//					System.out.println("bbbbaaaaa" + testnamenumber30);
//					System.out.println(Collections.max(testnamenumber30));
					int age = Integer.parseInt(Collections.min(testnamenumber30));
					assertEquals(expectage,  age);	
		}
	
	@Test
	//Test minimum age of all not married people  
		public void testminage32() {
		List<Individual> allIndividuals30 = read.getIndividuals();
        List<Family> allFamilies30 = read.getFamilies();    
      
		 ArrayList<String> testnamenumber30 = new ArrayList<String>();
				for (int i = 0; i < Story_YongchangYao.US33(allIndividuals30, allFamilies30).size(); i++) {
			Individual currentIndv = Story_YongchangYao.US33(allIndividuals30, allFamilies30).get(i);
			testnamenumber30.add(currentIndv.getAge());		
		}
				int expec = 2;
//				System.out.println("bbbbaaaaa" + testnamenumber30);
//				System.out.println(Collections.max(testnamenumber30));
				int size = Story_YongchangYao.US32(allIndividuals30, allFamilies30).size();
				assertEquals(expec,  size);	
		}	
	
	@Test
	//Test minimum age of all not married people  
		public void testminage33() {
			List<Individual> allIndividuals30 = read.getIndividuals();
	        List<Family> allFamilies30 = read.getFamilies();    
	      
			 ArrayList<String> testnamenumber30 = new ArrayList<String>();
					for (int i = 0; i < Story_YongchangYao.US33(allIndividuals30, allFamilies30).size(); i++) {
				Individual currentIndv = Story_YongchangYao.US33(allIndividuals30, allFamilies30).get(i);
				testnamenumber30.add(currentIndv.getAge());		
			}
					int expec = 1;
//					System.out.println("bbbbaaaaa" + testnamenumber30);
//					System.out.println(Collections.max(testnamenumber30));
					int size = Story_YongchangYao.US33(allIndividuals30, allFamilies30).size();
					assertEquals(expec,  size);	
		}	
	
}
