package com.swagger.fun;

public class PotentialTriangle {

	private final long a, b, c;

    public PotentialTriangle(int sideA, int sideB, int sideC) {
        a = sideA;
        b = sideB;
        c = sideC;
    }

    public boolean isAnySideTooShort() {
        return a <= 0 || b <= 0 || c <= 0;
    }

    public boolean violatesTriangleInequality() {
        return a >= b + c || b >= a + c || c >= a + b;
    }

    public boolean areSidesEqual() {
        return a == b && b == c;
    }

    public boolean areAtLeastTwoSidesEqual() {
        return a == b || b == c || c == a;
    }
}