public class Dog {

    private Size size=Size.UNDEFINED;
    private static int id=1000;
    private int itId;
    private int age;
    private String name;
    private int departmentID;

    static {
        id=2000;
        System.out.println("Static block initialized");
        id++;



    }

    {
        itId=id;
        departmentID=3;
        age=10;
        name="J";
        System.out.println("Block initialized");

    }


    public Dog() {
        //this("JohnDo");
        System.out.println("Defoult constructor initialized");
    }


    public Dog(String name) {
        this(Size.UNDEFINED,12,name,2);
        System.out.println("Name constructor initialized");


    }

    public Dog(Size size, int age, String name, int departmentID) {
        this.size = size;
        this.age = age;
        this.name=name;
        id++;
        itId=id;
        this.departmentID = departmentID;
        System.out.println("FuLL constructor initialized");
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void bark(){
        switch (size){
            case SMALL:case VERY_SMALL:
                System.out.println("tiff-tiff");
                break;
            case AVERAGE:
                System.out.println("gaf-gaf");
                break;
            case BIG:case VERY_BIG:
                System.out.println("wof-wof");
                break;
            default:
                System.out.println("no size");
        }
    }

    @Override
    public String toString() {
        return "Dog{" +
                "size=" + size +
                ", itId=" + itId +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", departmentID=" + departmentID +
                '}';
    }
}
