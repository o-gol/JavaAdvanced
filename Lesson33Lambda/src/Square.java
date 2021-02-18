public class Square  implements Shape {
    Square() {
        System.out.println("Create Square");
    }

    @Override
    public double calcSquare() {
        return 3;
    }

}
