public class MyBox<X> {

    X xField;

    public <T> MyBox(T param, X param2) {
        System.out.println(param.getClass().getName());
        System.out.println(param2.getClass().getName());
    }
    public static <U> U returnValue(U param){
        return param;
    }
}
