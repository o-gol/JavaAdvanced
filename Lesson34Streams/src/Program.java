import javax.sql.rowset.Predicate;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Program {
    static Map<Integer, Employee> employeeMap = null;
    static List<Employee> employees = new ArrayList<>();
    static List<Employee> secondEmployees = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        employees.add(new Employee(12, "Mary", "Black", 95000,"IT"));
        employees.add(new Employee(3, "Jim", "Brown", 75000,"Fin"));
        employees.add(new Employee(11, "John", "White", 65000,"Buh"));
        employees.add(new Employee(6, "Juli", "Spring", 65000,"IT"));
        employees.add(new Employee(14, "Ann", "Grow", 30000,"IT"));
        employees.add(new Employee(5, "Dry", "Mine", 40000,"Buh"));
        employees.add(new Employee(9, "Fill", "Filrod", 90000,"Fin"));
        employees.add(new Employee(15, "Oleg", "Ford", 35000,"IT"));
        employees.add(new Employee(4, "Igor", "Fil", 28000,"Fin"));
        employees.add(new Employee(19, "Oscar", "Wiled", 120000,"Fin"));
        secondEmployees.add(new Employee(1, "Mary", "Black", 95000,"IT"));
        secondEmployees.add(new Employee(3, "Jim", "Brown", 75000,"Fin"));
        secondEmployees.add(new Employee(5, "John", "White", 65000,"IT"));
        secondEmployees.add(new Employee(6, "Juli", "Spring", 65000,"Fin"));
        secondEmployees.add(new Employee(9, "Ann", "Grow", 30000,"IT"));
        secondEmployees.add(new Employee(11, "Dry", "Mine", 40000,"Fin"));
        secondEmployees.add(new Employee(10, "Fill", "Filrod", 90000,"Fin"));
        secondEmployees.add(new Employee(15, "Oleg", "Ford", 35000,"IT"));
        secondEmployees.add(new Employee(12, "Igor", "Fil", 28000,"Fin"));
        secondEmployees.add(new Employee(19, "Oscar", "Wiled", 120000,"Fin"));
        Function<Employee,String> function= Employee::getDeartment;
        Supplier<Integer> supplier=new Supplier<Integer>() {
            int prev=0;
            int cour=1;
            @Override
            public Integer get() {
                int next=prev+cour;
                prev=cour;
                cour=next;
                return cour;
            }
        };

        testStreamFormList();
        testStreamFromFile();
        testSortAndReduce();
        partitionByIncome(function,10,supplier);
    }




    private static <R> void partitionByIncome(Function<Employee,R> function, int limit, Supplier<Integer> supplier) throws IOException {
        System.out.println("---------------------------PartitionBy");
        Map<Boolean, List<Employee>> collect = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 35000));
        System.out.println("Poor "+collect.get(false));
        System.out.println("Rich "+collect.get(true));
        System.out.println("---------------------------GroupBy");
        Map<R, List<Employee>> collectGroup = employees.stream().collect(Collectors.groupingBy(function));
        collectGroup.keySet().forEach(e-> System.out.println(e+"\n"+collectGroup.get(e)));
        System.out.println("---------------------------Generator");
        Stream.generate(Math::random).limit(limit).forEach(System.out::println);
        System.out.println("---------------------------Iterator");
        Stream.iterate(2,e->e+3).limit(limit).forEach(System.out::println);
        System.out.println("---------------------------ParallelInt");
        employees.parallelStream()
                .map(Employee::getId)
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("---------------------------ParallelString");
        Files.lines(Paths.get("Lesson34Streams\\src\\files\\text1.txt"))
                .parallel()
                .filter(e->e.length()<=5)
//                .distinct()
                .sorted()
//                .collect(Collectors.toCollection(TreeSet::new))
                .forEach(e-> System.out.println(e.toUpperCase()));
        System.out.println("---------------------------ParallelWrongFibonachi");
        Stream.generate(supplier)
