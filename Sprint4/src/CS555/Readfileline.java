package CS555;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Readfileline {

    public static void main(String[] args) throws IOException {

		String string = null;
        ArrayList<String> singleAddress = new ArrayList<String>();
        boolean married = false;
        try {
            FileReader fr = new FileReader("Test_Family_Team wisdom of Mr Toad.ged");
            BufferedReader br = new BufferedReader(fr);
            while (null != (string = br.readLine())) {
            	 System.out.println("***" + string);
            	if (string == "1 MARR") {
            		married = true;
            		System.out.println(married);
            		
            	}
                //System.out.println(string);
            	else{
                singleAddress.add(string);
                married = false;
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(married);
//        System.out.println(singleAddress);
//        
//        for(int i = 0; i < singleAddress.size();i++) {
//        	System.out.println(i+1 + ":");
//        	System.out.println(singleAddress.get(i));
//        	
//        	
//        }
        
}
    
    public class Family {

    	String id;
    	String marriageDate;
    	
    	
    	public String getId() {
    		return id;
    	}
    	public void setId(String id) {
    		this.id = id;
        }
    	public String getmarr() {
    		return marriageDate;
    	}
    	public void setmarr(String marriageDate) {
    		this.marriageDate = marriageDate;
        }
    	
    }
    
    
    
}
