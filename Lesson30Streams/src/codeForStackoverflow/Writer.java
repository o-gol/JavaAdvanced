package codeForStackoverflow;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static java.nio.ByteBuffer.wrap;

public class Writer {


    void writeTextToFile(String fileName) {

        String string = "Как минимум несколько вакцин от коронавируса готовы к распространению, еще сотни находятся в разработке и проходят испытания. " +
                "Следующим этапом, который может оказаться весьма сложным, станет доставка препаратов. Дело в том, что предлагаемые вакцины требуют особых условий " +
                "хранения — и в данном случае «особые» не значит «при температуре в диапазоне от −10 до +40 и влажности не более 80%».\n" +
                "\n" +
                "Казалось бы, вакцина готова, все самое сложное позади. Однако некоторые специалисты называют грядущий процесс «логистическим кошмаром». " +
                "Или, если не так драматизировать, чрезвычайно сложной процедурой. Почему?\n" +
                "\n" +
                "Вакцина от компании Pfizer и BioNTech должна храниться при температуре минус 70—80 градусов; от Moderna и Национальных институтов\n";

        try {
//            string = new String(string.getBytes("windows-1251"), "UTF-8");
            string = new String(string.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] bytesString = new byte[0];
        try {
            bytesString = string.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(string);

//        byte[] bytesString = string.getBytes();
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
             FileChannel fc = raf.getChannel();) {
            ByteBuffer bb = wrap(bytesString, 0, bytesString.length);
            fc.write(bb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void insertTextToFile(String fileName) {

        String string = " MARKED AREA MARKED AREA MARKED AREA П р";

        try {
//            string = new String(string.getBytes("windows-1251"), "UTF-8");
            string = new String(string.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] b = new byte[0];
        try {
            b = string.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(string);

//        byte[] b=string.getBytes();

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
             FileChannel fc = raf.getChannel();
        ) {
            ByteBuffer bb = ByteBuffer.wrap(b, 0, b.length);
            fc.write(bb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
