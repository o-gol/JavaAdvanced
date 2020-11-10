import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Worker(i));
        }
        executorService.shutdown();
        System.out.printf("All worker start work\n");
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.printf("All worker stop work\n");

    }

    static class Worker implements Runnable {
        int id;

        public Worker(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Worker-%s finish his work\n",id);

        }
    }
}
