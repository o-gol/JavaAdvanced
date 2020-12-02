package fileWriter;

import java.util.Set;

public class AverageStudentGrade implements Comparable<AverageStudentGrade>{

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
}
