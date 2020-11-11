import java.util.concurrent.CountDownLatch;

public class Program {
    public static void main(String[] args) throws InterruptedException {



        CountDownLatch count=new CountDownLatch(3);
        Thread thread1=new Thread(new A(count));
        Thread thread4=new Thread(new A(count));
        Thread thread2=new Thread(new B(count));
        Thread thread3=new Thread(new C(count));
        thread1.start();
        thread4.start();
        thread2.start();
        thread3.start();
        count.await();
        System.out.println("End all");

    }
    static class A implements Runnable{
        CountDownLatch count;

        public A(CountDownLatch count) {
            this.count = count;
        }

        int a;
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                a++;
            }
            System.out.printf("a-%s\n",a);
            count.countDown();
        }
    }

    static class B implements Runnable{
        CountDownLatch count;

        public B(CountDownLatch count) {
            this.count = count;
        }

        int b;
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b++;
            }
            System.out.printf("b-%s\n",b);
            count.countDown();
        }
    }

    static class C implements Runnable{
        int c;
        CountDownLatch count;

        public C(CountDownLatch count) {
            this.count = count;
        }
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                c++;
            }
            System.out.printf("c-%s\n",c);
            count.countDown();
        }
    }




}
