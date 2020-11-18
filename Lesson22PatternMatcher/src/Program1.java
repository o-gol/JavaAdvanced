import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program1 {
    public static void main(String[] args) {
        String text="E-mail Емайл People don’t write letter today anymo They rarely " +
                "use the services of post office The reason is the appearance of Internet " +
                "connection Since the time people learned how to exchange documents through exemple@yandex.ru " +
                "the World Wide Web, many things jon@google.by have changed.";

//        String text="\n" +
//                "E-mail\tЕмайл\n" +
//                "People don’t write letter today anymore.\n" +
//                " They rarely use the services of post office.\n" +
//                " The reason is the appearance of Internet connection.\n" +
//                " Since the time people learned how to exchange documents through exemple@yandex.ru the World Wide Web, many things have changed.";
//
//
//        Pattern pattern=Pattern.compile("exemple@yandex.ru");
        Pattern pattern=Pattern.compile("([a-zA-Z0-9]+)@([a-zA-Z]+)\\.([a-zA-Z]+)");
        Matcher matcher=pattern.matcher(text);
        System.out.println(matcher.matches());
//        System.out.println(Pattern.matches("[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]+",text));
//        System.out.println(Pattern.matches("exemple@yandex.ru",text));
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }
    }
}
