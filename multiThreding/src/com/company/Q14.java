package com.company;
import java.util.Scanner;

class processor1{
    public void produce2() throws InterruptedException{
        synchronized (this){
            Thread.sleep(1000);
            System.out.println("producer 3 Thread Running");
            wait();
            System.out.println("Resumed2");
        }
    }
    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("producer Thread Running");
            wait();
            System.out.println("Resumed");
        }
    }
    public void cunsumer() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this){
            System.out.println("Waiting for the Return Key");
            scanner.nextLine();
            System.out.println("Return Key Pressed");
            notifyAll();
        }
    }
}
public class Q14 {
    public static void main(String[] arg)throws InterruptedException{
        processor1 p2 = new processor1();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    p2.produce();
                }catch (InterruptedException e){
                    e.printStackTrace();       }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p2.cunsumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();         }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p2.produce2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
