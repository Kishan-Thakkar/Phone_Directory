package daiict.project.importexport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;


public class importexport {

	 public boolean importContacts() throws IOException
	 {
		 String csvFile = "D:/import.csv";
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        FileWriter fileWritter = new FileWriter("D:/demo.csv",true);
	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
	        
	       
	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] data = line.split(cvsSplitBy);
	                //System.out.println(data[0]);
	                bufferWritter.write("\r\n"+data[0]+data[1]);                
	            }
	            return true;
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                    bufferWritter.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
		 return false;
	 }
	 public boolean exportContacts()
	 {
		 try{
			 //Files.co
			 Files.copy(new File("D:/demo.csv").toPath(), new File("D:/export.csv").toPath());
			 System.out.println("Export Operation Has been completed..!");
			
			 //FileUtils.copyFile("C:/Users/Kishan Pujara/.phonebook_demo1", "C:/Users/Kishan Pujara/export.phonebook_demo1");
		 return true;
		 }catch (Exception e) {
			System.out.println(e.toString());
		}
		 return false;
	 }
	
	 
	 
}

