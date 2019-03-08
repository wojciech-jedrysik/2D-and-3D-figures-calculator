package com.company;
import java.security.InvalidParameterException;

import static java.lang.Math.*;

public class Triangle extends Figure implements Printable{
    private double sa, sb, sc; // sides of the triangle
    private double area, perimeter; // area and perimeter of the triangle

    Triangle(double sa, double sb, double sc){
        if(sa<=0 || sb<=0 || sc<=0){
            throw new InvalidParameterException();
        }
        if(sa+sb<=sc || sa+sc<=sb || sb+sc<=sa){
            throw new IllegalArgumentException();
        }
        this.sa=sa;
        this.sb=sb;
        this.sc=sc;
        this.area=calculateArea();
        this.perimeter=calculatePerimeter();
    }

    @Override
    double calculateArea(){
        double p=calculatePerimeter()/2;
        return sqrt(p*(p-sa)*(p-sb)*(p-sc)); // Heron's formula
    }

    @Override
    double calculatePerimeter(){
        return sa+sb+sc;
    }

    @Override
    public void print(){
        System.out.println("INFORMATION ABOUT THIS TRIANGLE:");
        System.out.println("Side lengths a, b, c: " + sa + ", " + sb + ", " + sc);
        System.out.println("The area of the figure: " + area);
        System.out.println("Perimeter of the figure: " + perimeter);
    }
}
