package ru.callableAndFuture;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class Timer {
    public Instant start;
    public Instant end;
    public double timeSecond(){
        return Duration.between(start,end).toMillis();
    }
}

public class Program {


    static ExecutorService service = Executors.newCachedThreadPool();
            static List<Future<Double>> futures=new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            futures.add(
                    service.submit(() -> {
                Timer timer=new Timer();
                timer.start= Instant.now();
                int millis=sleep(4000);
                /*if(millis>3000){
                    throw new RuntimeException("To long");
                        }*/
                timer.end=Instant.now();

                return timer.timeSecond();
            })
            );

        }
        service.shutdown();
//        service.awaitTermination(100000, TimeUnit.SECONDS);
//        Thread.sleep(10000);
        futures.parallelStream().mapToDouble(f-> {
            try {
                return f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                System.out.println(e.getMessage());
            }
            return 0;
        }).forEach(System.out::println);
        System.out.println("End main");


    }

    public static int   sleep(int i) {
        int i1 = new Random().nextInt(i);
        try {
            Thread.sleep(i1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i1;

    }

}

