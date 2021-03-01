package ru.semaphore;


import java.util.Random;
import java.util.Timer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Program {
    int operatorsCount=5;
    AtomicInteger clientsInQueue=new AtomicInteger();
    private static BlockingQueue<Client> clientsQueue = new LinkedBlockingQueue<>();
    private static boolean  working=true;
    private static Lock timerLock=new ReentrantLock();
    private static Lock queueLock=new ReentrantLock();



    public static void main(String[] args) {
        timer(20000);
        queueCreators();


    }

    private static void queueCreators(){
        new Thread(()->{
            while (working){
                queueLock.lock();
                try {
                    clientsQueue.put(new Client());
                    System.out.printf("Clients in queue: %s\n",clientsQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sleep(1000);
                queueLock.unlock();


            }
        }).start();
    }

    public static void sleep(int i) {
        try {
            Thread.sleep(new Random().nextInt(i));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void timer(long time){
        long begin= System.currentTimeMillis();
        new Thread(()->{
            while (true) {
                timerLock.lock();
                if (System.currentTimeMillis() - begin > time) {
                    working = false;
                    return;
                }
                timerLock.unlock();
            }
        }).start();
    }



}
