package com.company;

import java.util.Arrays;
import java.util.List;

public class Q12 {
    public static void main(String[] arg) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
         int even = numbers.stream().filter(a -> (a > 3 )& (a % 2 == 0))
                 .findFirst().orElse(-1);
        System.out.print(even);

    }
}
