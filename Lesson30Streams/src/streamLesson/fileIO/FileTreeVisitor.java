package streamLesson.fileIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class FileTreeVisitor {

    public static class CopyVisitor extends SimpleFileVisitor<Path> {
        Path pathOut;

        public CopyVisitor(Path pathOut) {
            this.pathOut = pathOut;
        }

        private static String pathin(Path pathin,Path pathout) {
            String s = getString(pathin);
            s=pathout+s;
//        System.out.println(s);
            return s;
        }
        private static String pathinAuthor(Path pathin) {
            Path resolve = Paths.get(Program.DIR_TEMP).relativize(pathin);
            Path pathOutFull=Paths.get(Program.DIR_TEMP_COPY).resolve(resolve);
//        System.out.println(s);
            return pathOutFull.toString();
        }

        private static String getString(Path pathin) {
            int nameCount = pathin.getNameCount();


            String s="";
            for (int i = 0; i < nameCount; i++) {
                if(i>4){
                    s=s+"\\"+pathin.getName(i);
                }
            }
            return s;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//            Files.copy(file,Files.newOutputStream(pathOut, CREATE, APPEND));
            /*System.out.println(Paths.get(Program.DIR_TEMP).relativize(file));
            System.out.println(getString(file));*/
            System.out.println(pathin(file,pathOut));
            System.out.println(pathinAuthor(file));
//            System.out.println(pathin(file, pathOut));
//            -------------------------------------------------------------------------------
//            Files.copy(file, Paths.get(pathin(file, pathOut)), StandardCopyOption.REPLACE_EXISTING);
            return FileVisitResult.CONTINUE;
//            -----------------------------------------------------------------------------
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.err.println("Copy failed "+file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            /*System.out.println(Paths.get(Program.DIR_TEMP).relativize(dir));
            System.out.println(getString(dir));*/
            System.out.println(pathin(dir,pathOut));
            System.out.println(pathinAuthor(dir));

//            System.out.println(pathin(dir, pathOut));

//            ------------------------------------------------------------------------------------

            /*if (!Paths.get(pathin(dir, pathOut)).toFile().exists())
                Files.copy(dir, Paths.get(pathin(dir, pathOut)));*/

            return FileVisitResult.CONTINUE;
//            -------------------------------------------------------------------------------------
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
//            System.out.println(Program.pathin(dir, pathOut));

//            Files.copy(dir,Files.newOutputStream(pathOut, CREATE, APPEND));
            return FileVisitResult.CONTINUE;

        }
    }



    //------------------------------------------------------------------








    public static class Visitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            rename(file);

            return FileVisitResult.CONTINUE;

        }

        private void rename(Path path) throws IOException {
            System.out.println(path);
            int nameCount = path.getNameCount();
            if (nameCount > 5) {
                System.out.println(nameCount);
                System.out.println(path.getName(nameCount - 1));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                //System.out.println(data);
                Files.move(path, path.resolveSibling(simpleDateFormat.format(new Date())+"_"+ path.getName(nameCount-1)));
//                Files.move(path, path.resolveSibling(path.getName(nameCount - 1).toString().substring(11)));
            }
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            rename(dir);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.err.println("Copy failed "+file);
            return FileVisitResult.CONTINUE;
        }

        /*@Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

            return FileVisitResult.CONTINUE;
        }*/
    }

}
