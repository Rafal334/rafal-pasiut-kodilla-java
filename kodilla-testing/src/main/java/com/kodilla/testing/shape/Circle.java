package com.kodilla.testing.shape;

public class Circle implements Shape{

    private Double radius;

    public Circle(Double radius) {
        if(radius!=null){
            this.radius = radius;
        }else{
            this.radius=0.0;
        }
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public Double getField() {
        //return Math.PI *radius*radius;
        return Math.PI *Math.pow(radius,2);
    }
}
