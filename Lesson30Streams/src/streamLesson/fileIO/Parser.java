package streamLesson.fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
     void parseWithFormatter(String fileBankAccount) throws FileNotFoundException {
        try (
                Scanner scanner = new Scanner(System.in);
                Formatter formatter = new Formatter(fileBankAccount)
        )
        {

            for (int i = 0; i < 3; i++) {
                System.out.println("Input id,name,balance");
                formatter.format("id account-%s, name account-%s%s, balance of account-%s\n",
                        scanner.nextInt(),
                        scanner.nextLine(),
                        scanner.nextLine(),
                        scanner.nextFloat())

                ;

            }
        }
    }

     void parseGradeBookAndWriteInAccountBookMather(String fileIn, String fileOutNameMatcher) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(fileIn));
             Formatter formatter = new Formatter(fileOutNameMatcher)) {

            while (scanner.hasNextLine()) {
                Matcher matcher = Pattern.compile("studentName='([a-zA-Z0-9]+)'").matcher(scanner.nextLine());
                while (matcher.find())
                    formatter.format("Student-%s\n", matcher.group(1));
            }
        }
    }


}
