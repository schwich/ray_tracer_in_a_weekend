package com.schwich;

public class Vector3 {
    public double x;
    public double y;
    public double z;

    public static Vector3 add(Vector3 u, Vector3 v) {
        return new Vector3(u.x + v.x, u.y + v.y, u.z + v.z);
    }

    public static Vector3 subtract(Vector3 u, Vector3 v) {
        return new Vector3(u.x - v.x, u.y - v.y, u.z - v.z);
    }

    public static Vector3 multiply(Vector3 u, Vector3 v) {
        return new Vector3(u.x * v.x, u.y * v.y, u.z * v.z);
    }

    public static Vector3 multiply(double scalar, Vector3 v) {
        return new Vector3(scalar * v.x, scalar * v.y, scalar * v.z);
    }

    public static Vector3 divide(double scalar, Vector3 v) {
        return new Vector3(v.x / scalar, v.y / scalar, v.z / scalar);
    }

    public static double dotProduct(Vector3 u, Vector3 v) {
        return (u.x * v.x) + (u.y * v.y) + (u.z * v.z);
    }

    public static Vector3 crossProduct(Vector3 u, Vector3 v) {
        return new Vector3(u.y * v.z - u.z * v.y,
                u.z * v.x - u.x * v.z,
                u.x * v.y - u.y * v.x);
    }

    public static Vector3 unitVector(Vector3 v) {
        return new Vector3(v.x, v.y, v.z).divide(v.length());
    }

    public Vector3() {
        x = 0;
        y = 0;
        z = 0;
    }

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 add(Vector3 other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
        return this;
    }

    public Vector3 negate() {
        x = -x;
        y = -y;
        z = -z;
        return this;
    }

    public Vector3 multiply(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        return this;
    }

    public Vector3 divide(double scalar) {
        this.x /= scalar;
        this.y /= scalar;
        this.z /= scalar;
        return this;
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public double lengthSquared() {
        return Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2);
    }

    public String toStringAsColor() {
        return (int) (255.999 * x) + " " + (int) (255.999 * y) + " " + (int) (255.999 * z);
    }

    @Override
    public String toString() {
        return "Vector3{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public static void main(String[] args) {
        Vector3 v1 = new Vector3(1, 2, 3);
        Vector3 v2 = new Vector3(2, 4, 6);
        v1.add(v2).add(v2);
        System.out.println(v1);
    }
}
