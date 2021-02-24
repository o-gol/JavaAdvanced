package ru.daemonExecutors;

import ru.Colors;

import java.util.concurrent.*;

public class Program {
    private static final int processCount=Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Colors.RED+"Start main thread");
        GCDRunnable gcdRunnable=new GCDRunnable(false);
//        startSomeThread(new GCDRunnable(true)
////                ,new GCDRunnable(true)
//        );
        startWithExecutorService(gcdRunnable);

        Thread.sleep(100);

        System.out.println(Colors.RED+"Stop main thread");
    }
    private static void startSomeThread(Runnable... runnables) throws InterruptedException {
        for (Runnable r :
                runnables) {
            Thread th1=new Thread(r);
            th1.setDaemon(((GCDRunnable)r).isDaemon);
            System.out.printf("%s %s Daemon- %s\n",Colors.PURPLE,th1.getName(),th1.isDaemon());
            th1.start();
//                th1.sleep(100);
            /*if(!th1.isDaemon()){
                for (int i = 0; i < 1000000; i++) {
                    Math.sin(new Random().nextInt());
                }
                th1.interrupt();
//            th1.join();
            }*/


        }

    }


    private static void startWithExecutorService(Runnable... runnables) throws InterruptedException {


        for (Runnable r :
                runnables) {
        ThreadFactory threadFactory=ru->{
            Thread th=new Thread(r);
            th.setDaemon(((GCDRunnable) r).isDaemon);
            return th;
        };
        ExecutorService executorService=
                Executors.newCachedThreadPool(threadFactory);
//                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
                executorService.execute(r);

            }
            executorService.shutdown();
//            executorService.awaitTermination(30,TimeUnit.SECONDS);
//            System.out.printf("%s start executorService %s \n",Colors.PURPLE,executorService.toString());



        }

    }




}
