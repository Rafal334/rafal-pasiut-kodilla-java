package com.kodilla.StudentMarks;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class SchoolDiary
{
    private HashMap<Student,Grades> diary;

    public SchoolDiary(){
        diary = new HashMap<Student,Grades>();
    }

    public void addStudent(Student student){
        if(student != null){
            diary.put(student, new Grades());
        }
    }

    public void addGrade(Student student, String subject, Double grade){
        if(student !=null && subject != null && grade !=null){
            if(!diary.containsKey(student)){
                addStudent(student);
            } else {
                Grades grades = diary.get(student);
                grades.addGrade(subject, grade);
            }
        }
    }

    public Set<Map.Entry<Student,Grades>> getDiary(){
        return diary.entrySet();
    }

    public void printDiary(){
        for(Map.Entry<Student,Grades> entry : diary.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
