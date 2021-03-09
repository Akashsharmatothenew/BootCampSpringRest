package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        furniture wc1 = new woodenChair();
        wc1.fireCheck(7);
        wc1.streesTest(8);
        System.out.println(" ");
        furniture mc1 = new metalChair();
        mc1.fireCheck(7);
        mc1.streesTest(6);
        System.out.println(" ");
        furniture wt1 = new woodenTable();
        wt1.fireCheck(4);
        wt1.streesTest(7);
        System.out.println(" ");
        furniture mt1 = new metalTable();
        mt1.fireCheck(7);
        mt1.streesTest(4);

    }
}
