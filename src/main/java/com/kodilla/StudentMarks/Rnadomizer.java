package com.kodilla.StudentMarks;

import java.util.Random;

class Rnadomizer
{
    private Double grade;

    public Double generate(){
        Random randGrade = new Random();
        grade = (randGrade.nextDouble()+1)*2.5;
        grade= (double)Math.round(grade*2)/2;
        grade = grade == 2.5 ? 2 : grade;

        return grade;
    }
}
