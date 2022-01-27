package com.map;

import java.util.*;
import java.util.Map.Entry;
public class mapDemo {

	public static void main(String[] args) {
		// map
		
		//Hashmap
		HashMap<Integer,String> hm=new HashMap<Integer,String>();      
	      hm.put(1,"Teju");    
	      hm.put(2,"Chinni");    
	      hm.put(3,"Vaishu");   
	       
	      System.out.println("\nThe elements of Hashmap are ");  
	      for (Iterator<Entry<Integer, String>> iterator = hm.entrySet().iterator(); iterator.hasNext();) {
			Entry<Integer, String> m = iterator.next();
			System.out.println(m.getKey()+" "+m.getValue());
		}
	      
	     //HashTable
	       
	      Hashtable<Integer,String> ht=new Hashtable<Integer,String>();  
	      
	      ht.put(4,"Anu");  
	      ht.put(5,"larisa");  
	      ht.put(6,"sairekha");  
	      ht.put(7,"sri");  

	      System.out.println("\nThe elements of HashTable are ");  
	      for (Iterator<Entry<Integer, String>> iterator = ht.entrySet().iterator(); iterator.hasNext();) {
			Entry<Integer, String> n = iterator.next();
			System.out.println(n.getKey()+" "+n.getValue());
		}
	      
	      
	      //TreeMap
	      
	      TreeMap<Integer,String> map=new TreeMap<Integer,String>();    
	      map.put(8,"Ram");    
	      map.put(9,"Niha");    
	      map.put(10,"Anjali");       
	      
	      System.out.println("\nThe elements of TreeMap are ");  
	      for (Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
			Entry<Integer, String> l = iterator.next();
			System.out.println(l.getKey()+" "+l.getValue());
		}    
	      
	   }  
}




