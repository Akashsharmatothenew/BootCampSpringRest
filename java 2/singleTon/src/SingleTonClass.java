/**
 * Created by ttn on 16/2/21.
 */

public class SingleTonClass {
    public static void main(String args[]){
        Singleton a = new Singleton();
        Singleton b = new Singleton();
        Singleton c = new Singleton();
        a.str=(a.str).toUpperCase();
        b.str=(b.str).toUpperCase();
        c.str=(c.str).toUpperCase();
        System.out.println("String From a is "+ a.str);
        System.out.println("String From b is "+ a.str);
        System.out.println("String From c is "+ a.str);
    }
}
