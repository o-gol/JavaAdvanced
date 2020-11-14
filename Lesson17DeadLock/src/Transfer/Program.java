package Transfer;

import javax.xml.crypto.Data;
import java.util.Timer;

public class Program {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
        long time1 = System.currentTimeMillis();


        for (int j = 0; j < 1000; j++) {

            Runner runner = new Runner();
            Thread first = new Thread(() -> runner.firstThread());
            Thread second = new Thread(() -> runner.secondThread());
            first.start();
            second.start();

            try {
                first.join();
                second.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (runner.finish() != 20000) {
                count++;
                System.out.println("FAIL " + runner.finish() + " " + count);
            }

        }
        long time2 = System.currentTimeMillis();

        System.out.println(time2 - time1);
    }
    }



}
