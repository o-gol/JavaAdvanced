package streamLessonThread.fileIO;

import streamLessonThread.tableOfStudent.AverageStudentGrade;
import streamLessonThread.tableOfStudent.Student;
import streamLessonThread.tableOfStudent.SubjectGrade;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;

public class Writer {


   public void writeList(List<Object> list, String fileIn) {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileIn)))) {

            for (Object o :
                    list) {
                objectOutputStream.writeObject(o);
            }
            objectOutputStream.writeObject(new Student(-1,"",null));

        } catch (IOException e) {
            System.out.println("File not consist.Program terminated");
//                e.printStackTrace();
        }

        /*try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileIn)))) {

                objectOutputStream.writeObject(list);

        } catch (IOException e) {
            System.out.println("File not consist.Program terminated");
//                e.printStackTrace();
        }*/ //Сериализуем в файл сразу лист Объектов


    }


    void writeGradesToFile(SortedMap<AverageStudentGrade, Set<SubjectGrade>> map, String fileIn) throws IOException {

        try (FileWriter writer = new FileWriter(fileIn)) {
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
        System.out.printf("Info was write in file %s\n", fileIn);
    }

}
