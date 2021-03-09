package com.company;

class task6 implements Runnable{
    private int count =0;
    public void increment(){
        count++;
    }
    public void run() {
        for(int i=0;i<10000;i++){
            synchronized (this) {
                increment();
            }
        }
    }
    void getcount(){
        System.out.println(count);
    }
}
public class Q11 {
    public static void main(String[] args){
        task6 t6 = new task6();
        Thread t1 = new Thread(t6);
        Thread t2 = new Thread(t6);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t6.getcount();
    }
}
