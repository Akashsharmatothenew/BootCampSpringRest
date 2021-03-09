package java1;

/**
 * Created by ttn on 28/2/21.
 */
public class Q2 {
    public static void main(String[] args) {
        String str ="Akash Sharma have sharma akash is two name same have";
        str =  str.toLowerCase();
        String words[] = str.split(" ");
        for(int i=0;i<words.length;i++){
            int count =1;
            for(int j=i+1;j<words.length;j++){
                if(words[i].equals(words[j])){
                    count++;
                    words[j]="0";

                }
            }
            if(count>1&& words[i] != "0"){
                System.out.println(words[i]+" "+count);
            }
        }
    }
}
