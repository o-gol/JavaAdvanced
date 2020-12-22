package streamLesson.fileIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class FileShower {
    File file;

    public FileShower(String path) {
        this.file=new File(path);
    }

    public FileShower() {
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

    public void showNioAll(String fileName) throws IOException {
        System.out.println("NIO Shower=================================");
        Path path = Paths.get(fileName);
        Path path1= FileSystems.getDefault().getPath(fileName);
        Path path2=Paths.get(System.getProperty("user.dir"),fileName);
        Path path3=Paths.get(System.getProperty("user.dir"));
        System.out.printf("%s\n%s\n%s\n%s\n",path,path1,path2,path3);

        System.out.printf("File name: %s\n",path.getFileName());
        Path absolutePath=path.toAbsolutePath();
        System.out.printf("Root dir: %s\n",absolutePath.getRoot());
        System.out.printf("AbsolutePath: %s\n",absolutePath);
        System.out.printf("Parent dir: %s\n",absolutePath.getParent());
        System.out.printf("Name count: %s\n",path.getNameCount());
        System.out.printf("Name count: %s\n",absolutePath.getNameCount());
        System.out.printf("count 0-3: %s\n",absolutePath.subpath(0,3));
        Path path4=Paths.get("..\\..\\");
        System.out.printf("Real path: %s\n",path4.toRealPath());


        System.out.printf("File exist: %s\n",Files.exists(path));
        System.out.printf("File do not exist: %s\n",Files.notExists(path));
        //----может в обоих случаях вернуть false, если ОС не даст доступа к файлу
        System.out.printf("Is readable: %s\n",Files.isReadable(path));
        System.out.printf("Is writable: %s\n",Files.isWritable(path));
        System.out.printf("Is executable: %s\n",Files.isExecutable(path));

//        System.out.printf("Is same files: %s\n",Files.isSameFile(path,path2));

        if(!(Files.exists(path))){
            Files.createDirectory(path);
            System.out.printf("Directory %s is created\n",path);
        }else {
            System.out.printf("Directory %s is exist\n",path);
        }

        Path parentPath=absolutePath.getParent().resolve("fileses\\file");
         if(!(Files.exists(parentPath))){
            Files.createDirectories(parentPath);
            System.out.printf("Directory %s is created\n",parentPath);

        }else {
            System.out.printf("Directory %s is exist\n",parentPath);
        }

        System.out.println(path);



         Files.copy(path.toAbsolutePath(),
                 parentPath.resolve(path.subpath(path.getNameCount()-1,path.getNameCount())),
                 StandardCopyOption.REPLACE_EXISTING);




    }


    void processDir(String pathDir){
        try {
            Files.createDirectory(Paths.get(pathDir));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


