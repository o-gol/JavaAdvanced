package Lesson1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingMain {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean bool=true;

        do {
            try {
                System.out.println("insert a");
                int a=scanner.nextInt();
                System.out.println("insert b");
                int b=scanner.nextInt();
                System.out.println(delev(a,b));
                bool=false;
            } catch (ArithmeticException e) {
                System.out.println(e.toString());
                scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println(e.toString());
                scanner.nextLine();

            }
        } while (bool);

    }
    static double delev(int a,int b){
       return //(double)
               a/
               //(double)
                       b;
    }
}
