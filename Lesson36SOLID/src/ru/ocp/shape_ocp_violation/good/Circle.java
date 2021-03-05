package ru.ocp.shape_ocp_violation.good;

public class Circle implements Arealable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double are() {
        return Math.pow(this.radius,2)*Math.PI;
    }
}
