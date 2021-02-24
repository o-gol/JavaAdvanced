package ru.produserConsumer;

import ru.Colors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Program {
    static BlockingQueue<String> queue=new ArrayBlockingQueue<>(5);
    static final String[] messages =
            {
                    "What is blue?",
                    "The sky is blue!",
                    "What is green?",
                    "The grass is green!",
                    "What is yellow?",
                    "The round sun is yellow!",
                    "What is orange?",
                    "The pumpkin is orange!",
                    "What is brown?",
                    "Brown is the Earth and the ground!",
                    "What is red?",
                    "The butterfly is red!",
                    "What is pink?",
                    "The flower is pink!",
                    "What is purple?",
                    "The eggplant is purple!",
                    "What is white?",
                    "The snow that falls is white!",
                    "What is black?",
                    "Black is the sky at night!",
                    "DONE"
            };
    static String[] list=new String[5];
    static int count=0;
    static boolean end=true;
    static final Object o=new Object();


    public static void main(String[] args) {

        /*new Thread(()->{
            for (int i = 0; i < messages.length; i++) {
                try {
                    queue.put(messages[i]);
                    System.out.printf("%sPUT %s - %s\n", Colors.RED,messages[i],queue.size());
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(()->{
            while (true){

                try {
                    String cons=queue.take();
                    System.out.printf("%sGET %s - %s\n", Colors.GREEN,cons,queue.size());
                if("DONE".equals(cons))
                    return;
                Thread.sleep(new Random().nextInt(3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/
        prodConsumer();







    }


    static void prodConsumer(){

        Thread produser=new Thread(()->{

            for (int i = 0; i <messages.length ; i++) {
                synchronized (o) {

                    if(count<0||count>5) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list[count] = messages[i];
                    count++;
                    System.out.printf("%s PUT %s -%s\n", Colors.BLUE, list[count-1], count-1);
                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    o.notify();
                }

            }
        });

        Thread consumer=new Thread(()->{
                while (end) {
            synchronized (o) {
                    count--;
                    if(count<0||count>5) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if ("DONE".equals(list[count]))
                        end = false;
                    System.out.printf("%s GET %s -%s\n", Colors.GREEN, list[count], count);
                    list[count] = null;

                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    o.notify();
                }
            }
        });

        produser.start();
        consumer.start();




    }

}
