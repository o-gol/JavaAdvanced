package firstCodeState;

public class Homwork1 {
    public static void main(String[] args) throws InterruptedException {
         //Object o=new Object();
        Test test=new Test(Thread.currentThread());
        //Test test2=new Test(Thread.currentThread());

        Thread thread=new Thread(test);
        //Thread thread2=new Thread(test2);
        System.out.printf("%s-%s\n",thread.getState(),thread);    //NEW
        thread.start();
        //thread2.start();

        synchronized (thread){
            thread.wait(3000);
        }

        System.out.printf("%s-%s\n",thread.getState(),thread);    //TIME-WAITING


        synchronized (thread){
            thread.wait();

        //System.out.printf("%s-%s\n",thread.getState(),thread);    //TIME-WAITING
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s-%s\n",thread.getState(),thread);    //TERMINATED
    }

    static class Test implements Runnable {
        Thread thread;
        int in=0;
        //Object o=new Object();

        public Test(Thread thread
                //,Object o
        ) {
            this.thread = thread;
            //this.o=o;
        }

        @Override
        public void run() {
            System.out.printf("%s-%s\n",Thread.currentThread().getState(),Thread.currentThread());    //RUNNABLE
            synchronized (this){
            for (int i = 0; i < 100; i++) {
                in++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            //System.out.println(thread.getState());

            }
            synchronized (this){
            for (int i = 0; i < 100; i++) {
                in++;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.printf("%s-%s\n",thread.getState(),thread);  //WAITING (MAIN)
            notify();
            }


        }
    }
    static class Test2 implements Runnable {
        Thread thread;
        int in=0;

        public Test2(Thread thread) {
            this.thread = thread;
        }

        public Test2() {
        }

        @Override
        public void run() {
            System.out.printf("%s-%s\n",Thread.currentThread().getState(),Thread.currentThread());    //RUNNABLE
            synchronized (this){
            for (int i = 0; i < 100; i++) {
                in++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            //System.out.println(thread.getState());

            }
            synchronized (this){
            for (int i = 0; i < 100; i++) {
                in++;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.printf("%s-%s\n",thread.getState(),thread);  //WAITING (MAIN)
            notify();
            }


        }
    }
    }



