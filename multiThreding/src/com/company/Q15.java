package com.company;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class runner {
   private int count =0;
   private Lock lock = new ReentrantLock();
   private Condition con = lock.newCondition();
   private void increment(){
        for(int i=0;i<10000;i++){
            count++;
        }
    }
    public void firstThread() throws InterruptedException{
       lock.lock();
       System.out.println("Waiting ... /");
       con.await();
       System.out.println("Wake Up ....!");

       try {
           increment();
       }
           finally {
           lock.unlock();
          }

    }
    public void secoundThread() throws InterruptedException{
       Thread.sleep(1000);
        lock.lock();

        System.out.println("Press the return key");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("Got the return key");
        con.signal();
        try {
            increment();
        }
        finally {
            lock.unlock();
        }
    }
    public void finished(){
      System.out.println("count is : "+count);
    }
}
public class Q15 {
    public static void main(String[] arg) throws  Exception{
        final runner run = new runner();
                Thread t1=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            run.firstThread();
                        } catch (InterruptedException e) {
                            e.printStackTrace();}
                    }
                });
                Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            run.secoundThread();
                        } catch (InterruptedException e) {
                            e.printStackTrace();}
                    }
                });
                t1.start();
                t2.start();
                t1.join();
                t2.join();
                run.finished();
    }
}
