package cs5551;

import java.util.Calendar;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.Vector;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	static Family f1=new Family();
	static Family f2=new Family();
	static Family f3=new Family();
	static Family f4=new Family();
	static Family f5=new Family();
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
    	
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
        Calendar cal=Calendar.getInstance();  
		int y=cal.get(Calendar.YEAR);   
		int m=cal.get(Calendar.MONTH);   
		int d=cal.get(Calendar.DATE);
		String s=""+y+"-"+m+"-"+d;
		Individual l = new Individual();
		Individual f = new Individual();
		f.setId("0");
		l.setId("1");
		l.setName("Wang Xiao");
		// String s means the time now.
    	f1.setId("1");
    	f1.setWifeName("Huang gongpin");
    	f1.setHusbandName("Luo Wenpei");
    	f1.setMarriageDate("1970-02-28");
    	f2.setId("2");
    	f2.setWifeName("Xi yangyang");
    	f2.setHusbandName("Hui tailang");
    	f2.setMarriageDate("2970-12-20");
    	f3.setId("3");
    	f3.setWifeName("Ma dongmei");
    	f3.setHusbandName("Xia luote");
    	f3.setMarriageDate("2016-12-22");
    	f4.setId("4");
    	f4.setWifeName("Xia zhu");
    	f4.setHusbandName("Wang duoyu");
    	f4.setMarriageDate("2018-12-04");
    	Vector<Individual> v=new Vector<Individual>();
    	l.gender="Male";
    	v.add(f);
    	v.add(l);
    	f4.childrenId=new Vector<String>();
    	for (int i=0;i<6;i++)
    	f4.childrenId.add("1");
    	System.out.println("US14");
    	fuc_z.check_num(f4);
    	fuc_z.check_male_name(f4, v);
    	System.out.println("US16 male same last name. I set individual l 's last name is 'xiao', but after the check, his lastname be changed to his fater's last name");
    	System.out.println(l.getName());
//    	assertTrue(f1.getMarriageDate().compareTo(s)<=0);
//    	//if Huang gongpin and Luo Wenpei's marrage time currect
//    	assertTrue(f3.getMarriageDate().compareTo("2016-07-22")==0);
//    	//if Xia luote and Ma dongmei marrage in the currect day
//    	assertTrue(!(f4.getMarriageDate().compareTo("2016-07-22")==0));
//    	//if Data overflow from f3 to f4
//    	assertTrue((f2.getMarriageDate().compareTo(s)<=0));
//    	//if Xi yangyang and Hui tailang' marrge time currect.
//    	assertTrue((f2.getMarriageDate().compareTo(s)==0));
    	//When  Marrage time date is bigger than current time, 
    	//will it change to currect time.
    }
}
