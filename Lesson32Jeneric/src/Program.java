import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {


    public static void main(String[] args) {
        Integer[] integers={1,2,3,4};
        Double[] doubles={2.43,6.58,7.55,5.88};
        String[] strings={"adv","wer","ret","ert"};
        Object[] objects={integers,doubles,strings};

        printArr(integers);
        printArr(doubles);
        printArr(strings);
        printArr(objects);
        findMax(integers);
        findMax(doubles);
//        findMax(strings);
//        findMax(objects);
        List<Integer> numList=new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(15);
        numList.add(4);
        numList.add(134);

        showList(numList); //-----ошибка
        showList(Arrays.asList(integers));

        MyBox<Integer> myBox=new MyBox("",1);
        Double aDouble = MyBox.returnValue(3.4);
        System.out.println(aDouble);


    }

    /*static void printArr(Integer[] integers) {
        System.out.print("{");
        for (Integer integer :
                integers) {
            System.out.printf("%s ",integer);
        }
        System.out.println("}");

    }

    static void printArr(Double[] doubles) {
        System.out.print("{");
        for (Double doubl :
                doubles) {
            System.out.printf("%s ",doubl);
        }
        System.out.println("}");

    }

    static void printArr(String[] strings) {
        System.out.print("{");
        for (String string :
                strings) {
            System.out.printf("%s ",string);
        }
        System.out.println("}");

    }*/

    static <T> void printArr(T[] object) {
        System.out.print("{");
        for (T string :
                object) {
            System.out.printf("%s ",string);
        }
        System.out.println("}");

    }

    static <T extends Number & Comparable<T>>  T findMax (T[] objects){
        T max=objects[0];
        for (T object :
             objects) {
            if(object.compareTo(max)>0)
                max=object;
        }
        System.out.println(max);
        return max;
    }


    static void showList(List<? extends Number> list){
        for (Number n :
                list) {
            System.out.println(n);
        }



    }

    /* Generic convection
    E-element of covection
    K-key
    N-number
    T-type
    V-value
    S U V etc.
     */


}
