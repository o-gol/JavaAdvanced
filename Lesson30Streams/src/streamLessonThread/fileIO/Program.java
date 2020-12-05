package streamLessonThread.fileIO;

import streamLessonThread.tableOfStudent.AverageStudentGrade;
import streamLessonThread.tableOfStudent.Student;
import streamLessonThread.tableOfStudent.SubjectGrade;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;


public class Program {
    private static final String FILE_IN_NAME = "Lesson30Streams\\src\\streamLessonThread\\files\\Grade Book.txt";
    private static final String FILE_IN_NAME_BINARY = "Lesson30Streams\\src\\streamLessonThread\\files\\Student Grade Book Binary.bin";
    private static final String FILE_OUT_NAME = "Lesson30Streams\\src\\streamLessonThread\\files\\Grade Book Byte.txt";
    private static final String FILE_OUT_NAME_MATHER = "Lesson30Streams\\src\\streamLessonThread\\files\\Accounts Book Mather.txt";
    private static final String FILE_BANK_ACCOUNTS = "Lesson30Streams\\src\\streamLessonThread\\files\\Bank Accounts.txt";

    public static void main(String[] args) throws IOException {
        double t1=System.currentTimeMillis();
        SortedMap<AverageStudentGrade, Set<SubjectGrade>> map = AverageStudentGrade.createGrades();
        Parser parser=new Parser();
        Reader reader=new Reader();
        Writer writer=new Writer();
        writer.writeGradesToFile(map,FILE_IN_NAME);
        Thread thread1=new Thread(() -> {
            try {
                reader.readGradeFromFile(FILE_IN_NAME);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread thread2=new Thread(() -> {
            try {
                reader.byteReadWrite(FILE_IN_NAME,FILE_OUT_NAME);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread thread3=new Thread(() -> {
            try {
                parser.parseGradeBookAndWriteInAccountBookMather(FILE_IN_NAME,FILE_OUT_NAME_MATHER);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        /*Thread thread4=new Thread(() -> {
            try {
                parser.parseWithFormatter(FILE_BANK_ACCOUNTS);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });*/

        Thread thread5=new Thread(() -> {
            Student.processorGrade(map,writer,FILE_IN_NAME_BINARY);
        });
        thread1.start();
        thread2.start();
        thread3.start();
//        thread4.start();
        thread5.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
//            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Student> students=reader.readFromBin(FILE_IN_NAME_BINARY);
        System.out.println("After Serialize");
        for (Student s:
             students ) {
            System.out.println(s);
        }
        double t2=System.currentTimeMillis();
        System.out.println(t2-t1);
    }








}
