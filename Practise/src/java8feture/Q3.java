package java8feture;

/**
 * Created by ttn on 28/2/21.
 */

interface Oprtation{
    void perform(int a,int b);
}


public class Q3 {
    static void performOpratation(int a,int b,Oprtation oprtation){
        oprtation.perform(a,b);
    }
    int adding(int a,int b){
        return a+b;
    }

    public static void main(String[] args) {
        Oprtation add=new Q3()::adding;
        System.out.println(add.perform(3,4););
        performOpratation(3,4,(int a,int b)->{
            System.out.println(a+b);
        });
        performOpratation(6,3,(int a,int b)->{
            System.out.println(a-b);
        });
    }
}
