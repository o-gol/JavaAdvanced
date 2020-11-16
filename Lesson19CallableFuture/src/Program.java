import java.util.Random;
import java.util.concurrent.*;

public class Program {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(1);
        Future<Integer> future= service.submit(() -> {
            System.out.println("Start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finish");
            int num=new Random().nextInt(100);
            if (num<50){
                throw new Exception("It num <50");
            }
            return num;
        });
        service.shutdown();
//        try {
//            service.awaitTermination(1, TimeUnit.DAYS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        try {
            int num =future.get();         //get дожидается окончания выполнения потока
        System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable ex=e.getCause();
            System.out.println(e.getMessage());
            System.out.println(ex.getMessage());
        }
    }
}
