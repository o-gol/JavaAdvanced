import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Program {
    public static void main(String[] args) {

        Task task=new Task();
        Thread thread1=new Thread(() -> task.firstThread());
        Thread thread2=new Thread(() -> task.secondThread());

        thread1.start();
        thread2.start();
        try {
        thread1.join();
        thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task.seeCount();


    }
    static class  Task{
        Lock lock= new ReentrantLock();
        int count;
        void inctrement(){
            for (int i = 0; i < 1000000; i++) {
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                lock.lock();
                count++;
                lock.unlock();
            }
        }

        void firstThread(){
            inctrement();
        }

        void secondThread(){
            inctrement();
        }

        public void seeCount() {
            System.out.println(count);;
        }
    }
}
