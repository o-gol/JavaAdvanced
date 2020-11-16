import java.util.Random;

public class Program {
    public static void main(String[] args)  {
        Thread thread=new Thread(() -> {
            while (true){
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                    break;
//                }

                if (Thread.currentThread().isInterrupted()){
                    System.out.println("Thred stop");
                    break;
                }
                Math.sin(new Random().nextDouble());
            }
        });
        System.out.println("Start ");
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finish ");
    }

}
