package ru.semaphoreExecuters;


import ru.Colors;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Program {
    private static final int operatorsCount=5;
    private static BlockingQueue<Client> clientsQueue = new LinkedBlockingQueue<>();
    private static BlockingQueue<Operator> operators = new ArrayBlockingQueue<>(operatorsCount);
    private static boolean  working=true;
    private static boolean  clientsComingIsFinished=true;
    private static Lock timerLock=new ReentrantLock();
    private static Lock queueLock=new ReentrantLock();
    private static Semaphore semaphore=new Semaphore(operatorsCount);
    private static ExecutorService service=Executors.newCachedThreadPool();



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
        clientQueueCreate();

        try {
            while (working&&clientsComingIsFinished){
                    service.submit(new OperatorServices(operators.take(),clientsQueue.take(),semaphore,operators));

            }
            while (!clientsQueue.isEmpty()){
                    service.submit(new OperatorServices(operators.take(),clientsQueue.take(),semaphore,operators));

            }
        } finally {

        service.shutdown();
        }



        service.awaitTermination(50000,TimeUnit.MILLISECONDS);


        System.out.println(Operator.getAllClients());
        System.out.println(Client.getNumbers());


        System.out.printf("%s!!!!!!!!!!!!!!!!!!!!End main!!!!!!!!!!!!!!!!!!!!!!\n",Colors.CYAN);


    }




    static void clientQueueCreate(){
        new Thread(()->{
            while (working){
                queueLock.lock();
                try {
                    clientsQueue.put(new Client());
                    System.out.printf("Clients in queue: %s\n",clientsQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sleep(50);
                queueLock.unlock();


            }
            clientsComingIsFinished=false;
        }).start();
    }

    static void sleep(int i) {
        try {
            Thread.sleep(new Random().nextInt(i));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void timer(long time){
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
