package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static void charCount(String str1){
        HashMap <Character,Integer> charCountMap = new HashMap<Character,Integer>();
        char [] strArray = str1.toCharArray();
        for(char c : strArray){
            if(charCountMap.containsKey(c)){
                charCountMap.put(c,charCountMap.get(c)+1);
            }
            else{
                charCountMap.put(c,1);
            }
        }
         for(Map.Entry entry : charCountMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
         }
    }

    public static void main(String[] args) {
	   String str = "akash";
	   charCount(str);
    }
}
