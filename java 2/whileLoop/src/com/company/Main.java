package com.company;

public class Main {

    public static void main(String[] args) {
        int s = 0;
        int t = 1;
        int i=0;
      //  int j=i;
      //  for (int i = 0; i < 10; i++)
        while(i<10)
        {
            s = s + i;
           int j=i;
            //for (j = i; j > 0;j--)
            while(j>0)
            {
                t = t * (j- i);
                j--;
            }
            s = s * t;
            System.out.println("T is " + t);
            i++;
        }
        System.out.println("S is " + s);
    }
}
