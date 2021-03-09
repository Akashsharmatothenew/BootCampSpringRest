package java1;

/**
 * Created by ttn on 28/2/21.
 */
public class Q4 {
    public static void main(String[] args) {
        String str = "Akash Sharma inside @ gmail.Com2896 Percentage pf word and Find";
        int totalLength=str.length();
        int upperCse=0;
        int lowerCase=0;
        int digit=0;
        int special=0;
        char ch[] = str.toCharArray();
        for(char ch1 : ch){
            if(Character.isUpperCase(ch1)){
                upperCse++;
            }
            else if(Character.isLowerCase(ch1)){
                lowerCase++;
            }
            else if (Character.isDigit(ch1)) {
                digit++;
            }else
                special++;
        }
        System.out.println(upperCse+" ,"+lowerCase+" , "+digit+" , "+special);
        double upCasePercentage= (upperCse/totalLength)*100;
        double lwCasePercentage= (lowerCase/totalLength)*100;
        double digitPercentage= (digit/totalLength)*100;
        double spCasePercentage= (special/totalLength)*100;
        System.out.println("");


    }
}
