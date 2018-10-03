package cs5551;

public class fuc_z {
	public static void check_male_name(Family f,Individual[] I)//male same name
	{
		String name[]=f.getHusbandName().split(" ");
		String failyname=name[name.length-1];
		for(int i=0;i<f.childrenId.size();i++)
		{
			int num=Integer.parseInt((f.childrenId.get(i)));
			if(I[num].gender.equals("Male"))
			{
				String sonname;
				String[] namelist;
				sonname=I[num].getName();
				namelist=sonname.split(" ");
				namelist[namelist.length-1]=failyname;
				sonname=namelist.toString();
			}
		}
	}
	public static void check_num(Family f)// children <=5
	{
		if(f.childrenId.size()>5)
			System.out.println("family"+f.id+"have more than 5 child");
	}
}
