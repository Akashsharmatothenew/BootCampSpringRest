package java1;

/**
 * Created by ttn on 28/2/21.
 */
class Opreatation{
    static int add(int a,int b){
        return a+b;
    }
    static double add(double a, double b){
        return a+b;
    }
    static float mul(float a,float b){
        return a*b;
    }
    static int mul(int a,int b){
        return a*b;
    }
    static void concat1(String a,String b){
        System.out.println(a.concat(b));
    }
    static void concat1(String a,String b,String c){
        System.out.println(a.concat(" ").concat(b).concat(" ").concat(c));
    }
}
public class Q10 {
    public static void main(String[] args) {
        System.out.println(Opreatation.add(2,4));
        System.out.println(Opreatation.add(3.4,5.4));
        System.out.println(Opreatation.mul(5.3f,5.5f));
        System.out.println(Opreatation.mul(4,6));
        Opreatation.concat1("Akash","Sharma");
        Opreatation.concat1("Akash","Sharma","tothenew");
    }

}
