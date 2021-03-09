package com.SpringCoreConcept2.question6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ttn on 4/3/21.
 */
@Component
public class BinarySearch {
    @Autowired
    private SortAlgorithm sortAlgorithm;
    //Constructor injection
    public BinarySearch(SortAlgorithm sortAlgorithm){
        super();
        this.sortAlgorithm=sortAlgorithm;
    }
    public int binarySerch(int[] number,int find){
        int[] sortedArray = sortAlgorithm.sort(number,0,number.length-1);
        int left=0;
        int right=sortedArray.length-1;
        while(left<=right){
            int mid = left+(right-1)/2;
            if(sortedArray[mid]==find)
                return mid;
            if(sortedArray[mid]<find)
                left=mid+1;
            else
                right=mid-1;
        }


        return -1;
    }
}
