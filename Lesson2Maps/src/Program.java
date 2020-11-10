import javax.xml.crypto.Data;
import java.sql.Time;
import java.util.*;

public class Program {

    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        innerInst(hashMap);
        innerInst(linkedHashMap);
        innerInst(treeMap);

    }
        static void innerInst(Map<Integer,String> map){
            map.put(39,"Bob");
            map.put(65,"Jack");
            map.put(21,"Sunny");
            map.put(23,"John");
            map.put(33,"Sunny");
            StringBuilder stringSat=new StringBuilder();
            for (Map.Entry<Integer,String>  entry :
                    map.entrySet()) {
                String string=String.format("%s : %s\n",entry.getKey(),entry.getValue());
                stringSat.append(string);

            }
            System.out.printf("%s\n", stringSat);


        }


}
