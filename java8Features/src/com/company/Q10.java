package com.company;

import java.util.Arrays;
import java.util.List;

public class Q10 {
    public static void main(String[] arg){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
        int sum1 =numbers.stream().filter(a -> a>5).mapToInt(a -> a).sum();
        int sum2 =numbers.stream().filter(a -> a>5).reduce(0,(a,b)->a+b);
        int sum3 =numbers.stream().filter(a -> a>5).reduce(0,Integer::sum);
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);

    }
}
