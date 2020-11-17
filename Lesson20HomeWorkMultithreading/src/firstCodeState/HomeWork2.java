package firstCodeState;

public class HomeWork2 {
    public static void main(String[] args) {
        Object o=new Object();
        Test3 test3=new Test3();

        Thread thread1=new Thread(() -> {
            try {
                test3.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread thread2=new Thread(() -> {
            try {
                test3.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
    }


    static class Test3{
        void get() throws InterruptedException {
            synchronized (this) {
                wait();
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(50);

                }
            }
            notify();
        }
        void put() throws InterruptedException {
            synchronized (this) {
                wait();
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(50);

                }
            }
            notify();
        }
    }




}
