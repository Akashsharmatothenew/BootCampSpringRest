package com.company;

class task5 implements Runnable{
    private int count =0;
    public synchronized void increment(){
        count++;
    }
    public void run() {
       for(int i=0;i<10000;i++){
           increment();
       }
    }
     void getcount(){
        System.out.println(count);
     }
}
public class Q10 {
    public static void main(String[] args){
        task5 t5 = new task5();
        Thread t1 = new Thread(t5);
        Thread t2 = new Thread(t5);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t5.getcount();
    }
}
