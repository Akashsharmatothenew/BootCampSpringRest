package com.company;
import java.util.concurrent.atomic.AtomicInteger;

class task7 implements Runnable{
    private AtomicInteger count = new AtomicInteger();

    public void run() {
        for(int i=0;i<5000;i++){
            count.addAndGet(1);
        }
    }
    void getcount(){
        System.out.println(count);
    }
}
public class Q12 {
    public static void main(String[] args){
        task7 t7 = new task7();
        Thread t1 = new Thread(t7);
        Thread t2 = new Thread(t7);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t7.getcount();
    }
}
