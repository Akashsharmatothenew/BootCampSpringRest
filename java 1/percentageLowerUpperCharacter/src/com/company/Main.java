package com.company;

public class Main {
    static void chPercentage(String input) {
        int totalChar = input.length();
        int upperCase = 0;
        int lowerCase = 0;
        int digits = 0;
        int special = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isUpperCase(ch)) {
                upperCase++;
            }
            else if (Character.isLowerCase(ch)) {
                lowerCase++;
            }
            else if (Character.isDigit(ch)) {
                digits++;
            }
            else {
                special++;
            }
        }
        double upperCasePercentage = (upperCase * 100) / totalChar;
        double lowerCasePercentage = (lowerCase * 100) / totalChar;
        double digitsPercentage = (digits * 100) / totalChar;
        double specialPercentage = (special * 100) / totalChar;
        System.out.println("upperCase letter present is : "+upperCase+" ");
        System.out.println("upperCase Letter Percentage : "+ upperCasePercentage +"%");
        System.out.println(" ");
        System.out.println("lowerCase letter present is : "+lowerCase+" ");
        System.out.println("lowerCase Letter Percentage : "+ lowerCasePercentage +"%");
        System.out.println(" ");
        System.out.println("Number's present is : "+digits+" ");
        System.out.println("number Percentage : "+digitsPercentage +"%");
        System.out.println(" ");
        System.out.println("special Symbol & space present is : "+special+" ");
        System.out.println("special Symbol & space Percentage : "+ specialPercentage +"%");

    }

    public static void main(String[] args) {

        chPercentage("My email iS AkashSharma2896@gmail.com");

    }
}
