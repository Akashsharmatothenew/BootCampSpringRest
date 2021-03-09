package com.SpringCoreConcept1.question1;

import org.springframework.stereotype.Component;

/**
 * Created by ttn on 3/3/21.
 */
public class BubbleSort {
    int [] bubbleSort(int [] number){
        int length = number.length;
        for (int i = 0; i < length-1; i++)
            for (int j = 0; j < length-i-1; j++)
                if (number[j] > number[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = number[j];
                    number[j] = number[j+1];
                    number[j+1] = temp;
                }
        return number;
    }
}
