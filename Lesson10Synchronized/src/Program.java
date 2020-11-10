import java.util.ArrayList;
import java.util.Random;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        Worker worker=new Worker();
        worker.main();
    }

    static class Worker {
        Object o=new Object();

        ArrayList arr1=new ArrayList();
        ArrayList arr2=new ArrayList();

        //synchronized
        void  addToList(ArrayList arrayList) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o) {
                arrayList.add(new Random().nextInt(100));
            }
        }

        void work() throws InterruptedException {
            Thread thread1=new Thread(()->{
                for (int i = 0; i <1000 ; i++) {
                    addToList(arr1);
                    addToList(arr2);
            }
            });

            Thread thread2=new Thread(()->{
                for (int i = 0; i <1000 ; i++) {
                    addToList(arr1);
                    addToList(arr2);
            }
            });


            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            System.out.printf("list1-%s\n",arr1.size());
            System.out.printf("list2-%s\n",arr2.size());
        }



        void main() throws InterruptedException {
            long start=System.currentTimeMillis();
            work();
            long finish=System.currentTimeMillis();
            System.out.printf("time of program-%s",finish-start);



        }
    }
}
