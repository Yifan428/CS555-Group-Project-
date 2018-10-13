
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Individual {
	String id;
	String name;
	String gender;
	String birthDate;
	String alive;
	String deathDate;
	List<String> spouseFamilyIds = new ArrayList<String>();
	List<String> childFamilyIds = new ArrayList<String>();
	
	public String getId() {
		return id.replaceAll("@", "");
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDate() {
		return birthDate == null ? "NA" : birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public String isAlive() {
		return deathDate == null ? "True" : "False";
	}
	public String getDeathDate() {
		return deathDate == null ? "NA" : deathDate;
	}
	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}
	public List<String> getSpouseFamilyIds() {
		return spouseFamilyIds;
	}
	
	public String getAge() {
		//try {
			if(birthDate != null) {
//				
				String[] bdar = birthDate.split(" ");
				
				int bdint= Integer.parseInt(bdar[2]);
				Calendar calb =Calendar.getInstance();
				calb.set(Calendar.YEAR,bdint);
				
				if(deathDate != null) {
					
					String[] ddar = deathDate.split(" ");
					
					int ddint= Integer.parseInt(ddar[2]);
					Calendar cald =Calendar.getInstance();
					cald.set(Calendar.YEAR,ddint);
					
					return ""+ (cald.get(Calendar.YEAR) -calb.get(Calendar.YEAR));
				} else {
					Calendar cal = Calendar.getInstance();
					
					return ""+ (cal.get(Calendar.YEAR) - calb.get(Calendar.YEAR));	
				}
			}
		
		return "NA";
	}
	

	public String getSpouseFamilyIdsAsString() {
		if( spouseFamilyIds != null && spouseFamilyIds.size() > 0 ) {
			String value = "{";
			boolean first = true;
			for(String str : spouseFamilyIds) {
				if(!first) {
					value += ",";
				}
				value += str.replaceAll("@", "'");
				
				first = false;
			}
			value += "}";
			return value;
		} else {
			return "NA";
		}
	}

	public void setSpouseFamilyIds(List<String> spouseFamilyIds) {
		this.spouseFamilyIds = spouseFamilyIds;
	}
	public List<String> getChildFamilyIds() {
		return childFamilyIds;
	}
	public void setChildFamilyIds(List<String> childFamilyIds) {
		this.childFamilyIds = childFamilyIds;
	}
	public String getChildFamilyIdsAsString() {
		if( childFamilyIds != null && childFamilyIds.size() > 0 ) {
			String value = "{";
			boolean first = true;
			for(String str : childFamilyIds) {
				if(!first) {
					value += ",";
				}
				value += str.replaceAll("@", "'");
				
				first = false;
			}
			value += "}";
			return value;
		} else {
			return "NA";
		}
	}
	
	
	
}
