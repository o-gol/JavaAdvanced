import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        Dog dog1=new Dog();
        //dog1.setSize(Size.BIG);
        dog1.bark();

        Dog dog2=new Dog("Jack");
        //dog2.setSize(Size.AVERAGE);
        dog2.bark();

        Dog dog3=new Dog(Size.AVERAGE,3,"Bobik",1);
        //dog3.setSize(Size.AVERAGE);
        dog3.bark();


        System.out.printf("%s\n%s\n%s\n",dog1,dog2,dog3);


        /*Size size=Size.BIG;
        System.out.println(size.toString());
        Size size1=Size.valueOf("SMALL");
        System.out.println(size1);
        String[] sizes=new String[Size.values().length];
        int i=0;
        for (Size ignored :
                Size.values()) {
            System.out.println(ignored);
            sizes[i]=ignored.toString();
            i++;
        }
        System.out.println(Arrays.toString(sizes));*/




    }
}
