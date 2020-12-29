package streamLesson.fileIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.*;
import java.util.List;
import java.util.Set;
import java.nio.file.attribute.AclEntryPermission;

public class FileAttribute {



    static void windowsPermissions(Path path){

        try {
            /*System.out.println(path.getFileSystem());
            System.out.println(path.getFileSystem().provider().getScheme());
            System.out.println(path.getFileSystem().supportedFileAttributeViews());
            System.out.println(path.getFileSystem().getUserPrincipalLookupService());
            System.out.println(path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("mtz\\o.goluzov"));*/
            UserPrincipal user=path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("mtz\\o.goluzov");
            AclFileAttributeView aclView= Files.getFileAttributeView(path, AclFileAttributeView.class);
            AclEntry aclEntry=AclEntry.newBuilder()
                    .setType(AclEntryType.ALLOW)
                    .setPrincipal(user)
                    .setPermissions(AclEntryPermission.READ_DATA,AclEntryPermission.READ_ATTRIBUTES)
                    .build();

            List<AclEntry> aclList=aclView.getAcl();
            aclList.add(aclEntry);
            aclView.setAcl(aclList);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static void validateView(Path path){

    final Class[] fileAttributeViewClasses={BasicFileAttributeView.class,
            DosFileAttributeView.class,
            PosixFileAttributeView.class,
            AclFileAttributeView.class,
            UserDefinedFileAttributeView.class,
            FileOwnerAttributeView.class
    };

        try {

            FileStore fs= Files.getFileStore(path);
            System.out.println(fs.type());
            for (Class view :
                    fileAttributeViewClasses) {

                boolean support=fs.supportsFileAttributeView(view);
                System.out.println("Support "+ view.getSimpleName()+" - "+support);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void showAttribute(Path path){
        System.out.println("============================File"+path+"========================");

        try {
            System.out.println("Size "+Files.size(path));
            System.out.println("Last Mod Time "+Files.getLastModifiedTime(path));
            System.out.println("isReadable "+Files.isReadable(path));
            System.out.println("isWritable "+Files.isWritable(path));
            validateView(path);
            DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
            System.out.println(dosFileAttributes.creationTime()+" creation time");
            System.out.println("isHidden "+dosFileAttributes.isHidden());
            windowsPermissions(path);





            /*//====================================For Posix Systems=====================================
            java.nio.file.attribute.FileAttribute<Set<PosixFilePermission>> setFileAttribute =
                    PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rwx------"));
            Files.createFile(path,setFileAttribute);
            */
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
