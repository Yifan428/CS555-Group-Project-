package CS555;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.xml.crypto.Data;

public class function_z {
	public static void check_male_name(Family f,List<Individual> I)//male same name
	{ 
		if(f.getHusbandName()==null)
			return;
		String name[]=f.getHusbandName().split(" ");
		String failyname=name[name.length-1];
		if(f.childrenId==null)
			return;
		for(int i=0;i<f.childrenId.size();i++)
		{
			String childid = f.childrenId.get(i);
			int num=Integer.parseInt((childid.substring(2,childid.length()-2)));
			if(I.get(num).gender.compareTo("M")==1)
			{
				String sonname;
				String[] namelist;
				sonname=I.get(num).getName();
				namelist=sonname.split(" ");
				if(namelist[namelist.length-1]!=failyname){
					System.out.print("line "+function_z.findwhichline(namelist[namelist.length-1]));
					System.out.println(" ERROR: FAMILY: US16: The F"+f.id+" family's man's last name is not same ");	
					namelist[namelist.length-1]=failyname;
				}
				sonname="";
				for(int x=0;x<namelist.length;x++)
				{
					sonname=sonname+namelist[x];
					if(x!=namelist.length-1){
						sonname=sonname+" ";
					}
				}
				I.get(num).name=sonname;
			}
		}
	}
	public static void check_num(Family f)// children <=5
	{
		if(f.childrenname==null)
			return;
		if(f.childrenname.size()>5) {
			System.out.print("line "+ function_z.findwhichline(f.id));
			System.out.println(" ERROR: FAMILY: US14 The F"+f.id+" family have more than 5 child");
	}
}
	public static int findwhichline(String name) {
		String lineReader = null; 
		String pathname= "Test_Family_Team wisdom of Mr Toad.ged";
		BufferedReader br = null;
		List<String> gem = new ArrayList(); 
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(pathname)));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
//					System.out.println(line);
					gem.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
        	try {
        		if (br != null)br.close();
        		
        	} catch (IOException ex) {
        		ex.printStackTrace();
        	}
        }
		for (int i=0;i<gem.size();i++)
			if (gem.get(i).contains(name))
				return i+1;
		return 0;
}
	// sprint 3
	public static void Reject_illegitimate_dates(List<Family> f, List<Individual> I) {
		for(int i=0;i<I.size();i++) {
			Individual temp = I.get(i);
			if(!function_z.Check_date(temp.birthDate)||!function_z.Check_date(temp.deathDate)) {
				System.out.print("line "+ function_z.findwhichline(temp.id));
				System.out.println(" ERROR: INDIVIDUAL: US42 The "+temp.id+" individual have illegitimate_dates");
			}
		}
		for(int i=0;i<f.size();i++) {
			Family temp = f.get(i);
			if(!function_z.Check_date(temp.marriageDate)||!function_z.Check_date(temp.divorceDate)) {
				System.out.print("line "+ function_z.findwhichline(temp.id));
				System.out.println(" ERROR: FAMILY: US42 The F"+temp.id+" Family have illegitimate_dates");
			}
		}
	}
	public static void Birth_before_marriage_of_parents(Family f,List<Individual> I) {
		if(f.childrenname==null)
			return;
		long devoce = function_z.change_date(f.divorceDate).getTime();
		long marry = function_z.change_date(f.marriageDate).getTime();
		long nine = Long.parseLong("15634800000");
		for(int i=0;i<f.childrenname.size();i++) {
			String childid = f.childrenname.get(i);
			int num=Integer.parseInt((childid.substring(1,childid.length())));
			long birthdate= function_z.change_date(I.get(num-1).birthDate).getTime();
			if(birthdate-devoce>nine) {
				System.out.print("line "+ function_z.findwhichline(I.get(i).id));
				System.out.println(" ERROR: FAMILY: US8 The F"+f.id+" Family have someone birth after device 9 mon");
			}
			if(birthdate>marry) {
				System.out.print("line "+ function_z.findwhichline(I.get(i).id));
				System.out.println(" ERROR: FAMILY: US8 The F"+f.id+" Family have someone birth before marryage");
			}
		}
	}
	public static int change_to_num(String s) {//change month to num
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("JAN", 1);map.put("FEB", 2);map.put("MAR", 3);map.put("APR", 4);map.put("MAY", 5);
		map.put("JUN", 6);map.put("JUL", 7);map.put("AUG", 8);map.put("SEP", 9);map.put("OCT", 10);
		map.put("NOV", 11);map.put("DEC", 12);
		return map.get(s);
	}
	public static Boolean Check_date(String time) {
		if(time == null)
			return true;
		String[] time_s = time.split(" ");
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setLenient(false);
		try 
		{
		int year = Integer.parseInt(time_s[2]);
		int month = function_z.change_to_num(time_s[1])-1;
		int day = Integer.parseInt(time_s[0]);
		calendar.set(year, month, day);
		if(calendar.getTime() != null)
			return true;
		else 
			return false;
		} catch (IllegalArgumentException e){
			return false;
		}
	}
	public static  Date change_date(String time) {
		if(time == null)
			return new Date();
		String[] time_s = time.split(" ");
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setLenient(false);
		try 
		{
		int year = Integer.parseInt(time_s[2]);
		int month = function_z.change_to_num(time_s[1])-1;
		int day = Integer.parseInt(time_s[0]);
		calendar.set(year, month, day);
		if(calendar.getTime() != null)
			return calendar.getTime();
		else 
			return null;
		} catch (IllegalArgumentException e){
			return null;
		}
	}
		public static void US_test(List<Family> f, List<Individual> I){
		System.out.println("US40:Include input line numbers");
		for(int i=0;i<f.size();i++)
			check_num(f.get(i));

		for(int i=0;i<f.size();i++)
			check_male_name(f.get(i),I);
		System.out.print("ERROR: INDIVIDUAL: US41:");
		Individual I_test =new Individual();
		I_test.setBirthDate(" 1986");
		I_test.setDeathDate("2018-10-32");
		System.out.println("His birthdata and deathData is partial dates"+I_test.getBirthDate()+"     "+I_test.getDeathDate());
		I.get(25).setBirthDate("32 JAN 2018");
		function_z.Reject_illegitimate_dates(f, I);
		I.get(25).setBirthDate("1 JAN 2018");
		for(int i=0;i<f.size();i++)
			function_z.Birth_before_marriage_of_parents(f.get(i), I);
	}
	
}



