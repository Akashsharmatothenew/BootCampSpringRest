package java1;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by ttn on 28/2/21.
 */
public class Q5 {
    public static void main(String[] args) {
        int arry[] ={2,4,6,5,1,9,2,8,7};
        int arry2[] ={6,4,1,12,23,13,7};
        System.out.print("Common element is : { ");

        for(int i=0;i<arry.length;i++){
            for(int j=0;j<arry2.length;j++){
                if(arry[i]==arry2[j]){
                    System.out.print(arry[i]+",");
                }
            }
        }
        System.out.print(" }");

    }

}
