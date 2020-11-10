import java.util.*;

public class Program {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> hashSet2 = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();
        String[] names1={"Jack", "Bob", "Sunny", "John", "Sunny", "Vika","Tom","Kira"};
        String[] names2={"Jack", "Oleg", "Sunny", "Igor", "Sunny","Kira","Natasha"};
        innerInst(hashSet,names1);
        innerInst(hashSet2,names2);
        //innerInst(linkedHashSet,names1);
        //innerInst(treeSet,names1);
        System.out.println(hashSet.contains("John"));
        System.out.println(hashSet.contains("Oleg"));
        System.out.println(hashSet.isEmpty());

        //union
        Set<String> union=new HashSet<>(hashSet);
        union.addAll(hashSet2);
        System.out.println(union);
        //interection
        Set<String> interection=new HashSet<>(hashSet);
        interection.retainAll(hashSet2);
        System.out.println(interection);
        //subtract
        Set<String> subtract=new HashSet<>(hashSet);
        subtract.removeAll(hashSet2);
        System.out.println(subtract);


    }



    static void innerInst(Set<String> set,String[] names) {
        for (String name:
             names) {
            set.add(name);
        }
        StringBuilder stringSat=new StringBuilder();
        for (String entry :
                set) {
            String string=String.format("%s\n", entry);
            stringSat.append(string);

        }
        System.out.printf("%s\n", stringSat);

    }

}