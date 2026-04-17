package com.lakshman.maven.geometryutils;

public class GeometryUtils {

    // Convert cm² to m²
    public static double cmSquaredToMSquared(double cm2) {
        return cm2 / 10000;
    }

    // Convert meters to centimeters
    public static double metersToCm(double meters) {
        return meters * 100;
    }

    // Compare two areas — returns true if area1 > area2
    public static boolean isLarger(double area1, double area2) {
        return area1 > area2;
    }

    // Round to 2 decimal places
    public static double roundToTwo(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

//     added on updagration v1.1.0-SNAPSHOT

    public static String describeArea(double area) {
        if (area < 10) return "Small shape";
        else if (area < 100) return "Medium shape";
        else return "Large shape";
    }

}
