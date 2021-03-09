package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List <Float> fList = new ArrayList<Float>();
        fList.add(5.5f);
        fList.add(3.7f);
        fList.add(8.96f);
        fList.add(16.5f);
        fList.add(45.76f);
        Float sum =0.0f;
        for(Float sum1 :fList){
            sum = sum+sum1;
        }
        System.out.println(sum);
    }
}
