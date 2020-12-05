package streamLesson.fileIO;

import java.io.File;

public class FileShower {
    File file;
    public FileShower(String path) {
        this.file=new File(path);
    }

    public void showAll(){
        System.out.printf("Absolut path: %s\n",);
        System.out.printf("Relative path: %s\n",);
        System.out.printf("Free space: %s\n",);
        System.out.printf("Perent derectory: %s\n",);
        System.out.printf("Absolut path: %s\n",);
        System.out.printf("Absolut path: %s\n",);

        System.out.printf("Absolut path: %s\n",);

    }
}


