package com.kodilla.testing.shape;

public class Triangle implements Shape{

    private Double h;
    private Double a;

    public Triangle(Double h, Double a) {
        if(h!=null){
            this.h = h;
        }else{
            this.h=0.0;
        }
        if(a!=null){
            this.a = a;
        }else{
            this.a=0.0;
        }
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public Double getField() {
        return a*h*0.5;
    }
}
