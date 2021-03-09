package com.company;

public class Main {

    public static void main(String[] args) {
	  try{
	      int a[] = new int[5];
	      a[5]= 29/0;
	      System.out.println(a[9]);
      }
      catch (ArithmeticException e){
	      System.out.println("Arithmetic Exception occurs");
      }
      catch(ArrayIndexOutOfBoundsException e){
          System.out.print("ArrayIndexOutOfBounds Exception Occurs");
      }
      catch(Exception e){
          System.out.println(e);
      }
      finally {
          System.out.println("Finally Block Always Execute");
      }

      System.out.println("Rest of the Code");
    }
}
