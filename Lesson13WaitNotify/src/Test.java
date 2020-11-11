public class Test {
    public static void main(String[] args) {
        TastWaitAndNotifay wAn = new TastWaitAndNotifay();
        Thread thread1 = new Thread(() -> wAn.producer());
        Thread thread2 = new Thread(() -> wAn.consumer());
        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(wAn.i);
    }

    static class TastWaitAndNotifay{
        int i;
        int icons;

        void producer(){
            for (int j = 0; j <1000 ; j++) {
                synchronized (this){
                    if(icons<999) {
                        System.out.printf("Prod start-%s-%s\n", i, j);
                        i++;
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.printf("Prod stop-%s-%s\n", i, j);
                    }else  {
                        System.out.printf("Prod start-%s-%s\n", i, j);
                        int z = i;
                        z++;
                        i = z;
                        System.out.printf("Prod stop-%s-%s\n", i, j);
                    }
                }
            }
        }

        void consumer(){
            for (int j = 0; j <1000 ; j++) {
                synchronized (this){
                    try {
                        Thread.sleep(59);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("Cons start-%s-%s\n",i,j);
                    notify();
                    i++;
                    System.out.printf("Cons stop-%s-%s\n",i,j);
                    icons=j;
                }
            }
        }
    }


}
