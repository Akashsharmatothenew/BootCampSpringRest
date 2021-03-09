package com.company;

public class Main {

    public static void main(String[] args) {
	String str1 = "akashsharma";
	char temp =0;
	char[] chr=str1.toCharArray();

	for(int i=0;i<chr.length;i++){
	    for(int j=0;j<chr.length;j++){
	        if(chr[j]>chr[i]){
	            temp = chr[i];
	            chr[i]=chr[j];
	            chr[j]=temp;
            }
        }
    }
    for(int i=0;i<chr.length;i++){
	    System.out.print(chr[i]);
    }

    }
}
