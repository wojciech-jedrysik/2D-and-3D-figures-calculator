package com.company;

public class Prism implements Printable {
    private double h; // height of the solid
    private double area, vol; // area and volume

    Prism(Figure figure, double h){
        if(h<=0){
            throw new IllegalArgumentException("The height of the solid must have a positive value!");
        }
        this.h=h;
        this.area=2*figure.calculateArea()+h*figure.calculatePerimeter();
        this.vol=figure.calculateArea()*h;
    }

    @Override
    public void print() {
        System.out.println("INFORMATION ABOUT THIS PRISM:");
        System.out.println("The height of the solid: " + h);
        System.out.println("Surface area of the solid: " + area);
        System.out.println("Volume of the solid: " + vol);
    }
}
