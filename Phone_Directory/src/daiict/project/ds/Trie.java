package daiict.project.ds;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import daiict.project.data.DataCollection;
import daiict.project.data.PhonebookData;

class TrieNode 
{
    char content; 
    boolean isEnd; 
    int count;
    PhonebookData data;
    LinkedList<TrieNode> childList; 
    Stack<String> recnt=new Stack<>();
    
 
   
    public TrieNode(char c)
    {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
        count = 0;
    }  
    public TrieNode subNode(char c)
    {
        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }
}
 

public class Trie {
	Stack<String> recnt=new Stack<>();
	 private TrieNode root;
	 
     /* Constructor */
    public Trie()
    {
        root = new TrieNode(' '); 
    }
    
    public void insert(String name,PhonebookData data)
    {
        if (search(name) != null) 
            return;        
        TrieNode current = root; 
        for (char ch : name.toCharArray() )
        {
            TrieNode child = current.subNode(ch);
            if (child != null)
                current = child;
            else 
            {
                 current.childList.add(new TrieNode(ch));
                 current = current.subNode(ch);
            }
            current.count++;
        }
        current.isEnd = true;
        current.data = data;
    }
    /* Function to search for name */
    public PhonebookData search(String name)
    {
    	
        TrieNode current = root;  
        for (char ch : name.toCharArray() )
        {
            if (current.subNode(ch) == null)
                return null;
            else{
                current = current.subNode(ch);
                }
        }      
        if (current.isEnd == true) {
        	recnt.push(name);
            return current.data;
            }
        return null;
    }
    public void recentSearch(){
    	
    	for(String name : recnt)
    		System.out.println(name);
    	
		
    	
    }
   
    public void remove(String name)
    {
        if (search(name) == null)
        {
            System.out.println(name +" does not exist in trie\n");
            return;
        }             
        TrieNode current = root;
        for (char ch : name.toCharArray()) 
        { 
            TrieNode child = current.subNode(ch);
            if (child.count == 1) 
            {
                current.childList.remove(child);
                return;
            } 
            else 
            {
                child.count--;
                current = child;
            }
        }
        current.isEnd = false;
    }
    public void display() {
    	System.out.println("\nLIST OF ENTRIES IN YOUR PHONE BOOK:\n");
		 System.out.println("--------------------------------------");
		 System.out.println("\tNAME            NUMBER");
		 System.out.println("--------------------------------------");
    	for(PhonebookData data1: new DataCollection().getAllContact()){
			
		    
	    	 System.out.print("\t" + data1.getFirstName());
	    	 for(int spaceLen=0;spaceLen<=15-data1.getFirstName().length();spaceLen++)
	    		 System.out.print(" ");
	    	 System.out.print(data1.getPrimaryNumber() );
	    	 
	    	 System.out.println();
		
	}
  
 
  

    /*public static void main(String[] args)
    {}*/
}
}