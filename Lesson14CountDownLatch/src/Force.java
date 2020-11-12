import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Force {
    public static void main(String[] args)  {
        CountDownLatch count=new CountDownLatch(5);
        CountDownLatch count2=new CountDownLatch(1);

        for (int i = 0; i <5; i++) {
            new Thread(new Car(i,count2,count)).start();

        }

        new Thread(new Start(count2,count)).start();


//        for (int i = 0; i <3; i++) {
//            new Thread(new Car(i,count)).start();
//
//        }


    }

    static class Car implements Runnable{
        int speed;
        int id;
        private CountDownLatch count;
        private CountDownLatch count2;


        public Car(int id, CountDownLatch count,CountDownLatch count2) {
            this.id = id;
            this.count = count;
            this.count2=count2;
        }


        @Override
        public void run() {
            int z=0;
            for (int i = 0; i < new Random().nextInt(1000); i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                z++;
            }
            System.out.println("Car "+id+" on start with "+z);
            count2.countDown();
            if(count!=null) {
                try {
                    count.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Car "+id+" started");
            for (int i = 0; i <new Random().nextInt(1000); i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                speed++;
            }
            System.out.println("Car "+id+" finish, with "+speed);

        }
    }
    static class Start implements Runnable{
        CountDownLatch count;
        CountDownLatch count2;

        public Start(CountDownLatch count, CountDownLatch count2) {
            this.count = count;
            this.count2 = count2;
        }

        @Override
        public void run() {
            try {
                count2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
            System.out.println("На старт!");
            Thread.sleep(1000);
            System.out.println("Внимание");
            Thread.sleep(1000);
            System.out.println("Марш");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count.countDown();

        }
    }



}
