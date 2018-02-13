package com.kodilla.hibernate.manytomany.facade;

public class CompanyDto{

    private String name;

    public CompanyDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
