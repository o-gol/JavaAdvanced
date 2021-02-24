package ru.daemonExecutors;

import ru.Colors;

import java.util.Random;

public class GCDRunnable extends Random implements Runnable {
    boolean isDaemon;

    public GCDRunnable(boolean isDaemon){
        this.isDaemon=isDaemon;
    }

    @Override
    public void run() {
        String threadType=isDaemon?"Daeman":"User";
        String threadName=Thread.currentThread().getName();
        System.out.printf("%s start %s %s\n", Colors.BLUE,threadType, threadName);

        for (int i = 0; i < 10000000; i++) {
            int a=nextInt();
            int b=nextInt();
            if (i%10000==0){
                if(!Thread.interrupted()) {
                    int gcd = computeGCD(a, b);
                    if (gcd > 10) {
                        /*try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                    }
                        System.out.printf("%s in %s %s GCD for %s and %s is %s\n", Colors.GREEN,threadType, threadName, a, b, gcd);
                }else {
                    System.out.printf("%s %s %s was interrupted\n",Colors.BLUE,threadType,threadName);
                    return;
                }
            }
        }
        System.out.printf("%s stop %s %s\n", Colors.BLUE,threadType,threadName);

    }



    public int computeGCD(int number1,int number2){
        if ( number2 == 0) {
            return number1;
        }else {
            return computeGCD(number2,number1%number2);
        }
    }
}
