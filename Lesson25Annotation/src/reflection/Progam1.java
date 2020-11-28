package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Progam1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Scanner scanner=new Scanner(System.in);
        Class class1=Class.forName(scanner.next());
        Class class2=Class.forName(scanner.next());
        String methodName=scanner.next();

        Method method=class1.getMethod(methodName,class2);
        Constructor constructor1=class1.getConstructor();
        Object object1=constructor1.newInstance();
        Constructor constructor2=class2.getConstructor(String.class);
        Object object2=constructor2.newInstance("String value");
        method.invoke(object1,object2);
        System.out.println(object1);


    }
}
