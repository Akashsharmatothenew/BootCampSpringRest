package com.company;

import java.util.Scanner;

class processor{
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
            notify();
        }
    }
}
public class Q13 {
    public static void main(String[] arg)throws InterruptedException{
        processor p = new processor();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    p.produce();
                }catch (InterruptedException e){
                    e.printStackTrace();       }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.cunsumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();         }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
