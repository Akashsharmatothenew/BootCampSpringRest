package com.company;

    class multi extends Thread{
        public void run(){
          System.out.println("Thread is created using thread class");
        }
    }

    class multi2 implements Runnable{

        public void run() {
            System.out.println("Thread is created Using Runnable interface");
        }
    }

    public class Q1 {
        public static void main(String[] arg){
             multi m1 = new multi();
             m1.start();

             multi2 m2 = new multi2();
             Thread t1 = new Thread(m2);
             t1.start();
        }

    }
