package com.SpringCoreConcept2.question2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

/**
 * Created by ttn on 3/3/21.
 */
public class BinarySerch {
    //instance of interface
    private SortAlgorithm sortAlgorithm;

    public BinarySerch(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
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
