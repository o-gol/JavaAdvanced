import java.util.ArrayList;
import java.util.List;

public class Program {
    interface Exempeleble{
        int exemple();
    }

    static class Exemple {
        List<Exempeleble> list=new ArrayList<>();

        public void add(Exempeleble...args){
            for (int i = 0; i < args.length; i++) {
                list.add(args[i]);

            }
        }

        public int run(Exempeleble exempeleble){
            return exempeleble.exemple();
        }

        public void runList(){
            for (Exempeleble h :
                    list) {
                h.exemple();
            }

        }

    }


    static class Hello implements Exempeleble{
        static int id;

        public Hello() {
            this.id++;
        }

        @Override
        public int exemple() {
            System.out.printf("Hello %s\n",id);
            return 1;
        }
    }

    static class Bay implements Exempeleble{
        static int id;

        public Bay() {
            this.id++;
        }

        @Override
        public int exemple() {
            System.out.printf("Bay %s\n",id);
            return 1;
        }
    }

    public static void main(String[] args) {
        Exemple exemple=new Exemple();
        int i= exemple.run(() -> {
            System.out.println("hello");
             return 5;
        });
        System.out.println(i);

        i=exemple.run(()->7);

        System.out.println(i);

        Hello hello1=new Hello();
        Hello hello2=new Hello();
        Hello hello3=new Hello();
        Bay bay1=new Bay();
        Bay bay2=new Bay();

        exemple.add(hello1,hello2,hello3,bay1,bay2);
        exemple.runList();






    }
}
