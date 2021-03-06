package CS555;

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
					System.out.println("ERROR: FAMILY: US16: The "+f.id+" family's man's last name is not same ");	
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
		if(f.childrenId.size()>5)
			System.out.println("ERROR: FAMILY: US14 The "+f.id+" family have more than 5 child");
	}
	public static void US_test(List<Family> f, List<Individual> I){
		//System.out.println("US14:");
		//System.out.println("Family with more than 5 child in the same time is:");
		for(int i=0;i<f.size();i++)
			check_num(f.get(i));
		//System.out.println("US16");
		for(int i=0;i<f.size();i++)
			check_male_name(f.get(i),I);  
	}
}
