package com.kodilla.hibernate.manytomany.facade;

public class EmployeeDto {

    private String firstName;
    private String lastName;

    public EmployeeDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
