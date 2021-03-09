package com.SpringCoreConcept2.question5;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by ttn on 4/3/21.
 */
@Component
public class BubbleSort {
    public int[] sort(int[] number,int low,int hight){
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
