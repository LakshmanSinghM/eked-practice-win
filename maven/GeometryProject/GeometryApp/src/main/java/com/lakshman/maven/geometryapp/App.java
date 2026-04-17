package com.lakshman.maven.geometryapp;

import com.lakshman.maven.geometry.library.Circle;
import com.lakshman.maven.geometry.library.Rectangle;
import com.lakshman.maven.geometry.library.Triangle;
import com.lakshman.maven.geometryutils.GeometryUtils;
import com.lakshman.maven.threedimensionalshapes.Cube;


public class App {
    public static void main(String[] args) {

        System.out.println("This is geometry applications which is using the other module's functionality");

        int redius = 5;

        Circle circle = new Circle(redius);
        System.out.println("The area of the circle for the redius " + redius + "  is " + circle.getArea());
        System.out.println("The perimeter of the circle for the redius " + redius + "  is " + circle.getPerimeter());
        System.out.println(circle); // after gradation the toString is ovverriden it should reflect here

        double a = 100, b = 200, c = 300;

        Triangle triangle = new Triangle(a, b, c);

        System.out.println("The area of the Triangle  is " + triangle.getArea());
        System.out.println("The perimeter of the Triangle  is " + triangle.getPerimeter());

        double w = 20, h = 20;
        Rectangle rectangle = new Rectangle(w, h);

        System.out.println("The area of the Rectangle  is " + rectangle.getArea());
        System.out.println("The perimeter of the Rectangle  is " + rectangle.getPerimeter());


        double area = circle.getArea();

        System.out.println("Circle area in m²: " + GeometryUtils.cmSquaredToMSquared(area));
        System.out.println("Is circle larger than rectangle? " +
                GeometryUtils.isLarger(circle.getArea(), rectangle.getArea()));


//        after upgradation this method is added  ( 1.1.0-SNAPSHOT )
        System.out.println("Describe area type  is " + GeometryUtils.describeArea(area));


//        Three Dimentional module functionality check
        Cube cube = new Cube(3);
        System.out.printf("Cube's Volume: %.2f%n", cube.getVolume());

    }
}