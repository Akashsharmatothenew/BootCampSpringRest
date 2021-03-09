package com.company;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class task3 implements Runnable{
    private String name;

    public task3(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Doing a task during : " + name + " - Time - " + new Date());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public class Q8 {
    public static void main(String[] args){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        task3 thread1 = new task3("Thread 1");
      //  task3 thread2 = new task3("Thread 2");
        task3 thread3 = new task3("Thread 3");
        task3 thread4 = new task3("Thread 4");
        System.out.println("The date and Time is " + new Date());
        executor.schedule(thread1,5, TimeUnit.SECONDS);
      //  executor.schedule(thread2,10,TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(thread3,5,10,TimeUnit.SECONDS);
       // executor.scheduleWithFixedDelay(thread3,5,10,TimeUnit.SECONDS);
        executor.shutdown();

    }

}
