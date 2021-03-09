package java1;

/**
 * Created by ttn on 28/2/21.
 */
class details{
   static String firstName;
   static String lastName;
   int age;
   details(String firstName,String lastName,int age){
   }
   static {
       System.out.println("My details");
   }
     void display(){
        System.out.println("Name "+firstName+" "+lastName);
    }

}
public class Q7 {
    public static void main(String[] args) {
        details detail = new details("akash","sharma",44);
        detail.display();
    }
}
