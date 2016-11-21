package daiict.project.data;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DataCollection {

	private static TreeMap<String, PhonebookData> phonebookData = new TreeMap<>();
	
	
	public void insertContact(String name,PhonebookData data){
		phonebookData.put(name,data);
	}
	
	public void deleteContact(String name){
		phonebookData.remove(name);
	}
	
	public String searchContactByNumber(String number){
		if(phonebookData == null)
			return null;
		
		for(String key : phonebookData.keySet()){
			if(phonebookData.get(key).getPrimaryNumber().contains(number))
				return key;
		}
		return null;
	}
	
/*public String searchContactByNumber(String number) throws IOException{
	if(phonebookData == null)
		return null;
	
	String searchString=number;
	FileInputStream fis = new FileInputStream("D:/demo.csv");
	InputStreamReader isr = new InputStreamReader(fis);
	BufferedReader br = new BufferedReader(isr);
	HashMap<String, String> hm = new HashMap<>();
	String line = null;
	
	while ((line = br.readLine()) != null) {
		// Deal with the line

		String[] arr = line.split(",");
		hm.put(arr[1], arr[0]);
		
	}
	
	for (int i = 0; i < hm.size(); i++) {
		if (hm.containsKey(searchString)) {
			String ans = hm.get(searchString);
			String temp[] = ans.split(",");
			System.out.println("Contact Name: " + temp[0]);
			break;
		}
	}
	return null;
}
*/
	public List<PhonebookData> getAllContact(){
		if(phonebookData == null){
			return null;
		}
		
		return  new ArrayList<PhonebookData>(phonebookData.values());
	}
	 public void display() {
		 
		 System.out.println("\nLIST OF ENTRIES IN YOUR PHONE BOOK:\n");
		 System.out.println("--------------------------------------");
		 System.out.println("\tNAME            NUMBER");
		 System.out.println("--------------------------------------");
	     for ( Map.Entry<String,PhonebookData> entry : phonebookData.entrySet() ){
	       
	    	 System.out.print("\t" + entry.getKey());
	    	 for(int spaceLen=0;spaceLen<=15-entry.getKey().length();spaceLen++)
	    		 System.out.print(" ");
	    	 System.out.print(entry.getValue() );
	    	 
	    	 System.out.println();
	        }
		 System.out.println("--------------------------------------");
		
	}
}

