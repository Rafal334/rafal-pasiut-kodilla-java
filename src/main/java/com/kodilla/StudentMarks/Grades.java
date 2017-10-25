package com.kodilla.StudentMarks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Grades
{
    private HashMap<String, ArrayList<Double>> grades;

    public Grades() {
        grades = new HashMap<String, ArrayList<Double>>();
    }

    private Double roundToGrade(Double grade){
        grade= (double)Math.round(grade*2)/2;
        grade = grade <= 2.5 ? 2 : grade;
        grade = grade>5 ? 5 : grade;
        return grade;
    }

    public void addGrade(String subject, Double grade){
        if(subject != null && grade != null){
            if(grades.containsKey(subject)){
                ArrayList<Double> gradesFromSubject = grades.get(subject);
                gradesFromSubject.add(roundToGrade(grade));
                grades.put(subject,gradesFromSubject);
            } else {
                ArrayList<Double> gradesFromSubject = new ArrayList<Double>();
                gradesFromSubject.add(roundToGrade(grade));
                grades.put(subject,gradesFromSubject);
            }
        }
    }

    public Double countSubjectMean(String subject){
        if(subject != null){
            ArrayList<Double> subjectGrades = grades.get(subject);

            Double sum = (double)0;
            for(Double grade : subjectGrades){
                sum+=grade;
            }
            return sum/subjectGrades.size();
        } else {
            return (double)-1;
        }
    }

    public Double countMean(){
        double sum=0;

        for(Map.Entry<String,ArrayList<Double>> entry : grades.entrySet()){
            sum+=countSubjectMean(entry.getKey());
        }
        return sum/grades.size();
    }

    @Override
    public String toString(){
        String string = "";
        for(Map.Entry<String, ArrayList<Double>> entry : grades.entrySet()){
            string+= "Przedmiot: " + entry.getKey() + "\nOceny: " + entry.getValue() + ", średnia: " + String.format("%.2f",countSubjectMean(entry.getKey())) + "\n";
        }
        string+="Calkowita srednia ucznia: " + String.format("%.2f",countMean()) + "\n";
        return string;
    }
}
