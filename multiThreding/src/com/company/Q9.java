package com.company;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class task4 implements Runnable{
     private String name;
     public task4(String n){
         this.name = n;
     }

    @Override
    public void run() {
       try{
           for(int i=0;i<=5; i++){
               if(i==0){
                   System.out.println("Doing a task during : " + name +
                                      " - Time - " + new Date());
               }else{
                   System.out.println("Doing a task during : " + name +
                                      " - Time - " + new Date());
               }
               Thread.sleep(1000);
           }
           System.out.println(name +"Task Complete");
       }catch (InterruptedException e){
           e.printStackTrace();
       }
    }
}
public class Q9 {
    public static void main(String[] args){
        Runnable r1 = new task4("Task 1");
        Runnable r2 = new task4("Task 2");
        Runnable r3 = new task4("Task 3");
        Runnable r4 = new task4("Task 4");

        ExecutorService executor= Executors.newFixedThreadPool(3);
        executor.submit(r1);
        executor.submit(r2);
        executor.submit(r3);
        executor.submit(r4);

        executor.shutdown();
    }
}
