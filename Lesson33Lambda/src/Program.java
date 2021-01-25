import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@FunctionalInterface
interface ElementProcess<T extends Number> {
    public double process(T element);
}
@FunctionalInterface
interface ElementFunc{
    public void func();
}

public class Program {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        doubleList.add(6.4);
        doubleList.add(3.6);
        doubleList.add(1.23);
        doubleList.add(4.13);
        doubleList.add(12.2);


        processElement(integerList, i ->Math.sin(i.doubleValue()));
        System.out.println("---------------------");
        processElement(doubleList, i -> Math.sin(i.doubleValue()));
        countTime(()->Arrays.sort(generateIntArr()));
        String hello="Hello";
        Double doubNum=0.123;
        String alex=" Alex";
        TransformUtils<Double> transDouble=new TransformUtils<>();
        System.out.println(transDouble.transform(0.123, Math::sin));
        TransformUtils<String> transString=new TransformUtils<>();
        System.out.println(transString.transform("Hellououou", TransformUtils::returnString));
        System.out.println(transString.transform(alex,hello::concat));//вместо System.out.println(transString.transform(hello,x->x.concat(alex)));
        System.out.println(transString.transform(alex,String::toUpperCase));
        System.out.println(transString.transform(hello,String::new));
        LambdaScopeTest scopeTest=new LambdaScopeTest();
        LambdaScopeTest.LambdaScopeInner scopeInner=scopeTest.new LambdaScopeInner();
        scopeInner.testScope(988.003);

        /*
        CustomClass::staticMetod
        customClassInstances::nonStaticMetod
        CustomClass::nonStaticMetod
        CustomClass::new




         */






    }

    static <T extends Number> void processElement(List<T> list, ElementProcess elementProcess) {
        List<Double> doubleList=new ArrayList<>();
        for (T t :
                list) {
            doubleList.add(elementProcess.process(t));


        }
        System.out.println(doubleList);

    }

    private static int[] generateIntArr(){
        int[] arr=new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=new Random().nextInt(100);
        }
        return arr;
    }

    static void countTime(ElementFunc elementFunc){
        long start = System.currentTimeMillis();
        elementFunc.func();
        long finish = System.currentTimeMillis();
        System.out.println(finish-start);
    }


}
