package ru.daemon;

import ru.Colors;

import java.util.Random;

public class Program {
    private static final int processCount=Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Colors.RED+"Start main thread");
//        GCDRunnable gcdRunnable=new GCDRunnable(true);
        startSomeThread(new GCDRunnable(false)
                ,new GCDRunnable(true)
        );
//        Thread.sleep(100);
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
            if(!th1.isDaemon()){
                for (int i = 0; i < 1000000; i++) {
                    Math.sin(new Random().nextInt());
                }
                th1.interrupt();
//            th1.join();
            }


            System.out.printf("%s %s Daemon- %s\n",Colors.PURPLE,th1.getName(),th1.isDaemon());
        }

    }
}
