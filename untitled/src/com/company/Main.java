package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static int uniqueCharCount (String buf) {
        HashSet <Character> hash = new HashSet<>();
        buf = buf.toUpperCase();
        for (int i = 0; i < buf.length(); i++)
            hash.add(buf.charAt(i));
        return hash.size();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a string");
        String word=br.readLine();
        System.out.println(uniqueCharCount(word));

    }
}
