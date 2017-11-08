package com.kodilla.testing.shape;

public class Square implements Shape{

    private Double a;

    public Square(Double a) {
        if(a!=null){
            this.a = a;
        }else{
            this.a = 0.0;
        }
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public Double getField() {
        //Podobnie jak w klasie circle
        return a*a;
    }
}
