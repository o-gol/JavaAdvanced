package streamLessonThread.tableOfStudent;

import streamLessonThread.fileIO.Writer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;

public class Student implements Serializable {
    private float averageGrade;
    private String name;
    private Set<SubjectGrade> grades;

    public Student(float averageGrade, String name, Set<SubjectGrade> grades) {
        this.averageGrade = averageGrade;
        this.name = name;
        this.grades = grades;
    }

    public float getAverageGrade() {
        return averageGrade;
    }

    public String getName() {
        return name;
    }

    public Set<SubjectGrade> getGrades() {
        return grades;
    }

    public static void processorGrade(SortedMap<AverageStudentGrade, Set<SubjectGrade>> map,
                                      Writer writer,
                                      String fileIn){
        List<Object> students=new ArrayList<>();

        /*for (AverageStudentGrade a:
                map.keySet()) {
            students.add(new Student(a.getAverageGrade(),a.getStudentName(),map.get(a)));
        }*/ // Другой способ перебора Map'a

        for (SortedMap.Entry<AverageStudentGrade,Set<SubjectGrade>> a :
                map.entrySet()) {
            students.add(new Student(a.getKey().getAverageGrade(),
                    a.getKey().getStudentName(),
                    a.getValue()));
        }
        System.out.println("Before Serialize");
        for (Object o:
                students ) {
            Student s=(Student)o;
            System.out.println(s);
        }

        writer.writeList(students,fileIn);



    }



        @Override
    public String toString() {

        return "Student{" +
                "averageGrade=" + averageGrade +
                ", name='" + name + '\'' +
                ", grades=" + grades +
                "super=" + super.toString() +
                '}';
    }
}
