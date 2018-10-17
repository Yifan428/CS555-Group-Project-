package CS555;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class function_z {
	public static void check_male_name(Family f,List<Individual> I)//male same name
	{ 
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
					System.out.print("line "+function_z.findwhichline(namelist[namelist.length-1])+" ");
					System.out.println("Error: FAMILY: US16: The F"+f.id+" family's man's last name is not same ");	
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
		if(f.childrenId==null)
			return;
		if(f.childrenId.size()>5) {
			System.out.print("line "+ function_z.findwhichline(f.id));
			System.out.println("Error: FAMILY: US14 The F"+f.id+" family have more than 5 child");
	}
}
	public static void US_test(List<Family> f, List<Individual> I){
		System.out.println("US14:");
		System.out.println("Family with more than 5 child in the same time is:");
		for(int i=0;i<f.size();i++)
			check_num(f.get(i));
		System.out.println("US16&US40");
		System.out.println("Include input line numbers");
		System.out.println("Same man in fanmily have same last name");
		for(int i=0;i<f.size();i++)
			check_male_name(f.get(i),I);
		System.out.println("US41");
		System.out.println("Include partial dates");
		Individual I_test =new Individual();
		I_test.setBirthDate("1986");
		I_test.setDeathDate("2018-10");
		System.out.println("His birthdata and deathData is partial dates"+I_test.getBirthDate()+"     "+I_test.getDeathDate());
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
}
