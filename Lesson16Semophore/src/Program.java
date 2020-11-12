import java.util.concurrent.Semaphore;

public class Program {
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore=new Semaphore(3);
        semaphore.acquire();
        semaphore.acquire();
        semaphore.acquire();
        System.out.println("All permits have bean aq");
        //semaphore.release();
        semaphore.acquire();
        System.out.println("neve see");

    }
}