//                .parallel()
                .limit(limit)
                .forEach(System.out::println);
    }

    private static void testSortAndReduce(){
        System.out.println("---------------------------SortAndReduce");

        Employee employeeMaxId=employees.stream()
                .max(Comparator.comparing(Employee::getId))
                .get();
        System.out.println("Max id "+employeeMaxId);
        Employee employeeMinSalary=employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .get();
        System.out.println("Max salary "+employeeMinSalary);
        System.out.println("---------------------------Sorted by salary");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);
        System.out.println("---------------------------Reduce");
        Employee defaultEmployee=new Employee(0,"","",0,"");
        Employee reduce = employees.stream()
                .reduce(defaultEmployee, (e1, e2) -> {
                    e1.setId(e1.getId() + e2.getId());
                    e1.setSalary(e1.getSalary() + e2.getSalary());
                    return e1;
                });
        System.out.println("Reduce "+reduce);
        employees.forEach(System.out::println);
        System.out.println("---------------------------Distinct");
        List<Employee> eeempl=new ArrayList<>();
        eeempl.addAll(employees);
        eeempl.addAll(secondEmployees);
        eeempl.stream()
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("------------------------");
        eeempl.forEach(System.out::println);

    }

    private static void testStreamFormList() {
        System.out.println("---------------------------Rich and Firs");
        employees.stream()
                .filter(e -> e.salary >= 70000)
                .filter(e -> e.id < 10)
                .forEach(System.out::println);
        Integer[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
//        Integer[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("---------------------------Map");
        Stream.of(ids)
                .map(Program::findById)
                .filter(Objects::nonNull)
                .forEach(System.out::println);
        Optional<Employee> first = Stream.of(ids).map(Program::findById).filter(Objects::nonNull).findFirst();
        System.out.println("---------------------------StreamL1Ex1");
        int sum = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .mapToInt(Employee::getSalary)
                .sum();
        System.out.println(sum);
        System.out.println("---------------------------StreamL1Ex2");
        OptionalDouble sum1 = Stream.of(ids)
                .map(Program::findById)
                .filter(Objects::nonNull)
                .filter(e -> e.getSalary() > 50000)
                .mapToInt(Employee::getSalary)
                .average();
        System.out.println(sum1);
        System.out.println("---------------------------StreamL1Ex3FlatMap");
        List<List<Employee>> departments=new ArrayList<>();
        departments.add(employees);
        departments.add(secondEmployees);
        departments.stream()
                .flatMap(List::stream)
                .map(Employee::getName)
                .forEach(System.out::println);
        System.out.println("---------------------------StreamL1Ex4ForEach");
        Integer[] idsDist = Arrays.stream(ids)
                .map(e -> e = e +3)
//                .mapToInt(x->x)
                .toArray(Integer[]::new);
//                .peek(e->e=e*3)

                /*.forEach(e-> {
                    e=e*2;
                    System.out.println(e + 2);
                })*/;
        System.out.println(Arrays.toString(idsDist));
        System.out.println("---------------------------StreamL1Ex5Optional");
        Integer firstId = Arrays.stream(ids).filter(e -> e % 2 == 0)
                .filter(e -> e % 3 == 0)
                .filter(e -> e % 5 == 0)
                .findFirst()
//                .orElse(0)
                .orElseGet(()->new Random().nextInt());
        System.out.println(firstId);
        System.out.println("---------------------------StreamL1Ex6LimitSkip");
        Integer[] integers = Arrays.stream(ids)
                .filter(e -> e % 2 == 0)
                .filter(e -> e % 3 == 0)
                .limit(3)
//                .mapToInt(x->x)
                .toArray(Integer[]::new);
        Integer[] integers2 = Arrays.stream(ids)
                .filter(e -> e % 2 == 0)
                .filter(e -> e % 3 == 0)
                .skip(1)
//                .mapToInt(x->x)
                .toArray(Integer[]::new);
        Integer firstIdLimit = Arrays.stream(ids)
                .filter(e -> e % 2 == 0)
                .filter(e -> e % 3 == 0)
                .limit(2)
                .findFirst()
//                .orElse(0)
                .orElseGet(()->new Random().nextInt())
                ;
        System.out.println(firstIdLimit);
        System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.toString(integers2));



    }

    private static void testStreamFromFile() throws IOException {
        System.out.println("---------------------------Stream File");
        Files.lines(Paths.get("Lesson34Streams\\src\\files\\text1.txt"))
                .filter(e->e.length()<=5)
//                .collect(Collectors.toList())
//                .stream()
                .distinct()
                .sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("---------------------------Stream File");
        Files.lines(Paths.get("Lesson34Streams\\src\\files\\text1.txt"))
                .filter(e->e.length()<=5)
//                .distinct()
//                .sorted()
                .collect(Collectors.toCollection(TreeSet::new))

                .forEach(e-> System.out.println(e.toUpperCase()));
    }

    private static Employee findById(int id) {
        if (employeeMap==null){
            employeeMap=employees.stream().distinct().collect(Collectors.toMap(Employee::getId, e->e));
        }
            return employeeMap.get(id);
    }

//    BlockingQueue


}


