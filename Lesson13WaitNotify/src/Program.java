import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) throws InterruptedException {

        WaitAndNotifay wAn = new WaitAndNotifay();
        Thread thread1 = new Thread(() -> wAn.producer());
        Thread thread2 = new Thread(() -> wAn.consumer());
        thread1.start();
        thread2.start();


        thread1.join();
        thread2.join();

    }

    static class WaitAndNotifay {
        List nums = new ArrayList();
        Object o1 = new Object();
        Object o2 = new Object();

//        void producer() {
//                synchronized (this) {
//             if(nums.size() >= 10) {
//                 try {
//
//                     wait();
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//
//                }else {
//                 notify();
//                 int i=new Random().nextInt(100);
//                 nums.add(i);
//                 System.out.printf("add-%s",i);
//             }
//            }
//        }
//
//        void consumer() {
////        int i=nums.length;
//                synchronized (this) {
//            if (nums.size() < 1) {
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                }else {
//                notify();
//                System.out.printf("remove-%s",nums.get(nums.size()-1));
//                    nums.remove(nums.size()-1);
//            }
//
//            }


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
//        int i=nums.length;
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
    }
}
