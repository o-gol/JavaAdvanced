package fileWriter;

import java.util.Set;

public class SubjectGrade implements Comparable<SubjectGrade> {

    private final String subject;
    private final float grade;

    public SubjectGrade(String subject, float grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public float getGrade() {
        return grade;
    }

    @Override
    public int compareTo(SubjectGrade o) {
        return subject.compareTo(o.subject);
    }

    @Override
    public String toString() {
        return "SubjectGrade{" +
                "subject='" + subject + '\'' +
                ", grade=" + grade +
                '}';
    }
}
