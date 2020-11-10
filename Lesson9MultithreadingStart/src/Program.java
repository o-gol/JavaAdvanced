import java.util.Scanner;

public class Program {
    Object o=new Object();
    int counter;
    boolean flag1=true;
    boolean flag2=true;
    public static void main(String[] args) throws InterruptedException {
        Program program=new Program();
        program.doWork();
        //Thread.sleep(4000);
       // System.out.println(program.counter);
       // while (program.flag1||program.flag2){};
       // System.out.println(program.counter);
//        MyThread myThread1=new MyThread();
//        myThread1.start();
//
//        new Thread(()->{
//
//            for (int i = 0; i < 1000; i++) {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("thread-1");
//            }
//        }).start();
//        new Thread(()->{
//
//            for (int i = 0; i < 1000; i++) {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("thread-2");
//            }
//        }).start();
//        Scanner scanner=new Scanner(System.in);
//        scanner.nextLine();
//        myThread1.shotdown();
//
//        //Thread.sleep(3000);
//        System.out.println("main");
    }
    void doWork() throws InterruptedException {
        Thread thread1=new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               synchronized (o){counter++;}
                //counter++;
                //System.out.println(counter);

            }

        });thread1.start();

        Thread thread2=new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o){counter++;}
                //counter++;
                //System.out.println(counter);

            }

        });thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter);

    }

}
