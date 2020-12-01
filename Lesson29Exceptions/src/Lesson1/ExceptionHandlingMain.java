package Lesson1;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingMain {
    public static void main(String[] args)  {


        /*try {

        }catch (NullPointerException e){
            Throwable[] throwables=new Throwable[1];
            System.out.println(throwables.length);
            throwables[0]=new IOException();
            throwables=e.getSuppressed();
            System.out.println(throwables.length);
            System.out.println(throwables[0].toString());
            //e.printStackTrace();
        }*/


        try {
            doAll();
        }catch (InvelidInputParamException e){
            System.out.println("InvelidInputParamException");
            e.printStackTrace();
        }




       /* try {

            doAll();

        }
        catch (NullPointerException e) {
            System.out.println("NPE");
            System.out.println("==================================");
            Throwable[] throwables=e.getSuppressed();
            System.out.println(throwables.length);
//            throwables[0].printStackTrace();
//            throwables[2].printStackTrace();
            for (int i = 0; i < throwables.length; i++) {
                System.out.println("Suppressed Exceptions:");
//                throwables[i].printStackTrace();
                System.out.println(throwables[i]);
            }
            for (Throwable t :
                    throwables) {
                t.printStackTrace();
            }
            //e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.printf("ArrayIndexOutOfBoundsException");
        }*/

    }

    private static void doAll() {
        Scanner scanner=new Scanner(System.in);
        boolean bool=true;
//        PrintWriter printWriter=null;

        do {
            try(PrintWriter printWriter=new PrintWriter(new FileWriter("out.txt"));
               // BufferedReader bufferedReader=new BufferedReader(new FileReader("1234"))
            ) {
                System.out.println("insert a");
                int a=scanner.nextInt();
                System.out.println("insert b");
                int b=scanner.nextInt();
                int[] arr=new int[1];
                int i=arr[2];
                if(bool)
                    throw new RuntimeException("Runtaim Exeption");
//                printWriter=new PrintWriter(new FileWriter("out.txt"));
                printWriter.printf("Result-%s",delev(a,b));
                /*System.out.println(delev(a,b));
                saveToFile(delev(a,b));*/
                bool=false;
            }
            catch (ArithmeticException | InputMismatchException e) {
                System.out.println(e.toString());
                scanner.nextLine();
            }catch (IOException e){
                System.out.println("Unable file");
            }catch (IndexOutOfBoundsException e){
                System.out.printf("All exception");
                throw new InvelidInputParamException("Array index FUUUUUUUU.....in All exeption");
            }
            finally {
                System.out.println("finaly called");
                /*if(printWriter!=null)
                    printWriter.close();*/
            }


        } while (bool);
    }

    static double delev(int a,int b) throws ArithmeticException, NullPointerException{
       return //(double)
               a/
               //(double)
                       b;
    }

//    private static void saveToFile(double i) throws IOException {
//        PrintWriter printWriter=new PrintWriter(new FileWriter("out.txt"));
//        printWriter.printf("Result-%s",i);
//        printWriter.close();
//    }


}
