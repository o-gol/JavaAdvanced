import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Conections {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service= Executors.newFixedThreadPool(10);
        for (int i = 0; i <9; i++) {
            new Thread(()->{
               Conect.getInstance().work();
            }).start();
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);

        }
    static final class  Conect {
        Object o=new Object();
        private static Conect instance;
        int conectionCount;
        private static Semaphore semaphore=new Semaphore(3);
        private Conect(){

        }

        public static synchronized Conect getInstance(){
            if(instance==null){
                instance=new Conect();
            }
            return instance;

        }

        public void work(){
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            try {

            toWork();
            }finally {

            semaphore.release();
            }

        }


        private void toWork(){

            synchronized (o) {
                conectionCount++;
                System.out.println(conectionCount);
            }


            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o){
                conectionCount--;
                System.out.println(conectionCount);
            }

        }


    }

}

