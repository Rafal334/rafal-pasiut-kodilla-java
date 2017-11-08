package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ShapeCollector {
    private ArrayList<Shape> figures;

    public ShapeCollector() {
        figures = new ArrayList<Shape>();
    }

    public int getFiguresNumber(){
        return figures.size();
    }

    public void addFigure(Shape shape){
        if(shape!=null){
            figures.add(shape);
        }
    }
    public boolean removeFigure(Shape shape){
        if(shape==null){
            return false;
        }else{
            return figures.remove(shape);
        }
    }
    public Shape getFigure(int n){
        if(n<0 || n>figures.size()-1){
            return null;
        }else{
            return figures.get(n);
        }
    }
    public String showFigures(){
//        String result="";
//        int i=0;
//
//        for(Shape shape : figures){
//            result+=shape.getShapeName();
//            if(i<figures.size()-1){
//                result+=", ";
//            }
//            i++;
//        }
      //  return result;
        //można skrócić
        return figures.stream().map(Shape::getShapeName).collect(Collectors.joining(", "));
    }
}
