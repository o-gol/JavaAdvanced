import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
//        List<String> list=new ArrayList<>();
        List<String> list=new LinkedList<>();
        list.add("Kavin");
        list.add("John");
        list.add("Jimy");
        list.add("Mary");
            System.out.println(list);
        int index;
        String temp=new String();

        Iterator<String> iterator=list.iterator();
        while (iterator.hasNext()) {
            temp=iterator.next();
            if(temp=="John"){
                iterator.remove();
            }
            //System.out.println(temp);
            //System.out.println(iterator.next());

        }
            System.out.println("\n"+list);

        for (String s:
             list) {
            System.out.println(s);
        }
    }
}
