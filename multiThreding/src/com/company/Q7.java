package com.company;
import java.util.concurrent.*;

class task1 implements Runnable{
    public int id;
    task1(int id){
        this.id=id;
    }
    public void run(){
        System.out.println("Started Thread : "+ id);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Complete Thread : "+ id);
    }
}
public class Q7 {
    public static void main(String[] arg) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for(int i =1; i<6;i++){
            executor.submit(new task1(i));
        }
        executor.shutdown();
        System.out.println("All task List Submited ");
        executor.awaitTermination(3, TimeUnit.MINUTES);
        System.out.println("All task Completed ");
    }
}
