package com.SpringCoreConcept1.question1;

import org.springframework.stereotype.Component;

/**
 * Created by ttn on 3/3/21.
 */
public class BinarySearch {
    int binarySerch(int [] number,int find){
      //sorting the array using bubble sort
        BubbleSort bubbleSort =new BubbleSort();
        bubbleSort.bubbleSort(number);
        //searching the array
        int left=0;
        int right=number.length-1;
        while(left<=right){
            int mid = left+(right-1)/2;
            if(number[mid]==find)
                return mid;
            if(number[mid]<find)
                left=mid+1;
            else
                right=mid-1;
        }
        return -1;
    }
}
