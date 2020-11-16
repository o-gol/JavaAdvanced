public class Homwork1 {
    public static void main(String[] args) {
        Object o=new Object();
        Test test=new Test();
        Thread thread=new Thread(test);
        System.out.println(thread.getState());
        thread.start();
        try {
            Thread.currentThread().wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());


        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }

    static class Test implements Runnable{
        Object o=new Object();
        @Override
        public void run() {
               System.out.println(Thread.currentThread().getState());
           synchronized (o){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
               System.out.println(Thread.currentThread().getState());
           }
           //notify();


        }
    }

}


