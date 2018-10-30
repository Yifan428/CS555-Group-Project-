package CS555;

import java.util.ArrayList;

public class abc {

	public static void main(String[] args) {
		ArrayList<String> testname = new ArrayList<String>();
		
			testname.add("a");

			testname.add("b");		

			testname.add("c");		

			testname.add("d");		
			System.out.format("___________________" + testname);
		String[] testnamearr = (String[]) testname.toArray(new String[testname.size()]);
		System.out.format("___________________" + testnamearr);
		String[] dest = testname.toArray(new String[3]);
		
		System.out.format("___________________" + dest);
		

	}

}
