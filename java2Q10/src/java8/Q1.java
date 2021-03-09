package java8;

/**
 * Created by ttn on 2/3/21.
 */
interface Operation {
    void display(int a, int b);

}
public class Q1 {
        static void performOpretation(int a, int b, Operation operation){
            operation.display(a,b);
        }
        static void multiplay(int a,int b){
            System.out.println(a*b);
        }
    public static void main(String[] args) {
        performOpretation(3,4,(int a,int b)-> {
            System.out.println(a+b);
            System.out.println(a*b);
        });
        Operation operation = Q1::multiplay;
        operation.display(3,4);
    }
}
