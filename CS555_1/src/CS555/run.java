package CS555;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class run {
	String pathname = "Test_Family_Team wisdom of Mr Toad.ged"; 
	File filename = new File(pathname);
    //Project03.printINDIAndFAMTables(filename);
    List<Individual> allIndividuals = Project03.getIndividuals();
    List<Family> allFamilies = Project03.getFamilies();   

	public static void main(String[] args) {

		String pathname = "Test_Family_Team wisdom of Mr Toad.ged"; 
		
		File filename = new File(pathname);
        Project03.printINDIAndFAMTables(filename);
        
        List<Individual> allIndividuals = Project03.getIndividuals();
        List<Family> allFamilies = Project03.getFamilies();
        //Us from YYC
        Story_YongchangYao.printUS30(Story_YongchangYao.US30(allIndividuals, allFamilies));
        
        Story_YongchangYao.printUS31(Story_YongchangYao.US31(allIndividuals, allFamilies));    
        //Us from SYF   
        US_shi.printUS03(US_shi.US03(allIndividuals));
        //Us from JL
        US_shi.printUS02(US_shi.US02(allIndividuals,allFamilies));
        System.out.println("US 22 Unique IDs: All individual IDs should be unique and all family IDs should be unique");
	SprintTest_Yang.testUserStory22(allIndividuals, allFamilies);
	System.out.println("US 01 Dates before current date: Dates (birth, marriage, divorce, death) should not be after the current date");
	SprintTest_Yang.testUserStory01(allIndividuals, allFamilies);
        //US from YCZ
	function_z.US_test(allFamilies,allIndividuals);
}


}

