package hoFunctions;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<RichPerson> persons= new ArrayList<>();
        persons.add(new RichPerson("Mary","Black",32,95000));
        persons.add(new RichPerson("Jim","Brown",41,75000));
        persons.add(new RichPerson("John","White",26,65000));
        persons.add(new RichPerson("Ann","Grow",37,50000));

    }
    private static void testPredicate(List<RichPerson> persons){
        System.out.println("Testing");
    }
}
