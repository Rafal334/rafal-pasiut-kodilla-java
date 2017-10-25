package com.kodilla.StudentMarks;

public class Student {
    private String name;
    private String surname;
    private String pesel;

    public Student(String name, String surname, String pesel) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o){
        if(pesel!=null){
            final Student e = (Student) o;
            return pesel.equals(e.pesel);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        if(pesel!=null){
            String yearMonth = pesel.substring(0,3);
            return Integer.parseInt(yearMonth);
        } else {
            return -1;
        }
    }

    @Override
    public String toString(){
        return "Imie: " + name + ", Nazwisko: " + surname+ ", PESEL: " + pesel;
    }
}
