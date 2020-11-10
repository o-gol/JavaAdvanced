import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Program {
    static BlockingQueue blockingQueue=new  ArrayBlockingQueue<>(10);


    public static void main(String[] args) {
        //Program program=new Program();
        new Thread(()->produce()).start();
        new Thread(()->consumer()).start();


    }

    static void produce(){
        while (true){
            try {
                Thread.sleep(new Random().nextInt(1000));
                blockingQueue.put(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.printf("         %s\n",blockingQueue.size());
        }

    }

    static void consumer(){
        while (true){
        try {
        Thread.sleep(new Random().nextInt(1000));

        System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("         %s\n",blockingQueue.size());
        }
    }
}
