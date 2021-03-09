package com.company;

public class Main {
    static int oneElement(int arr[]){
        int n = arr.length;
        int res = arr[0];
        for (int i = 1; i < n; i++)
            res = res ^ arr[i];

        return res;
    }


    public static void main(String[] args) {
	// write your code here
        int arr[] = {2,3,5,3,2,7,8,7,8,6,5};
        System.out.println("except one Element is : "+ oneElement(arr)+" ");
    }
}
