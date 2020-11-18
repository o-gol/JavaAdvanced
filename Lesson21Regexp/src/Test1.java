import java.lang.reflect.Array;
import java.util.Arrays;

public class Test1 {
            public static void main(String[] args) {
                /*
                *    regexlib.com
                *  \\d - одна цифра
                *  \\w=[a-zA-Z] - одна английская буква
                *   +  - 1 или более
                *   *  - 0 или более
                *   ?  - 0 или 1 символ до
                *   (a|b|c) -одна из нескольких строк
                *   [abc]=(a|b|c)
                *   [a-zA-Z] -все английские буквы
                *   [0-9]=\\d
                *   [^abc] - все символы кроме abc
                *   .      -любой символ
                *   {2}  {n}   -2 (n) раз
                *   {2,} {n,}   -2 (n) раз и более
                *   {2, 4}  {n,m}  -не менее  2 (n) раз и не более 4 (m) раз
                * */
                String a="d";
                String b="-45";
                int i=5;
//                System.out.println(a.matches("\\d"));
//                System.out.println(b.matches("\\d+"));
//                System.out.println(b.matches("-?\\d*"));
//                System.out.println(b.matches("(-|\\+)?\\d*"));
                String d="g1rRTn33rty19937";
                System.out.println(d.matches("[a-cf-zA-Z31]+\\d+"));
                String e="aewr";
                System.out.println(e.matches("[^e]"));
                String f="https://www.yandex.by/search/?lr=157&offline_search=1&text=java%20tryLock";
                System.out.println(f.matches(("https?://(www\\.)?[a-zA-Z]+\\.(com|ru|by).*")));
                String g="hello me friend";
                String s="hello242345me4523452345friendS";
                String[] words= g.split(" ");
                System.out.println(Arrays.toString( words));
                String mod=g.replace(" ",", ");
                System.out.println(mod);
                mod=s.replaceAll("\\d+"," ");
                System.out.println(mod);
                mod=s.replace("[0-9]"," ");
                System.out.println(mod);
                mod=s.replaceFirst("\\d+"," ");
                System.out.println(mod);

    }

}
