package Lesson1;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface MyCloseble extends Closeable {
    @Override
    void close() throws FileNotFoundException;
}
