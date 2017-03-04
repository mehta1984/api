package com.swagger.fun;

public enum TriangleTypeEnum {
	Isosceles,
    Equilateral,
    Scalene,
    Error;

    public static TriangleTypeEnum ofPotentialTriangle(PotentialTriangle triangle) {
    	if(triangle.isAnySideTooShort()){
    		return Error;
    	}
               
        if(triangle.violatesTriangleInequality()){
        	return Error;
        }

        if (triangle.areSidesEqual()) {
            return Equilateral;
        }
        if (triangle.areAtLeastTwoSidesEqual()) {
            return Isosceles;
        }
        return Scalene;
    }

}
