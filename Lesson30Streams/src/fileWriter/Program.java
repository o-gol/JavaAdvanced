package fileWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Program {
    public static void main(String[] args) {
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> map = createGrades();
        FileWriter writer = null;
        try {

            writer = new FileWriter("Grade Book.txt");
            for (AverageStudentGrade grade :
                    map.keySet()) {
                /*System.out.println(String.format("============================================\n"));
                System.out.println(String.format(String.format("%s\n",grade)));*/
                writer.write(String.format("============================================\n"));
                writer.write(String.format("%s\n", grade));
                for (SubjectGrade subjectGrade :
                        map.get(grade)) {
                    writer.write(String.format("%s\n", subjectGrade));

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public static NavigableMap<AverageStudentGrade, Set<SubjectGrade>> createGrades() {
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
