package com.company;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class task implements Runnable{
    public void run(){
        try {
            Long duration = (long) (Math.random() * 5);
            System.out.println("Running Thread Name: " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(duration);
            System.out.println("Completed Thread Name: " +Thread.currentThread().getName());
        } catch (InterruptedException e) {  }
    }

}
public class Q5 {
    public static void main (String[] arg) throws InterruptedException{
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new task());
        System.out.println("Is Executor is shutdown : "+executor.isShutdown());
        executor.submit(new task());
        executor.shutdown();
        System.out.println(" Is Executor is Terminated :"+ executor.isTerminated());
        System.out.println("Is Executor is shutdown : "+executor.isShutdown());

    }
}
