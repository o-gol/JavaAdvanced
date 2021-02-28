package ru.produserConsumer;

import ru.Colors;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Program {
    private static final BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
    private static final String[] messages =
            {
                    "1 What is blue?",
                    "2 The sky is blue!",
                    "3 What is green?",
                    "4 The grass is green!",
                    "5 What is yellow?",
                    "6 The round sun is yellow!",
                    "7 What is orange?",
                    "8 The pumpkin is orange!",
                    "9 What is brown?",
                    "10 Brown is the Earth and the ground!",
                    "11 What is red?",
                    "12 The butterfly is red!",
                    "13 What is pink?",
                    "14 The flower is pink!",
                    "15 What is purple?",
                    "16 The eggplant is purple!",
                    "17 What is white?",
                    "18 The snow that falls is white!",
                    "19 What is black?",
                    "20 Black is the sky at night!",
                    "21 DONE",
                    "22 WERE"
            };
    private static final String[] listQueue = new String[5];
    private static final String[] listStack = new String[5];
    private static final String[] listReentrantLock  = new String[5];
    private static volatile int countQueue = 0;
    private static volatile int countStack = 0;
    private static  int countReentrantLock  = 0;
    private static boolean endPutQueue = true;
    private static boolean endPutStack = true;
    private static boolean endPutReentrantLock  = true;
    private static int endPutReentrantLock1  = 0;
    private static final Object oQueue = new Object();
    private static final Object oStack = new Object();
    private static final Lock lock=new ReentrantLock(true);
    private static final Condition conditionProd=lock.newCondition();
    private static final Condition conditionCons=lock.newCondition();


    public static void main(String[] args) {

//        prodConsumerBlockingQueue();
//        prodConsumerStack();
//        prodConsumerQueue();
        prodConsumerReentrantLock();


    }


    private static void prodConsumerBlockingQueue() {
        new Thread(() -> {
            for (String message : messages) {
                try {
                    System.out.printf("%sPUT %s - %s\n", Colors.RED, message, queue.size());
                    queue.put(message);
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(() -> {
            while (true) {

                try {
                    String cons = queue.take();
                    System.out.printf("%sGET %s - %s\n", Colors.PURPLE, cons, queue.size());
                    if (!messages[messages.length - 1].equals(cons))
                        sleep(1000);
                    else return;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void prodConsumerStack(){

        new Thread(()->{

            for (String message : messages) {
                synchronized (oStack) {
                    if (countStack > 4) {
                        try {
                            oStack.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    listStack[countStack] = message;
                    System.out.printf("%s   PUT %s size %s\n", Colors.BLUE, listStack[countStack], countStack);
                    countStack++;
                    oStack.notify();
                }
                sleep(3000);

            }
            synchronized (oStack){
                oStack.notify();
            endPutStack=false;
            }
        }).start();

        new Thread(()->{
                while (true) {
            synchronized (oStack) {
                    if(countStack<0||(countStack==0&&listStack[countStack]==null&&endPutStack)) {
                        try {
                            oStack.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if((countStack==0&&listStack[countStack]==null&&!endPutStack)){
                        return;
                    }
                    if(countStack==0){
//                    if ("DONE".equals(list[count]))
//                        end = false;
                        String cons=listStack[countStack];
                        listStack[countStack] = null;
                        System.out.printf("%s   GET %s size %s\n", Colors.GREEN, cons, countStack);
                        countStack--;
                    }else {
//                    if ("DONE".equals(list[count-1]))
//                        end = false;
                        String cons = listStack[countStack - 1];
                        listStack[countStack - 1] = null;
                        System.out.printf("%s   GET %s size %s\n", Colors.GREEN, cons, countStack - 1);
                        countStack--;
                    }
                    oStack.notify();

                }
                    sleep(20);
                }
        }).start();






    }

    private static void prodConsumerQueue() {

        new Thread(() -> {

            for (String message : messages) {
                synchronized (oQueue) {
                    if (countQueue > 4) {
                        try {
                            oQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    listQueue[countQueue] = message;
                    System.out.printf("%s       PUT %s size %s\n", Colors.RESET, listQueue[countQueue], countQueue);
                    countQueue++;
                    oQueue.notify();
                }
                sleep(1500);

            }
            synchronized (oQueue) {
                oQueue.notify();
                endPutQueue = false;
            }
        }).start();

        new Thread(() -> {
            while (true) {
                sleep(50);
                synchronized (oQueue) {
                    if (countQueue < 0 || (countQueue == 0 && listQueue[0] == null && endPutQueue)) {
                        try {
                            oQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if ((countQueue == 0 && listQueue[countQueue] == null && !endPutQueue)) {
                        return;
                    }
                    String cons = listQueue[0];
                    listQueue[0] = null;
                    for (int i = 1; i < listQueue.length; i++) {
                        if (listQueue[i] != null) {
                            listQueue[i - 1] = listQueue[i];
                            listQueue[i] = null;
                        } else
                            break;
                    }

                    System.out.printf("%s       GET %s size %s\n", Colors.CYAN, cons, countQueue - 1);
                    countQueue--;
                    oQueue.notify();

                }
            }
        }).start();


    }

    private static void prodConsumerReentrantLock () {

        new Thread(() -> {


            for (String message : messages) {
                lock.lock();
                try {
                    if (countReentrantLock > 4) {
                        try {
                            conditionProd.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    listReentrantLock[countReentrantLock] = message;
                    System.out.printf("%s           PUT %s size %s\n", Colors.RESET, listReentrantLock[countReentrantLock], countReentrantLock);
                    countReentrantLock++;
                    endPutReentrantLock1++;
                    conditionCons.signal();
                } finally {
                    lock.unlock();
                }
//                    sleep(150);

            }
            /*lock.lock();
            conditionCons.signal();
            endPutReentrantLock = false;
            lock.unlock();*/
        }).start();

        new Thread(() -> {
            while (true) {
//                sleep(2000);
                lock.lock();
                try {
                if (countReentrantLock < 0 || (countReentrantLock == 0 && listReentrantLock[0] == null && endPutReentrantLock1!=messages.length)) {
//                if (countReentrantLock < 0 || (countReentrantLock == 0 && listReentrantLock[0] == null && endPutReentrantLock)) {
                    try {
                        conditionCons.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if ((countReentrantLock == 0 && listReentrantLock[0] == null && endPutReentrantLock1==messages.length)) {
                    return;
                }
                String cons = listReentrantLock[0];
                listReentrantLock[0] = null;
                for (int i = 1; i < listReentrantLock.length; i++) {
                    if (listReentrantLock[i] != null) {
                        listReentrantLock[i - 1] = listReentrantLock[i];
                        listReentrantLock[i] = null;
                    } else
                        break;
                }

                System.out.printf("%s           GET %s size %s\n", Colors.CYAN, cons, countReentrantLock - 1);
                countReentrantLock--;
                conditionProd.signal();
                }finally{
                lock.unlock();
            }

            }
        }).start();


    }

    private static void sleep(int i) {
        try {
            Thread.sleep(new Random().nextInt(i));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
