import java.util.List;

public interface Shape {
    double calcSquare();

    static double calcShapesSquare(List<Shape> list){
        double shapeZero=0;
        for (Shape shape:
             list) {
            shapeZero += shape.calcSquare();
        }
        return shapeZero;
    }

    default double calcSomething(){
        return 11;
    }
}
