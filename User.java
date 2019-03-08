package com.company;

import java.security.InvalidParameterException;
import java.util.Scanner;


class User {
    private void calculatePrism(Figure figure, Scanner scanner){
        System.out.print("Enter the height of the prism: ");
        boolean exception = false;
        while(!exception){
            double h;
            try{
                if(scanner.hasNextDouble()){
                    h = scanner.nextDouble();
                }
                else{
                    System.out.println("The specified height must be a number!");
                    System.out.print("Enter a different value: ");
                    scanner.next();
                    continue;
                }
                Prism prism = new Prism(figure, h);
                prism.print();
                exception = true;
            }catch(IllegalArgumentException e) {
                System.out.println("Height must have a positive value!");
                System.out.print("Enter a different value: ");
            }
        }
    }

    void Interface(){
        while (true){
            System.out.println("2D AND 3D FIGURES CALCULATOR");
            System.out.println("Choose a figure:");
            System.out.println("1.Triangle");
            System.out.println("2.Square");
            System.out.println("3.Circle");

            Scanner scanner = new Scanner(System.in);

            while(!scanner.hasNextInt()){
                System.out.print("Enter an integer: ");
                scanner.next();
            }
            int choice = scanner.nextInt();

            boolean isPrism = false;
            String yn;

            if(choice == 1 || choice == 2 || choice == 3){
                System.out.println("Do you want to create a prism on the basis of the selected figure?(yes/no)");
                yn = scanner.next();
                if (yn.equalsIgnoreCase("yes")){
                    isPrism=true;
                }
            }

            switch (choice){
                case 1: {
                    System.out.println("Give the sides of the triangle");
                    boolean exception = false;
                    while(!exception){
                        try{
                            double sa, sb, sc;
                            System.out.print("Enter the length of the side a: ");
                            if(scanner.hasNextDouble()){
                                sa = scanner.nextDouble();
                            }
                            else{
                                System.out.println("The given data must be numbers!");
                                scanner.next();
                                continue;
                            }
                            System.out.print("Enter the length of the side b: ");
                            if(scanner.hasNextDouble()){
                                sb = scanner.nextDouble();
                            }
                            else{
                                System.out.println("The given data must be numbers!");
                                scanner.next();
                                continue;
                            }
                            System.out.print("Enter the length of the side c: ");
                            if(scanner.hasNextDouble()){
                                sc = scanner.nextDouble();
                            }
                            else{
                                System.out.println("The given data must be numbers!");
                                scanner.next();
                                continue;
                            }
                            Triangle triangle = new Triangle(sa, sb, sc);
                            triangle.print();
                            if (isPrism) {
                                calculatePrism(triangle, scanner);
                            }
                            exception = true;
                        }catch(InvalidParameterException e){
                            System.out.println("Side lengths must be positive!");
                            System.out.println("Enter other data:");
                        }catch(IllegalArgumentException e){
                            System.out.println("Given side lengths do not meet the condition\nto build a triangle!");
                            System.out.println("Enter other data:");
                        }
                    }
                }break;

                case 2: {
                    System.out.print("Enter the side of the square: ");
                    boolean exception = false;
                    while(!exception){
                        try{
                            double side;
                            if(scanner.hasNextDouble()){
                                side = scanner.nextDouble();
                            }
                            else{
                                System.out.println("The given side length must be a number!");
                                System.out.print("Enter a different value: ");
                                scanner.next();
                                continue;
                            }
                            Square square = new Square(side);
                            square.print();
                            if (isPrism) {
                                calculatePrism(square, scanner);
                            }
                            exception = true;
                        }catch(IllegalArgumentException e) {
                            System.out.println("The side length must be positive!");
                            System.out.print("Enter a different value: ");
                        }
                    }

                }break;

                case 3: {
                    System.out.print("Enter the radius of the circle: ");
                    boolean exception = false;
                    while(!exception){
                        try{
                            double r;
                            if(scanner.hasNextDouble()){
                                r = scanner.nextDouble();
                            }
                            else{
                                System.out.println("The radius length specified must be a number!");
                                System.out.print("Enter a different value: ");
                                scanner.next();
                                continue;
                            }
                            Circle circle = new Circle(r);
                            circle.print();
                            if (isPrism) {
                                calculatePrism(circle, scanner);
                            }
                            exception = true;
                        }catch(IllegalArgumentException e) {
                            System.out.println("The radius length must be positive!");
                            System.out.print("Enter a different value: ");
                        }
                    }
                }break;

                default:
                {
                    System.out.println("Invalid command!");
                }break;
            }

            System.out.println("Do you want to leave the program?(yes/no)");
            yn = scanner.next();
            if (yn.equalsIgnoreCase("yes")){
                break;
            }
        }
    }
}
