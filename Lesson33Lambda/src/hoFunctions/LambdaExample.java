package hoFunctions;

@FunctionalInterface
interface ElementProcess<T extends Number> {
    double process(T element);
}
@FunctionalInterface
interface ElementFunc{
    void func();


    static void countTime(ElementFunc elementFunc){
        long start = System.currentTimeMillis();
        elementFunc.func();
        long finish = System.currentTimeMillis();
        System.out.println(finish-start);
    }

    default ElementFunc countSomeTime(ElementFunc elementFunc){
        return ()->{
            this.func();
            elementFunc.func();
        };

    }

}

public class LambdaExample {

}
