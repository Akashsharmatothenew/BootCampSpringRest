package com.company;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account{
    private int balance = 10000;
    void deposit(int amount){
        balance = balance+amount;
    }
    void withdraw(int amount){
        balance=balance-amount;
    }
    int getBalance(){
        return balance;
    }
    static void transfer(Account acc1,Account acc2,int amount){
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}
class Runner{
    Account acc1 = new Account();
    Account acc2 = new Account();
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();
    void acquireLock(Lock firstlock,Lock secoundlock)throws InterruptedException{
        while(true){
            boolean getFirstLock = false;
            boolean getSecoundLock =false;
            try{
                getFirstLock = firstlock.tryLock();
                getSecoundLock=secoundlock.tryLock();
            }finally {
                if(getFirstLock && getSecoundLock){
                    return;
                }
                if(getFirstLock){
                    firstlock.unlock();
                }
                if(getSecoundLock){
                    secoundlock.unlock();
                }
            }
            Thread.sleep(10);
        }
    }


   void firstThread()throws InterruptedException{
       Random random = new Random();
       for(int i=0;i<1000;i++){
           acquireLock(lock1,lock2);
           try {
               Account.transfer(acc1, acc2, random.nextInt(100));
           }finally {
               lock1.unlock();
               lock2.unlock();
           }
       }

   }
   void secoundThread() throws InterruptedException{
       Random random = new Random();
       for(int i=0;i<1000;i++){
           acquireLock(lock2,lock1);
           try {
               Account.transfer(acc2, acc1, random.nextInt(100));
           }finally {
               lock2.unlock();
               lock1.unlock();
           }
       }

   }
   void finished(){
       System.out.println("Account 1 Balance is "+acc1.getBalance());
       System.out.println("Account 2 Balance is "+acc2.getBalance());
       System.out.println("Total Balance is "+(acc1.getBalance()+acc2.getBalance()));

   }
}
public class Q16 {
    public static void main(String[] arg) throws  Exception{
        final Runner run = new Runner();
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
