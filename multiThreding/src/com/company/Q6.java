package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Q6 {
    public static void main(String[] arg)throws InterruptedException,ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Set<Callable<String>> callables = new HashSet<>();

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Thread 1";
            }
        });
        callables.add(() -> "Thread 2");
        callables.add(() -> "Thread 3");
        List<Future<String>> futures = executorService.invokeAll(callables);
        for(Future<String>future: futures) {
            System.out.println("Future Task = " + future.get());
            System.out.println("task is Cancelled = " + future.isCancelled());
            System.out.println("task is Done = " + future.isDone());

        }
        executorService.shutdown();
    }
}

