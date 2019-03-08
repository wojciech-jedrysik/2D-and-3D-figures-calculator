package com.company;

public class Square extends Figure implements Printable {
    private double side; // side of the square
    private double area, perimeter; // area and perimeter of the square

    Square(double side){
        if(side<=0){
            throw new IllegalArgumentException();
        }
        this.side=side;
        this.area=calculateArea();
        this.perimeter=calculatePerimeter();
    }

    @Override
    double calculateArea() {
        return side*side;
    }

    @Override
    double calculatePerimeter() {
        return 4*side;
    }

    @Override
    public void print() {
        System.out.println("INFORMATION ABOUT THE SQUARE:");
        System.out.println("Side length: " + side);
        System.out.println("The area of the figure: " + area);
        System.out.println("Perimeter of the figure: " + perimeter);
    }
}
