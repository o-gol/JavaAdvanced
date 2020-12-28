package streamLesson.fileIO;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.*;

public class FileAttribute {
    void volidateView(){

    }
    static void showAttribute(Path path){
        try {
            System.out.println("Size "+Files.size(path));
            System.out.println("Last Mod Time "+Files.getLastModifiedTime(path));
            System.out.println("isReadable "+Files.isReadable(path));
            System.out.println("isWritable "+Files.isWritable(path));
            FileStore fs=Files.getFileStore(path);
            System.out.println(fs.type());

//            BasicFileAttributeView
//            DoFileAttributeView
//            PosixFileAttributeView
//            AclFileAttributeView
//            UserDefinedFileAttributeView
//            FileOwnerAttributeView


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
