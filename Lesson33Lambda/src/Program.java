import java.util.*;
import java.util.function.*;

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
        ElementFunc.countTime(()->Arrays.sort(generateIntArr()));
        ElementFunc elementFunc = () -> Arrays.sort(generateIntArr());
        ElementFunc.countTime(elementFunc.countSomeTime(() -> Arrays.sort(generateIntArr())));
        String hello="Hello";
//        Double doubNum=0.123;
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

        List<Employee> employees=new ArrayList<>();
        employees.add(new Employee("Jack","Black",5000));
        employees.add(new Employee("Jacky","Blacky",450000));
        employees.add(new Employee("Sam","White",6700));
        employees.add(new Employee("Mary","Brown",8900));
        List<Person> persons=new ArrayList<>();
        persons.add(new Person("Mary","Black",32));
        persons.add(new Person("Jim","Brown",41));
        persons.add(new Person("John","White",26));


        System.out.println("----------------Predicate-------------------------");
        System.out.println(findMath(employees,e->e.salary>7000));
        System.out.println(findMath(persons,e->e.age>40));
        System.out.println("----------------Function-------------------------");
        System.out.println(calcSum(employees, Employee::getSalary));
        System.out.println(calcSum(persons, Person::getAge));

        System.out.println("----------------BinaryOperator\\Comparator-------------------------");

        System.out.println(combine(employees, e->e, new BinaryOperator<Employee>() {
            @Override
            public Employee apply(Employee t, Employee t2) {
                if(t.getSalary()>=t2.getSalary())
                    return t;
                return t2;
            }
        }));

        System.out.println(combine(employees, e->e,
            ( t,t2)-> {
                if(t.getSalary()>=t2.getSalary())
                    return t;
                return t2;
            }
        ));

        System.out.println(combineMax(employees, e -> e, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        }));

        System.out.println(combineMax(employees, e -> e, (o1, o2) -> o1.getSalary().compareTo(o2.getSalary())));

        System.out.println(combineMax(employees, e -> e, Comparator.comparing(Employee::getSalary)));

        System.out.println(combine(persons, e -> e, new BinaryOperator<Person>() {
                    @Override
                    public Person apply(Person person, Person person2) {
                        if(person.getAge()>=person2.getAge())
                            return person;
                        return person2;
                    }
    }));


        System.out.println(combineMax(persons, e -> e, Comparator.comparing(Person::getAge)));

        System.out.println("----------------Consumer-------------------------");

        employees.forEach(employee -> employee.setSalary(employee.getSalary()*11/10));
        employees.forEach(System.out::println);

        System.out.println("----------------Supplier-------------------------");
        Supplier[] suppliers={Circle::new,Square::new,Rectangle::new};
        System.out.println("Create Suppliers");
        System.out.println("-----------------------------------------");
        for (int i = 0; i < 4; i++) {
            int netx=new Random().nextInt(3);
            Supplier supplier=suppliers[netx];
            //System.out.println(netx);
            supplier.get();
        }


        Circle circle= new Circle();
        System.out.println(circle.calcSomething());



    }




    private static <T,R extends Number> Integer calcSum(List<T> elements, Function<T, R> function){
        int sum=0;
        for (T element :
                elements)
            sum += (int) function.apply(element);
        return sum;
    }

    private static <T> T combine(List<T> elements, Function<T, T> function, BinaryOperator<T> binaryOperator){
        T zeroElement=elements.get(0);
        for (T element :
                elements)
            zeroElement =binaryOperator.apply(zeroElement,function.apply(element));
        return zeroElement;
    }

    private static <T> T combineMax(List<T> elements, Function<T, T> function, Comparator<T> comparator){
        T zeroElement=elements.get(0);
        for (T element :
                elements) {
            int compare = comparator.compare(zeroElement, function.apply(element));
            zeroElement=(compare < 0)?function.apply(element):((compare > 0)?zeroElement:zeroElement);
        }
        return zeroElement;
    }

    private static <T> T findMath(List<T> elements, Predicate<T> predict){

        for (T element:
             elements) {
            if(predict.test(element))
                return element;
        }
        return null;

    }

    private static <T extends Number> void processElement(List<T> list, ElementProcess<T> elementProcess) {
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




}
