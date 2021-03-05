package ru.ocp.shape_ocp_violation.good;

public class AreaCalculater {

    public static void main(String[] args) {
        System.out.println(AreaCalculater.areaCalc(new Rectangle(3,4)
                ,new Circle(5)
                ,new Rectangle(4,5))
        );

    }


    public static double areaCalc(Arealable... arealables){
        double areSum=0;
        for (Arealable arealable:
             arealables) {
            areSum+=arealable.are();
        }
        return areSum;
    }
}
