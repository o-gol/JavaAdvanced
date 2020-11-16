public class Homwork1 {
    public static void main(String[] args) throws InterruptedException {
        Object o=new Object();
        Test test=new Test(Thread.currentThread());
        Thread thread=new Thread(test);
        System.out.println(thread.getState());
        thread.start();
        synchronized (thread){
            thread.wait();
        }
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(thread.getState());
    }

    static class Test implements Runnable {
        Thread thread;
        int in=0;
        Object o = new Object();

        public Test(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getState());
            synchronized (this){
            for (int i = 0; i < 100; i++) {
                in++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println(thread.getState());
            notify();
            }

        }
    }
    }



