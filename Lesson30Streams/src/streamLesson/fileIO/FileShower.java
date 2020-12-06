package streamLesson.fileIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FileShower {
    File file;
    public FileShower(String path) {
        this.file=new File(path);
    }

    public void showAll() throws IOException {
        System.out.printf("Absolut path: %s\n",file.getAbsolutePath());
        System.out.printf("Relative path: %s\n",file.getPath());
        System.out.printf("Free space: %s\n",file.getFreeSpace()/1000000);
        System.out.printf("Perent derectory: %s\n",file.getParent());
        System.out.printf("Is absolut path: %s\n",file.isAbsolute());

        System.out.printf("Current directory is: %s\n",System.getProperty("user.dir"));

        if(file.isDirectory()){
            System.out.println("It is derectory:\n");
            String[] list=file.list();
            if(list!=null){
                for (String s :
                        list) {
                    System.out.println(s);
                }
            }
        }else {
            System.out.println("It is a file: ");
            System.out.printf("Creat new file: %s\n", file.createNewFile());
            //Permisions
            System.out.printf("Can read: %s\n", file.canRead());
            System.out.printf("Can write: %s\n", file.canWrite());
            System.out.printf("Can execute: %s\n", file.canExecute());
            System.out.printf("File is hidden: %s\n", file.isHidden());
            System.out.printf("Last modifay: %s\n", file.lastModified());
            System.out.printf("Delate file: %s\n", file.delete());

            Path filePath=file.toPath();


        }

    }
}


