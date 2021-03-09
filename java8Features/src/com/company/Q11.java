package com.company;

import com.sun.org.glassfish.external.statistics.AverageRangeStatistic;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Q11 {
    public static void main(String[] arg){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
        OptionalDouble avg =numbers.stream().mapToDouble(a -> a*2).average();
        //int avg1 = numbers.stream().map(a->a*a).reduce(0,Integer::sum)
        System.out.print(avg);
    }
}
