package com.company;

public class Circle extends Figure implements Printable {
    private double r; // radius
    private double area, perimeter; // area and perimeter of the circle

    Circle(double r){
        if(r<=0){
            throw new IllegalArgumentException();
        }
        this.r=r;
        this.area=calculateArea();
        this.perimeter=calculatePerimeter();
    }

    @Override
    double calculateArea() {
        return Math.PI*r*r;
    }

    @Override
    double calculatePerimeter() {
        return 2*Math.PI*r;
    }

    @Override
    public void print() {
        System.out.println("INFORMATION ABOUT THIS CIRCLE:");
        System.out.println("The radius length: " + r);
        System.out.println("The area of the figure: " + area);
        System.out.println("Perimeter of the figure: " + perimeter);
    }
}
