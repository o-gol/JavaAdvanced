package javaRashSream;

import java.io.IOException;
import java.io.InputStream;

public class BuferStringArr extends InputStream {
    String[] strings;

    public BuferStringArr(String[] strings) {
        this.strings = strings;
    }

    @Override
    public int read() throws IOException {

        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i]);
        }
        return -1;
    }
}
