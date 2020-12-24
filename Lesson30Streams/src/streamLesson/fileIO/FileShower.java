package streamLesson.fileIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class FileShower {

    static List<Path> pathAll = new ArrayList<>();
    private Path p;
    private DirectoryStream.Filter filters;

    public static List<Path> getPathAll() {
        return pathAll;
    }

    File file;

    public FileShower(String path) {
        this.file = new File(path);
    }

    public FileShower() {
    }

    public void showAll() throws IOException {
        System.out.printf("Absolut path: %s\n", file.getAbsolutePath());
        System.out.printf("Relative path: %s\n", file.getPath());
        System.out.printf("Free space: %s\n", file.getFreeSpace() / 1000000);
        System.out.printf("Perent derectory: %s\n", file.getParent());
        System.out.printf("Is absolut path: %s\n", file.isAbsolute());

        System.out.printf("Current directory is: %s\n", System.getProperty("user.dir"));

        if (file.isDirectory()) {
            System.out.println("It is derectory:\n");
            String[] list = file.list();
            if (list != null) {
                for (String s :
                        list) {
                    System.out.println(s);
                }
            }
        } else {
            System.out.println("It is a file: ");
            System.out.printf("Creat new file: %s\n", file.createNewFile());
            //Permisions
            System.out.printf("Can read: %s\n", file.canRead());
            System.out.printf("Can write: %s\n", file.canWrite());
            System.out.printf("Can execute: %s\n", file.canExecute());
            System.out.printf("File is hidden: %s\n", file.isHidden());
            System.out.printf("Last modifay: %s\n", file.lastModified());
            System.out.printf("Delate file: %s\n", file.delete());

            Path filePath = file.toPath();


        }

    }

    public void showNioAll(String fileName) throws IOException {
        System.out.println("NIO Shower=================================");
        Path path = Paths.get(fileName);
        Path path1 = FileSystems.getDefault().getPath(fileName);
        Path path2 = Paths.get(System.getProperty("user.dir"), fileName);
        Path path3 = Paths.get(System.getProperty("user.dir"));
        System.out.printf("%s\n%s\n%s\n%s\n", path, path1, path2, path3);

        System.out.printf("File name: %s\n", path.getFileName());
        Path absolutePath = path.toAbsolutePath();
        System.out.printf("Root dir: %s\n", absolutePath.getRoot());
        System.out.printf("AbsolutePath: %s\n", absolutePath);
        System.out.printf("Parent dir: %s\n", absolutePath.getParent());
        System.out.printf("Name count: %s\n", path.getNameCount());
        System.out.printf("Name count: %s\n", absolutePath.getNameCount());
        System.out.printf("count 0-3: %s\n", absolutePath.subpath(0, 3));
        Path path4 = Paths.get("..\\..\\");
        System.out.printf("Real path: %s\n", path4.toRealPath());


        System.out.printf("File exist: %s\n", Files.exists(path));
        System.out.printf("File do not exist: %s\n", Files.notExists(path));
        //----может в обоих случаях вернуть false, если ОС не даст доступа к файлу
        System.out.printf("Is readable: %s\n", Files.isReadable(path));
        System.out.printf("Is writable: %s\n", Files.isWritable(path));
        System.out.printf("Is executable: %s\n", Files.isExecutable(path));

//        System.out.printf("Is same files: %s\n",Files.isSameFile(path,path2));

        if (!(Files.exists(path))) {
            Files.createDirectory(path);
            System.out.printf("Directory %s is created\n", path);
        } else {
            System.out.printf("Directory %s is exist\n", path);
        }

        Path parentPath = absolutePath.getParent().resolve("fileses\\file");
        if (!(Files.exists(parentPath))) {
            Files.createDirectories(parentPath);
            System.out.printf("Directory %s is created\n", parentPath);

        } else {
            System.out.printf("Directory %s is exist\n", parentPath);
        }

        System.out.println(path);


        Files.copy(path.toAbsolutePath(),
                parentPath.resolve(path.subpath(path.getNameCount() - 1, path.getNameCount())),
                StandardCopyOption.REPLACE_EXISTING);


    }

    private List<Path> recursFindDir(Path p) {
        try (DirectoryStream<Path> pathsAll = Files.newDirectoryStream(p);) {

            for (Path pp :
                    pathsAll) {
//                    System.out.println(pp);
                pathAll.add(pp);
                if (new File(pp.toString()).isDirectory()) {
                    recursFindDir(pp);
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println("====================================1");
        return pathAll;

    }

    private void recursFindFiles(Path path, String string) {
        pathAll.clear();
        List<Path> paths = recursFindDir(path);
        System.out.println("===========END================");
        recursFindDir(path, string);
        for (Path p :
                paths) {
            if (new File(p.toString()).isDirectory())
                recursFindDir(p, string);
        }
    }

    private static void recursFindDir(Path p, String glob) {
        try (DirectoryStream<Path> pathsAll = Files.newDirectoryStream(p, glob);) {

            for (Path pp :
                    pathsAll) {
                System.out.println(pp);
                if (new File(pp.toString()).isDirectory()) {
                    recursFindDir(pp, glob);
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("====================================2");

    }

    private void recursFindDir(Path p, DirectoryStream.Filter<Path> filters) {

        try (DirectoryStream<Path> pathsAll = Files.newDirectoryStream(p, filters);) {
            for (Path pp :
                    pathsAll) {
                System.out.println(pp);
//                if (new File(pp.toString()).isDirectory()) {
                System.out.println("====================================3");
                recursFindDir(pp, filters);
//                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    void processDir(String path) {
        Path pathDir = Paths.get(path);
        Path pathsDir = Paths.get(String.format("%s\\a\\b\\ром", pathDir));
        System.out.println(pathsDir + "\n" + pathDir);
        boolean flag = true;

        /*Set<PosixFilePermission> setAtributs=new HashSet<PosixFilePermission>();
        setAtributs.add(PosixFilePermission.GROUP_READ);
        setAtributs.add(PosixFilePermission.GROUP_WRITE);*/

        try
        //(DirectoryStream<Path> pathsAll = Files.newDirectoryStream(pathDir))
        {
            if (Files.notExists(pathDir))
                Files.createDirectory(pathDir);
            else if (Files.notExists(pathsDir))
                Files.createDirectories(pathsDir);

            if (!Files.notExists(pathsDir)) {
                File folder = new File(pathsDir.toString());
                File[] folders = folder.listFiles();
                for (File f :
                        folders) {
                    if (Paths.get(f.getPath()).getFileName().toString().substring(0, 3).equals("tmp"))
                        flag = false;

                }

            }
            // flag=true;

            if (Files.notExists(pathsDir)) {
                Files.createDirectories(pathsDir);
                Files.createTempDirectory(pathsDir, "tmp");
            } else if (!Files.notExists(pathDir) && flag) {
                Files.createTempDirectory(pathsDir, "tmp");
            }

            //---------------корневые директории
            Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();
            for (Path p :
                    rootDirectories) {
                System.out.println(p);
            }

//            recursFindDir(pathDir,"*.{txt}");
//            pathAll.clear();
//            recursFindDir(pathDir);


            recursFindFiles(pathDir, "*.{txt,bin}");
            System.out.println("=================END================");
            recursFindDir(pathDir, (path1) -> (Files.isDirectory(path1)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


