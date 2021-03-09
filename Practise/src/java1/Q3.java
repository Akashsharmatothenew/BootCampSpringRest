package java1;

/**
 * Created by ttn on 28/2/21.
 */
public class Q3 {
    public static void main(String[] args) {
        String str = "Akash Sharma is my Name";
        int charLength=str.length();
        System.out.println(charLength);
        char ch[] = str.toCharArray();
        int count = 0;
        Character space = new Character(' ');
        for(char a : ch){
            if(new Character(a).equals(space)){
                  continue;
            }else
                count++;
        }
        System.out.println(count);
    }
}
