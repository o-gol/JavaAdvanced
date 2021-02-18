package ru.fiboSync;
import ru.Colors;


public class Program {
    static Object o=new Object();
    static int count=1;
    static int prev=0;
    public static void main(String[] args) {

    new Thread(()->{
        fibonachi(10);
    }).start();

    new Thread(()->{
        fibonachi(10);
    }).start();



        }




    private static void fibonachi(int i2) {
        for (int i = 0; i < i2; i++) {
            calkNext();

        }
    }

    private static  void calkNext() {
        synchronized (o) {
            int temp = count + prev;
            prev = count;
            count = temp;
            /*try {
                Thread.sleep(i2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println(count);
        }
    }
//10946
//    764848393
}
















