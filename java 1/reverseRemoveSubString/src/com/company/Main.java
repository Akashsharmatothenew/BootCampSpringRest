package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String str = "Akashsharmatothenew";

        StringBuffer sbr = new StringBuffer(str);

        sbr.reverse();
        sbr.delete(4,9);
        System.out.println(sbr);

    }
}
