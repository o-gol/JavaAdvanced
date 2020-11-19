import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args) {
        List<Integer> integers=new ArrayList<>();
        int[] ints=new int[10];
        fillArr(ints);
        fillList(integers);

        System.out.println(integers);
        System.out.println(Arrays.toString(ints) );

        //map

        ints=Arrays.stream(ints).map(operand -> operand*3).toArray();
        integers=integers.stream().map(operand -> operand*3).collect(Collectors.toList());
        System.out.println(integers);
        System.out.println(Arrays.toString(ints) );

        //filter
        ints=Arrays.stream(ints).filter(operand -> operand%2==0).toArray();
        integers=integers.stream().filter(operand -> operand%2==0).collect(Collectors.toList());
        System.out.println(integers);
        System.out.println(Arrays.toString(ints) );


        //forEach

        Arrays.stream(ints).forEach(System.out::println);
        integers.stream().forEach(System.out::println);

        // reduce

        int a=Arrays.stream(ints).reduce(5,((left, right) -> left+right));
        int b=integers.stream().reduce((left, right) -> left+right).get();
        System.out.println(a);
        System.out.println(b );







    }
    private  static void fillList(List list){
        for (int i = 0; i < 10; i++) {
            list.add(i+1);
        }

    }

    private  static void fillArr(int[] list){
        for (int i = 0; i < 10; i++) {
            list[i]=i+1;
        }

    }



}
