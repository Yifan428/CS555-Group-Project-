package CS555;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GedcomLint {
	
	public static HashMap<String, Set<String>> VALID_LEVEL = new HashMap<String, Set<String>>();
	
	static {
		HashSet<String> values = new HashSet<String>();
		values.add("INDI");
		values.add("FAM");
		values.add("HEAD");
		values.add("TRLR");
		values.add("NOTE");
		VALID_LEVEL.put("0", values);
		
		values = new HashSet<String>();
		values.add("NAME");
		values.add("SEX");
		values.add("BIRT");
		values.add("DEAT");
		values.add("FAMC");
		values.add("FAMS");
		values.add("MARR");
		values.add("HUSB");
		values.add("WIFE");
		values.add("CHIL");
		values.add("DIV");
		VALID_LEVEL.put("1", values);
		
		values = new HashSet<String>();
		values.add("DATE");
		VALID_LEVEL.put("2", values);
	}

}
