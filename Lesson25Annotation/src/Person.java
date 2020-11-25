@MyAnnotation(purpys = "for todo")
public class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
        this.id=-1;
        this.name="No name";
    }

    private void sayHello(){
        System.out.printf("Person witn id-%s, and name-%s say Hello");

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
