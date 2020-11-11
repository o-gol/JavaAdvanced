import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) throws InterruptedException {

        WaitAndNotifay wAn = new WaitAndNotifay();
        Thread thread1 = new Thread(() -> wAn.producer());
        Thread thread3 = new Thread(() -> wAn.producer());
        Thread thread2 = new Thread(() -> wAn.consumer());
        thread3.start();
        thread1.start();
        thread2.start();


        thread1.join();
        thread2.join();

    }

    static class WaitAndNotifay {
        List nums = new ArrayList();
        final Object o1 = new Object();
        int ind;


//-----------------------------------Queue metodes

        void producer() {

    while(true) {
        synchronized (o1) {
            if (nums.size() >= 10) {
                try {

                    o1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else if(ind<=10&&ind>=0) {
                o1.notifyAll();
                int i = new Random().nextInt(100);
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                nums.add(i);
                System.out.printf("add-%s\n", i);
                ind++;
            }
        }
    }
        }

        void consumer() {

            while(true){
                synchronized (o1) {
                    if (nums.size() < 1) {
                        try {
                            o1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    } else if(ind<=10&&ind>=0) {
                        o1.notifyAll();
                        try {
                            Thread.sleep(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.printf("remove-%s\n", nums.get(0));
                        nums.remove(0);
                        ind--;

                    }

                }
            }


        }

//-----------------------------------End Queue metodes



/*-----------------------------------Stack metodes

        void producer() {

    while(true) {
        synchronized (o1) {
            if (nums.size() >= 10) {
                try {

                    o1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                o1.notifyAll();
                int i = new Random().nextInt(100);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                nums.add(i);
                System.out.printf("add-%s\n", i);
            }
        }
    }
        }

        void consumer() {

            while(true){
                synchronized (o1) {
                    if (nums.size() < 1) {
                        try {
                            o1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    } else {
                        o1.notifyAll();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.printf("remove-%s\n", nums.get(nums.size() - 1));
                        nums.remove(nums.size() - 1);

                    }

                }
            }


        }

----------------------------------------End Stack metodes*/ //-------Stack metodes

    }
}
