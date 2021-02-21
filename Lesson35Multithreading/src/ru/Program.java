package ru;

import ru.Colors;

public class Program {

    static Object o=new Object();
    private static
    volatile
    int  count;

    public static void main(String[] args) {

        th1.start();
        th2.start();



    }

    static Thread th1=new Thread(()->{
        int local=count;
        for (int i = 0; i < 10; i++) {
            local = getLocal(local, Colors.CYAN, "Write increment count");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    static Thread th2=new Thread(()->{
        int local=count;
        while (local<10)
        if (local!=count) {
            local = getLocal(local, Colors.RED, "Read increment count");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    private static  int getLocal(int local, Colors red, String s) {
        synchronized (o) {
            System.out.println(red + s + (local + 1));
            count = ++local;
            return local;
        }
    }


}
