/**
 * Created by ttn on 16/2/21.
 */
public class Singleton {
    private static Singleton s = null;
    public String str;
    Singleton(){
        str="Example of Singleton Class";
    }
    public static Singleton getInstance(){
        if(s==null)
            s = new Singleton();
         return  s;
    }
}
