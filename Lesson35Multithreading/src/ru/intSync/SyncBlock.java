package ru.intSync;

import java.util.ArrayList;
import java.util.List;

public class SyncBlock {
    Object o1=new Object();
    Object o2=new Object();

    int[] a={0,1,2,3,4,5,6,7,8,9,10};
    int[] b={0,11,12,13,14,15,16,17,18,19,20};
    List<Integer> list1=new ArrayList<>();
    List<Integer> list2=new ArrayList<>();

    public static void main(String[] args) {
        SyncBlock syncBlock=new SyncBlock();
        syncBlock.copy();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
    private void copy(){

        long start=System.currentTimeMillis();
        CounterA aC=new CounterA();
        CounterB bC=new CounterB();
        Thread th1=new Thread(aC);
        Thread th11=new Thread(aC);
        Thread th2=new Thread(bC);
        Thread th22=new Thread(bC);
        th1.start();
//        th11.start();
        th2.start();
//        th22.start();
        try {
            th1.join();
            th11.join();
            th2.join();
            th22.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);



    }

    private  void copyA(){
        synchronized (o1) {
            for (int i = 0; i < a.length; i++) {
                list1.add(a[i]);
                System.out.println(list1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private  void copyB(){
        synchronized (o2) {
            for (int i = 0; i < b.length; i++) {
                list2.add(b[i]);
                System.out.println(list2);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class CounterA implements Runnable {

        @Override
        public void run() {
            copyA();

        }
    }
    private class CounterB implements Runnable {

        @Override
        public void run() {
            copyB();

        }
    }

}
