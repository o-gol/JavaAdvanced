public class Circle
        extends Ellipsis
        implements
        ElseShape
        ,
        Shape
{
    Circle() {
        System.out.println("Create Circle");
    }

    @Override
    public double calcSquare() {
        return 2;
    }

    @Override
    public double calcSomething() {
        return Shape.super.calcSomething();
    }
}
