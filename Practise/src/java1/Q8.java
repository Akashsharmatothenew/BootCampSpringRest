package java1;

/**
 * Created by ttn on 28/2/21.
 */
public class Q8 {
    public static void main(String[] args) {
        String str = "Akashssharma1@tothenew.com";
        StringBuffer sbf = new StringBuffer(str);
        sbf.reverse();
        sbf.delete(4,10);
        System.out.println(sbf);

    }
}
