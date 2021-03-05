package ru.ocp.shape_ocp_violation.good;

public class Rectangle implements Arealable {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double are() {
        return width*height;
    }
}
