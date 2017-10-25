package com.kodilla.StudentMarks;
import java.util.*;

public class StudentMarks {
    public static void main(String[] args)
    {
        SchoolDiary diary = new SchoolDiary();

        Student jan = new Student("Jan","Nowak","90011257925");
        Student roman = new Student("Roman","Kowalski","92011857625");
        Student agnieszka = new Student("Agnieszka","Ptak","90031257925");
        Student kasia = new Student("Katarzyna","Kowal","90040957975");
        Student bartek = new Student("Bartlomiej","Burczymucha","90121257025");

        diary.addStudent(jan);
        diary.addStudent(roman);
        diary.addStudent(agnieszka);
        diary.addStudent(kasia);
        diary.addStudent(bartek);

        String[] subjects = {"Matematyka", "Fizyka", "Chemia", "Informatyka"};
        Rnadomizer random = new Rnadomizer();

        for(Map.Entry<Student,Grades> entry : diary.getDiary()){
            for(String subject : subjects){
                for(int i =0;i<=10;i++){
                    entry.getValue().addGrade(subject,random.generate());
                }
            }
        }

        diary.printDiary();
    }
}
