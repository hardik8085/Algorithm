import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.regex.*;
public class Anagram {
   public static int numberNeeded(String first, String second) {
       char[] firstArray = first.toCharArray();
        char [] secondArray = second.toCharArray();
      
       
        HashMap<Character,Integer> firstHash = new  HashMap<>();
        HashMap<Character, Integer> secondHash = new HashMap<>();
        
        for( Character in :firstArray){
        	if(firstHash.containsKey(in)){
        		firstHash.put(in,firstHash.get(in)+1);
        	}
        	else{
        		firstHash.put(in,1);
        	}
        }
        
        for( Character in :secondArray){
        	if(secondHash.containsKey(in)){
        		secondHash.put(in,secondHash.get(in)+1);
        	}
        	else{
        		secondHash.put(in,1);
        	}
        }
        
        
        
       if(firstArray.length>secondArray.length){
    	   for(Character ch : firstHash.keySet()){
    		   if(secondHash.containsKey(ch)){
    			   if(secondHash.get(ch)> firstHash.get(ch)){
    			   secondHash.put(ch, secondHash.get(ch)-firstHash.get(ch));
    			   firstHash.put(ch, 0);
    			   }
    			   else{
    				   firstHash.put(ch, firstHash.get(ch)-secondHash.get(ch));

    				   secondHash.put(ch, 0);
    			   }
    		   }
    	   }
       }
       else{
    	   for(Character ch : secondHash.keySet()){
    		   if(firstHash.containsKey(ch)){
    			   if(secondHash.get(ch)> firstHash.get(ch)){
    			   secondHash.put(ch, secondHash.get(ch)-firstHash.get(ch));
    			   firstHash.put(ch, 0);
    			   }
    			   else{
    				   firstHash.put(ch, firstHash.get(ch)-secondHash.get(ch));

    				   secondHash.put(ch, 0);
    			   }
    		   }
    	   }
       }
        int remove = 0;
 for(char ch :secondHash.keySet()){
	 remove += secondHash.get(ch);
  }
 for(char ch :firstHash.keySet()){
	 remove += firstHash.get(ch);

  }
       
       return remove;

	}

	
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first string");
        String a = in.next();
        System.out.println("Enter the second string");
        String b = in.next();
        System.out.println("You should remove "+numberNeeded(a, b)+" characters");
    }
}
