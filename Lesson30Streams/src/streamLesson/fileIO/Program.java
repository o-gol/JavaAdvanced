package streamLesson.fileIO;

import streamLesson.tableOfStudent.AverageStudentGrade;
import streamLesson.tableOfStudent.Student;
import streamLesson.tableOfStudent.SubjectGrade;

import java.io.*;
import java.util.*;


public class Program {
    private static final String FILE_IN_NAME = "Lesson30Streams\\src\\streamLesson\\files\\Grade Book.txt";
    private static final String FILE_IN_NAME_BINARY = "Lesson30Streams\\src\\streamLesson\\files\\Student Grade Book Binary.bin";
    private static final String FILE_OUT_NAME = "Lesson30Streams\\src\\streamLesson\\files\\Grade Book Byte.txt";
    private static final String FILE_OUT_NAME_MATHER = "Lesson30Streams\\src\\streamLesson\\files\\Accounts Book Mather.txt";
    private static final String FILE_BANK_ACCOUNTS = "Lesson30Streams\\src\\streamLesson\\files\\Bank Accounts.txt";

    public static void main(String[] args) throws IOException {

        double t1=System.currentTimeMillis();
        SortedMap<AverageStudentGrade, Set<SubjectGrade>> map = AverageStudentGrade.createGrades();
        Parser parser=new Parser();
        Reader reader=new Reader();
        Writer writer=new Writer();
        /*writer.writeGradesToFile(map,FILE_IN_NAME);
        reader.readGradeFromFile(FILE_IN_NAME);
        reader.byteReadWrite(FILE_IN_NAME,FILE_OUT_NAME);
        parser.parseGradeBookAndWriteInAccountBookMather(FILE_IN_NAME,FILE_OUT_NAME_MATHER);
        parser.parseWithFormatter(FILE_BANK_ACCOUNTS);*/
        /*Student.processorGrade(map,writer,FILE_IN_NAME_BINARY);
        List<Student> students=reader.readFromBin(FILE_IN_NAME_BINARY);
        System.out.println("After Serialize");
        for (Student s:
             students ) {
            System.out.println(s);
        }*/
        System.out.println(System.getProperty("user.dir"));
        double t2=System.currentTimeMillis();
        System.out.println(t2-t1);
        FileShower fileShower=new FileShower("Lesson1.bit");
        fileShower.showAll();

    }







}
