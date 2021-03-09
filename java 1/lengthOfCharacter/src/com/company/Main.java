package com.company;

public class Main {

    public static void main(String[] args) {
        String data = "My name is Akash";
        int countUsingLength = data.length();
        System.out.println("Number of character with space : "+countUsingLength);
        char[] charArr = data.toCharArray();
        int countUsingArray= 0 ;
        int countWithoutSpace= 0 ;
        Character space = new Character(' ');
        for(char c : charArr) {
            countUsingArray++;
            if(new Character(c).equals(space)) {
                continue;
            }else {
                countWithoutSpace++;
            }
        }
        System.out.println("Number of character Without Space : "+countWithoutSpace);
    }
}
