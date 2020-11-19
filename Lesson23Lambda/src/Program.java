import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program {
    interface Exempeleble{
        int exemple(int i);
    }

    static class Exemple {
        List<Exempeleble> list=new ArrayList<>();
        boolean boo=true;

        public void add(Exempeleble...args){
            for (int i = 0; i < args.length; i++) {
                list.add(args[i]);
                //System.out.println(args[i].exemple(6));
                args[i].exemple(6);

            }

        }

        public int run(Exempeleble exempeleble){
            return exempeleble.exemple(10);
        }

        public void runList(){
            for (Exempeleble h :
                    list) {
                h.exemple(6);
            }

        }

    }


    static class Hello implements Exempeleble{
        static int id;

        public Hello() {
            this.id++;
        }

        @Override
        public int exemple(int x) {
            System.out.printf("Hello %s-%s\n",id,x);
            return 1;
        }
    }

    static class Bay implements Exempeleble{
        static int id;

        public Bay() {
            this.id++;
        }

        @Override
        public int exemple(int x) {
            System.out.printf("Bay %s-%s\n",id,x);
            return 1;
        }
    }

    public static void main(String[] args) {
        Exemple exemple=new Exemple();
        int i= exemple.run(x -> {
            System.out.println("hello");
             return 15+x;
        });
        System.out.println(i);

        i=exemple.run(x->15+x);

        System.out.println(i);

        Hello hello1=new Hello();
        Hello hello2=new Hello();
        Hello hello3=new Hello();
        Bay bay1=new Bay();
        Bay bay2=new Bay();

        exemple.add(hello1,hello2,hello3,bay1,bay2);
        //exemple.runList();

        Exempeleble exempeleble=i1 ->{System.out.printf("Hello %s\n",5+i1);
        return 5+i1;}; ;
        exemple.add(exempeleble);






    }
}
