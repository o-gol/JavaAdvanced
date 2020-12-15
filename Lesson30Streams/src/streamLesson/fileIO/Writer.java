package streamLesson.fileIO;

import streamLesson.tableOfStudent.AverageStudentGrade;
import streamLesson.tableOfStudent.Student;
import streamLesson.tableOfStudent.SubjectGrade;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;

import static java.nio.ByteBuffer.allocate;
import static java.nio.ByteBuffer.wrap;
import static java.nio.file.StandardOpenOption.*;

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
    void nioWriteFromBuffer(String fileIn,String fileOut) throws IOException {
       Path pathIn=Paths.get(fileIn);
       Path pathOut=Paths.get(fileOut);
        Charset charset=Charset.forName("UTF-8");
        BufferedReader bf=Reader.nioReadFileFromBuffer(fileIn);
        try(BufferedWriter bw=Files.newBufferedWriter(pathOut,charset)) {
            String s;
            while ((s=bf.readLine())!=null)
            {
                bw.write(s+"\n");

            }
        } catch (IOException e) {

        }

    }
    void nioWriteFromStream(String fileIn,String fileOut) throws IOException{
       Path pathOut=Paths.get(fileOut);
       Path pathIn=Paths.get(fileIn);
       OutputStream out=Files.newOutputStream(pathOut, CREATE, APPEND);
       InputStream in=Files.newInputStream(pathIn);
//       BufferedInputStream bis=new BufferedInputStream(in);
//       BufferedOutputStream bos=new BufferedOutputStream(out);
       int b;
       /*while ((b=bis.read())!=-1){
           bos.write(b);
       }
       if(bis!=null&&bos!=null){
           bos.close();
           bis.close();
       }*/
       while ((b=in.read())!=-1){
           out.write(b);
       }
       if(in!=null&&out!=null){
           in.close();
           out.close();
       }



    }
    void nioWriteFromChannel(String fileOut){
       String string="Я использую java.НИО.каналы.FileChannel, чтобы открыть файл и заблокировать его, а затем записать InputStream в выходной файл.\n" +
               "InputStream может быть открыт другим файлом, URL, сокетом или чем угодно.\n Я написал следующие коды:" +
               "";
        byte[] bytesString= new byte[0];
        try {
            bytesString = string.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try (RandomAccessFile raf=new RandomAccessFile(fileOut,"rw");
        FileChannel fc=raf.getChannel();){
            ByteBuffer bb= wrap(bytesString,0,bytesString.length);
            //while (bb.hasRemaining())
                fc.write(bb);
                bb.flip();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void nioWriteWithRandomAccess(String fileOut) throws UnsupportedEncodingException {
       Path pathOut = Paths.get(fileOut);
       /*ByteBuffer bbRead= ByteBuffer.wrap(
               String.getBytes(" MARKED AREA MARKED AREA MARKED AREA".getBytes('Cp1251'),'Cp866'));*/
       ByteBuffer bbRead= ByteBuffer.wrap(" MARKED AREA MARKED AREA MARKED AREA".getBytes("UTF-8"));
       ByteBuffer bbWrite=ByteBuffer.allocate(10);
       try(FileChannel fc=FileChannel.open(pathOut,READ,WRITE);){

           /*int numBytes=0;
           while (bbWrite.hasRemaining()&&numBytes!=-1){
               System.out.println(numBytes);
               numBytes=fc.read(bbWrite);
          }*/
//           fc.position(0);
           fc.write(bbRead);
       }catch (IOException e){
           e.getStackTrace();
       }
    }

}
