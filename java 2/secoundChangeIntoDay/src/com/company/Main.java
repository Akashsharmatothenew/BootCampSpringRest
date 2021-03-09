package com.company;

public class Main {

    public static void main(String[] args) {
        int s = 358937;

        int day = s / (24*3600);
        s =s%(24*3600);

        int hour = s/3600;
        s=s%3600;

        int minute = s / 60;
        s=s%60;

        int sec = s;
        System.out.print(day+" "+"Days  "+hour+" "+"Hours  "+
                         minute+" "+"minutes  "+sec+" "+"Secounds");
    }
}
