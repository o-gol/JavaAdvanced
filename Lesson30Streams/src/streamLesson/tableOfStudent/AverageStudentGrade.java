package streamLesson.tableOfStudent;

import java.io.Serializable;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class AverageStudentGrade implements Comparable<AverageStudentGrade>, Serializable {

    private final String studentName;
    private final float averageGrade;

    public AverageStudentGrade(String studentName, float averageGrade) {
        this.studentName = studentName;
        this.averageGrade = averageGrade;
    }

    public String getStudentName() {
        return studentName;
    }

    public float getAverageGrade() {
        return averageGrade;
    }

    public static  float calcAverage(Set<SubjectGrade> subjectGrades){
        float i=0;
        if(subjectGrades!=null){
            for (SubjectGrade subjectGrade :
                    subjectGrades) {
                i+=subjectGrade.getGrade();
            }
        }
        return i/subjectGrades.size();
    }

    @Override
    public int compareTo(AverageStudentGrade o) {
        if(this.averageGrade<o.averageGrade)
            return 1;
        if(this.averageGrade>o.averageGrade)
            return -1;
        return this.studentName.compareTo(o.studentName);
    }

    @Override
    public String toString() {
        return "AverageStudentGrade{" +
                "studentName='" + studentName + '\'' +
                ", averageGrade=" + averageGrade +
                '}';
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
