package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ttn on 21/2/21.
 */
public class Q9 {
    public static void main(String[] arg){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
        numbers.stream()
                .filter(a -> a%2 == 0)
                .forEach(System.out::println);
    }
}
