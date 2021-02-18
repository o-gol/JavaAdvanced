package ru;

import ru.Colors;

public class Program {


    private static volatile int  count;

    public static void main(String[] args) {

        th1.start();
        th2.start();



    }

    static Thread th1=new Thread(()->{
        int local=count;
        for (int i = 0; i < 10; i++) {
            System.out.println(Colors.CYAN+"Write increment count"+(local+1));
            count=++local;
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
            System.out.println(Colors.RED+"Read increment count"+(local+1));
            count=++local;
            /*try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    });


}
