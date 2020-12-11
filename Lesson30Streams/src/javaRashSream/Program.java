package javaRashSream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Program {
    public static void main(String[] args) throws IOException {
        String[] strings=new String[100];
        for (int i = 0; i < strings.length; i++) {
            strings[i]=Character.toString(new Random().nextInt(100));
        }
//        System.out.println(Arrays.toString(strings));
        /*InputStream is=System.in;
        System.setIn(is);*/
        InputStream inputStream=new BuferStringArr(strings);
        System.setIn(inputStream);

        readAndPrintLine();

    }

    public  static void readAndPrintLine() throws IOException{
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader reader=new BufferedReader(isr);
        while(true){
            String line=reader.readLine();
            if(line==null)
                break;
            System.out.println(line);
        }
        reader.close();
        isr.close();
    }
}
