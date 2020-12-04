package fileIO;

import tableOfStudent.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    void byteReadWrite(String fileIn, String fileOut) throws IOException {
        try (FileInputStream byteReader = new FileInputStream(fileIn);
             FileOutputStream byteWriter = new FileOutputStream(fileOut)) {

            byte[] arrByte = byteReader.readAllBytes();
            for (byte b : arrByte) {
                System.out.print(b);
            }
            byteWriter.write(arrByte);
            System.out.println("Byte read/write finished");

        }
    }


    void readGradeFromFile(String fileIn) throws IOException {
        FileReader fileReader = new FileReader(fileIn);
        System.out.println(fileReader.getEncoding());
        BufferedReader buffReader = new BufferedReader(fileReader);
        String s;
        while ((s = buffReader.readLine()) != null) {
            System.out.println(s);
        }
        System.out.println();
        fileReader = new FileReader(fileIn);

        int c;
        while ((c = fileReader.read()) != -1) {
            System.out.print(c);
            if (c == 10)
                System.out.println();
            if (c == 32)
                System.out.print(" ");
        }
    }

    List<Student> readFromBin(String fileInBin) {
        List<Student> studentList = new ArrayList<>();

         /*try (ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(fileInBin))){

         studentList=(List<Student>)objectInputStream.readObject();


         }catch (IOException | ClassNotFoundException e){
             System.out.println("File not consist.Program terminated");
         }*/ // Извлекаем сразу лист Объектов

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileInBin))) {
            boolean bool = true;
            while (bool) {
            Student s = (Student) objectInputStream.readObject();
                if (!(s.getGrades() == null)) {
                    studentList.add(s);
                } else
                    bool = false;
            }


        } catch (IOException e) {
            System.out.println("File not consist.Program terminated");
        }catch ( ClassNotFoundException e){
            System.out.println("Invalid Type");

        }

        return studentList;
    }

}
