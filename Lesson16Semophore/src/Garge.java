import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Garge {

   static List<Car> garage=new ArrayList<>();
     //Car[] garage=new Car[3];
    static Object o=new Object();
       static ReentrantLock lock=new ReentrantLock();
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(new Car(i,semaphore)).start();

        }


    }

    static class Car implements Runnable{
        int id;
        Semaphore semaphore;
            //ReentrantLock lock;

        public Car(int id, Semaphore semaphore
                  // ReentrantLock lock
        ) {
            this.id = id;
            this.semaphore = semaphore;
           // this.lock=lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();

                System.out.printf("Car-%s near garage...\n", this.id);
                semaphore.acquire();
                garage.add(this);
                System.out.printf("Car %s come to garge, free plase is %s\n", this.id, 3 - garage.size());
                lock.unlock();
                Thread.sleep(new Random().nextInt(3000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //lock.lock();
            synchronized (o){
            garage.remove(this);
            System.out.printf("Car %s go out from garge, free plase is %s\n", this.id, 3 - garage.size());
        }
                //lock.unlock();
            semaphore.release();
            }
        }
    }

