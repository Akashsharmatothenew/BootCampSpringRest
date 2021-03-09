package com.company;

class testSleepJoin extends Thread{
    public void run(){
        for(int i=1;i<5;i++){
            try{
                Thread.sleep(600);
            }catch (InterruptedException a){
                System.out.println(a);
            }
            System.out.println(i);
        }
    }
}
public class Q2 {
    public static void main(String[] arg){
        testSleepJoin t1 = new testSleepJoin();
        testSleepJoin t2 = new testSleepJoin();
        testSleepJoin t3 = new testSleepJoin();
        t1.start();
        try{
            t1.join();
        }catch (Exception e){
            System.out.println(e);
        }
        t2.start();
        t3.start();
    }
}
