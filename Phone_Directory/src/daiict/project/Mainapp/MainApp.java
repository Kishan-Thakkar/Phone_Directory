package daiict.project.Mainapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketOption;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import daiict.project.data.DataCollection;
import daiict.project.data.PhonebookData;
import daiict.project.ds.Trie;
import daiict.project.importexport.importexport;

public class MainApp {

	public static void main(String[] args) throws IOException {

		Scanner scan;
		Trie t = new Trie();
		importexport impExp = new importexport();

	
		try {
			scan = new Scanner(new File("D:/demo.csv"));
			while (scan.hasNext()) {
				String data[] = scan.next().split(",");
				if (data.length == 2) {
					t.insert(data[0], new PhonebookData("", data[1], "", "",
							data[0]));
					new DataCollection().insertContact(data[0],
							new PhonebookData("", data[1], "", "", data[0]));
				}
			}
		} catch (FileNotFoundException e1) {
			System.out.println("File not found..");

			e1.printStackTrace();
		}

		scan = new Scanner(System.in);

		String name;
		String number;
		t.display();
		char ch;
		
		do {
			System.out.println("\nPHONE DIRECTORY\n");
			System.out.println("1. ADD NEW CONTACT ");
			System.out.println("2. REMOVE CONTACT");
			System.out.println("3. SERCH CONTACT BY NAME");
			System.out.println("4. SERCH CONTACT BY NUMBER");
			System.out.println("5. IMPORT CONTACT");
			System.out.println("6. EXPORT CONTACT");
			System.out.println("7. DISPLAY CONTACT");
			System.out.println("8. RECENT SEARCH BY USER");
			System.out.println("9. UPDTAE CONTACT");
			

			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Name :");
				name = scan.next();
				System.out.println("Enter Number:");
				number = scan.next();
				// System.out.println("Have a secondary number?(Y&N):");
				/*
				 * if(scan.next().toUpperCase() == "Y"){
				 * System.out.println("Enter Secondary Number :" ); snumber =
				 * scan.next(); }
				 * 
				 * System.out.println("Have a E-Mail Address?(Y&N):");
				 * if(scan.next().toUpperCase() == "Y"){
				 * System.out.println("Enter E-Mail Address :" ); email =
				 * scan.nextLine(); }
				 */
				t.insert(name, new PhonebookData("", number, "", "", name));
				new DataCollection().insertContact(name, new PhonebookData("",
						number, "", "", name));
				
				break;
			case 2:
				System.out.println("Enter Name:");
				try {
					name = scan.next();
					t.remove(name);
					new DataCollection().deleteContact(name);
				} catch (Exception e) {
					System.out.println(e.getMessage() + " not found ");
				}
				break;
			case 3:
				System.out.println("Enter Name:");
				name = scan.next();
				PhonebookData data = t.search(name);
				if (data == null)
					System.out.println("No detail foound");
				else {
					System.out.println("First Name :" + name);
					if (!data.getLastName().isEmpty())
						System.out.println("Last Name :" + data.getLastName());
					if (!data.getEmailAddress().isEmpty())
						System.out.println("Email :" + data.getEmailAddress());

					if (!data.getPrimaryNumber().isEmpty())
						System.out.println("Primary Number :"
								+ data.getPrimaryNumber());

					if (!data.getSecondaryNumber().isEmpty())
						System.out.println("Secondary Number :"
								+ data.getSecondaryNumber());
				}
				// System.out.println(" : "+ t.search( scan.next() ));
				break;
			case 4:
				System.out.println("Enter Number");
				number = scan.next();
				name = new DataCollection().searchContactByNumber(number);
				
				
				if (name == null)
					System.out.println("No name found for " + number);
				else
					System.out.println(name);

				break;
			case 5:
				impExp.importContacts();
				break;
			case 6:
				impExp.exportContacts();
				break;
			case 7:
				t.display();
				break;
			case 8:
				t.recentSearch();
				break;
			case 9:
				System.out.println("Enter name:");
				name = scan.next();
				PhonebookData data1 = t.search(name);
				if(data1 == null){
					System.out.println("No Detail Found!!!");
				}
				else{
					System.out.println("WHAT YOU WANT TO CHANGE ? \n 1.NAME\n2.NUMBER");
					int opt = scan.nextInt();
					if(opt == 1){
						System.out.println("ENTER NEW NAME:");
						t.remove(name);
						name = scan.next();
						t.insert(name, data1);
						
					}else{
						System.out.println("ENTER NEW NUMBER:");
						data1.setPrimaryNumber(scan.next());
					}
				}
				break;
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}

			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
		scan.close();

		try {
			FileWriter writer = new FileWriter(new File("D:/demo.csv"));
			List<PhonebookData> list = new DataCollection().getAllContact();

			for (PhonebookData data : list) {
				writer.write(data.getFirstName() + ","
						+ data.getPrimaryNumber() + "\r\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
