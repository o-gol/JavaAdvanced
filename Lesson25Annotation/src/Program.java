import java.lang.reflect.Method;

//@MyAnnotation
public class Program {


    //@MyAnnotation(purpys = "Write")
    public Program(){

    }



    @MyAnnotation(purpys = "Write")
    public void program(//@MyAnnotation(purpys = "Write")
                                                             int vaLlue){

    }



    @MyAnnotation(purpys = "Write")
    private String name;



    @MyAnnotation(purpys = "Write")
    public static void main(//@MyAnnotation(purpys = "Write")
                                                            String[] args) {
        A a=new A();
        a.testD();

        Person person=new Person();
        Class personClass=  person.getClass();
//        Method[] methods=personClass.getDeclaredMethods();
        Method[] methods=personClass.getMethods();
        for (Method method :
                methods) {
            System.out.printf("Method name-%s\n",method.getName());
        }

    }


}
