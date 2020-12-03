package fileWriter;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Program {
    private static final String FILE_IN_NAME = "Grade Book.txt";
    private static final String FILE_OUT_NAME = "Grade Book Byte.txt";
    private static final String FILE_OUT_NAME_MATHER = "Accounts Book Mather.txt";
    private static final String FILE_BANK_ACCOUNTS = "Bank Accounts.txt";

    public static void main(String[] args) throws IOException {
//        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> map = createGrades();
//        writeGradesToFile(map);
//        readGradeFromFile();
//        byteReadWrite();
        Pattern pattern =Pattern.compile("studentName");
        Matcher matcher=pattern.matcher(FILE_IN_NAME);

        while (matcher.find()){
            System.out.println("Start");
            try (FileWriter writer=new FileWriter(FILE_OUT_NAME_MATHER);){
                writer.write(matcher.group());

            }
            System.out.println("End");
        }


        /*try (
                Scanner scanner = new Scanner(System.in);
                Formatter formatter = new Formatter(FILE_BANK_ACCOUNTS);
                )
        {

            for (int i = 0; i < 3; i++) {
                System.out.println("Input id,name,balance");
                formatter.format("id account-%s, name account-%s, balance of account-%s\n",
                        scanner.nextLine(),
                        scanner.nextLine(),
                        scanner.nextLine())

                ;

            }
        }*/


    }

    private static void byteReadWrite() throws IOException {
        try (FileInputStream byteReader = new FileInputStream(FILE_IN_NAME);
             FileOutputStream byteWriter = new FileOutputStream(FILE_OUT_NAME)) {

            byte[] arrByte = byteReader.readAllBytes();
            for (int i = 0; i < arrByte.length; i++) {
                System.out.print(arrByte[i]);
            }
            byteWriter.write(arrByte);
            System.out.println("Byte read/write finished");

        }
    }


    private static void readGradeFromFile() throws IOException {
        FileReader fileReader = new FileReader(FILE_IN_NAME);
        System.out.println(fileReader.getEncoding());
        BufferedReader buffReader = new BufferedReader(fileReader);
        String s;
        while ((s = buffReader.readLine()) != null) {
            System.out.println(s);
        }
        System.out.println();
        fileReader = new FileReader(FILE_IN_NAME);

        int c;
        while ((c = fileReader.read()) != -1) {
            System.out.print(c);
            if (c == 10)
                System.out.println();
            if (c == 32)
                System.out.print(" ");
        }
    }

    private static void writeGradesToFile(NavigableMap<AverageStudentGrade, Set<SubjectGrade>> map) throws IOException {

        try (FileWriter writer = new FileWriter(FILE_IN_NAME)) {
            for (AverageStudentGrade grade :
                    map.keySet()) {
                /*System.out.println(String.format("============================================\n"));
                System.out.println(String.format(String.format("%s\n",grade)));*/
                writer.write("============================================\n\n");

                writer.write(String.format("%s\n\n", grade));
                for (SubjectGrade subjectGrade :
                        map.get(grade)) {
                    writer.write(String.format("%s\n", subjectGrade));

                }
            }
        }
        System.out.printf("Info was write in file %s\n", FILE_IN_NAME);
    }

    private static NavigableMap<AverageStudentGrade, Set<SubjectGrade>> createGrades() {
        Set<SubjectGrade> alexGrades = new TreeSet<>();
        alexGrades.add(new SubjectGrade("Mathema", 67));
        alexGrades.add(new SubjectGrade("Leterat", 56));
        alexGrades.add(new SubjectGrade("Phisic", 78));
        alexGrades.add(new SubjectGrade("Sport", 58));

        Set<SubjectGrade> johnGrades = new TreeSet<>();
        johnGrades.add(new SubjectGrade("Mathema", 78));
        johnGrades.add(new SubjectGrade("Leterat", 66));
        johnGrades.add(new SubjectGrade("Phisic", 90));
        johnGrades.add(new SubjectGrade("Sport", 47));

        Set<SubjectGrade> jessicaGrades = new TreeSet<>();
        jessicaGrades.add(new SubjectGrade("Mathema", 80));
        jessicaGrades.add(new SubjectGrade("Leterat", 78));
        jessicaGrades.add(new SubjectGrade("Phisic", 80));
        jessicaGrades.add(new SubjectGrade("Sport", 79));

        Set<SubjectGrade> taniaGrades = new TreeSet<>();
        taniaGrades.add(new SubjectGrade("Mathema", 78));
        taniaGrades.add(new SubjectGrade("Leterat", 88));
        taniaGrades.add(new SubjectGrade("Phisic", 76));
        taniaGrades.add(new SubjectGrade("Sport", 75));

        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> map = new TreeMap<>();
        map.put(new AverageStudentGrade("Alex", AverageStudentGrade.calcAverage(alexGrades)), alexGrades);
        map.put(new AverageStudentGrade("John", AverageStudentGrade.calcAverage(johnGrades)), johnGrades);
        map.put(new AverageStudentGrade("Jessica", AverageStudentGrade.calcAverage(jessicaGrades)), jessicaGrades);
        map.put(new AverageStudentGrade("Tania", AverageStudentGrade.calcAverage(taniaGrades)), taniaGrades);

        return map;
    }
}
