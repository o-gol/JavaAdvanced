package fileIO;

import tableOfStudent.AverageStudentGrade;
import tableOfStudent.Student;
import tableOfStudent.SubjectGrade;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Program {
    private static final String FILE_IN_NAME = "Grade Book.txt";
    private static final String FILE_IN_NAME_BINARY = "Student Grade Book Binary.bin";
    private static final String FILE_OUT_NAME = "Grade Book Byte.txt";
    private static final String FILE_OUT_NAME_MATHER = "Accounts Book Mather.txt";
    private static final String FILE_BANK_ACCOUNTS = "Bank Accounts.txt";

    public static void main(String[] args) throws IOException {
        SortedMap<AverageStudentGrade, Set<SubjectGrade>> map = AverageStudentGrade.createGrades();
        Parser parser=new Parser();
        Reader reader=new Reader();
        Writer writer=new Writer();
        /*writer.writeGradesToFile(map,FILE_IN_NAME);
        reader.readGradeFromFile(FILE_IN_NAME);
        reader.byteReadWrite(FILE_IN_NAME,FILE_OUT_NAME);
        parser.parseGradeBookAndWriteInAccountBookMather(FILE_IN_NAME,FILE_OUT_NAME_MATHER);
        parser.parseWithFormatter(FILE_BANK_ACCOUNTS);*/
        Student.processorGrade(map,writer,FILE_IN_NAME_BINARY);
        List<Student> students=reader.readFromBin(FILE_IN_NAME_BINARY);
        System.out.println("After Serialize");
        for (Student s:
             students ) {
            System.out.println(s);
        }
    }







}
