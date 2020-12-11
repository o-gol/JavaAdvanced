package streamLesson.fileIO;

import streamLesson.tableOfStudent.Student;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        } catch (ClassNotFoundException e) {
            System.out.println("Invalid Type");

        }

        return studentList;
    }

    void readFileFull(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        StringBuilder sb = new StringBuilder();
//        sb.append(Files.readAllLines(path));  //считывание всего файла за раз
//        System.out.println(sb.toString().replace(",","\n"));
//        System.out.println(sb);
        String s = new String();
        for (String s1 :
                Files.readAllLines(path)) {
            sb.append(s1);
            s += s1 + "\n";

//            System.out.println(s);
        }
//        System.out.println(sb);
        System.out.println(s);
    }


    static BufferedReader nioReadFileFromBuffer(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Charset charset = Charset.forName("UTF-8");
        BufferedReader bf = Files.newBufferedReader(path, charset);
        /*try {
             bf=Files.newBufferedReader(path,charset);
            String s;
            while (!((s=bf.readLine())==null)){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(bf!=null){

                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/

        return bf;


    }

    static void
//    InputStream
    nioReadFileFromStream(String fileIn) {
        Path path = Paths.get(fileIn);
        Charset charset = Charset.forName("UTF-8");
        try (InputStream in = Files.newInputStream(path);
             BufferedReader bf = new BufferedReader(new InputStreamReader(in, charset))) {
            String s;
            while (!((s = bf.readLine()) == null))
                System.out.println(s);

        } catch (IOException e) {

        }

    }

    void nioReadFromChannel(String fileIn) {
        try (RandomAccessFile raf = new RandomAccessFile(fileIn, "rw");
             FileChannel channel = raf.getChannel();
        ) {

            ByteBuffer bb = ByteBuffer.allocate(100);
            int i;
            while ((i = channel.read(bb)) > 0) {

                bb.flip();
                while (bb.hasRemaining()) {
                    System.out.print((char) bb.get());
//                    char ch=(char)bb.get();

                }
                bb.clear();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /*void  nioReadFromChannel(String fileIn){

        Path path=Paths.get(fileIn);
        try(ByteChannel bc=
                    Files.newByteChannel(path);
        ){
            int i;
            while ((i=bc.read())!=-1)

        }catch (IOException e) {
            e.printStackTrace();
        }

    }*/

}
