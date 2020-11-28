import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

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
        Method[] methods=personClass.getDeclaredMethods();
//        Method[] methods=personClass.getMethods();
        for (Method method :
                methods) {
            System.out.printf("Method name-%s, %s, %s\n",method.getName(),method.getReturnType(), Arrays.toString(method.getParameterTypes()));
        }

        Field[] fields=personClass.getDeclaredFields();
        for (Field field :
                fields) {
            System.out.printf("Field name-%s, %s\n",field.getName(),field.getType());
        }
        Annotation[] annotations=personClass.getAnnotations();
        for (Annotation annotation :
                annotations) {
            if(annotation instanceof MyAnnotation){
                System.out.println("Yes");
            }
        }

    }


}
