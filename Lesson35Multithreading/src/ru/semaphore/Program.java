package ru.semaphore;


import ru.Colors;

import java.util.Random;
import java.util.Timer;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Program {
    private static final int operatorsCount=5;
    AtomicInteger clientsInQueue=new AtomicInteger();
    private static BlockingQueue<Client> clientsQueue = new LinkedBlockingQueue<>();
    private static BlockingQueue<Operator> operators = new ArrayBlockingQueue<>(operatorsCount);
    private static boolean  working=true;
    private static Lock timerLock=new ReentrantLock();
    private static Lock queueLock=new ReentrantLock();
    private static Semaphore semaphore=new Semaphore(operatorsCount);



    public static void main(String[] args) throws InterruptedException {
        timer(3000);
        for (int i = 0; i < operatorsCount; i++) {
            try {
                operators.put(new Operator(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Working operators "+operators.size());
        queueCreators();
        /*while (working&&clientsQueue.isEmpty())
            doWork(operators.take(),clientsQueue.take());*/
        doWork();


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
                sleep(500);
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

    /*private static void doWork(Operator operator, Client client){
            new Thread(() -> {

                try {
                    semaphore.acquire();
                    operator.getClient(client);
                    operators.put(operator);
                    System.out.printf("%s                                       Operator %s free and in operators %s client size is %s empty %s \n"
                            , Colors.GREEN, operator.getName(), operators.size(), clientsQueue.size(), clientsQueue.isEmpty());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();

                }


            }).start();

    }*/

    private static void doWork(){
        while (
                working
                &&clientsQueue.isEmpty()
        ) {
            new Thread(() -> {

                try {
                    semaphore.acquire();
                    Operator operator=operators.take();
                    operator.getClient(clientsQueue.take());
                    operators.put(operator);
                    System.out.printf("%s                                       Operator %s free and in operators %s client size is %s empty %s working is %s\n"
                            , Colors.GREEN, operator.getName(), operators.size(), clientsQueue.size(), clientsQueue.isEmpty(),working);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();

                }


            }).start();
            /*if (!working)
                return;*/
        }
    }



}
