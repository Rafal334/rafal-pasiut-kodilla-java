package com.kodilla.hibernate.manytomany.facade;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ManyToManyFacadeTestSuite {

    @Autowired
    ManyToManyFacade facade;

    @Test
    public void testFindCompaniesWithNameLike() {
        //Given
        facade.addCompany(new CompanyDto("ABC International"));
        facade.addCompany(new CompanyDto("Software ABCxx"));
        facade.addCompany(new CompanyDto("Corporate AB"));

        //When
        List<CompanyDto> companiesABC = facade.findCompaniesWithNameLike("ABC");
        List<CompanyDto> companiesAB = facade.findCompaniesWithNameLike("xx");
        List<CompanyDto> emptyCompanies = facade.findCompaniesWithNameLike("test");

        //Then
        Assert.assertEquals(2, companiesABC.size());
        Assert.assertEquals(1, companiesAB.size());
        Assert.assertTrue(emptyCompanies.isEmpty());
    }

    @Test
    public void testFindEmployeesWithNameLike() {
        //Given
        facade.addEmployee(new EmployeeDto("Jan", "Kowalski"));
        facade.addEmployee(new EmployeeDto("Robert", "Nowak"));
        facade.addEmployee(new EmployeeDto("Bogdan", "Kosturkiewicz"));
        facade.addEmployee(new EmployeeDto("Tadeusz", "Nowakowski"));

        //When
        List<EmployeeDto> employeesNowak = facade.findEmployeesWithNameLike("Nowak");
        List<EmployeeDto> employeesSki = facade.findEmployeesWithNameLike("ski");
        List<EmployeeDto> employessTurk = facade.findEmployeesWithNameLike("turk");
        List<EmployeeDto> noEmployees = facade.findEmployeesWithNameLike("test");

        //Then
        Assert.assertEquals(2, employeesNowak.size());
        Assert.assertEquals(2, employeesSki.size());
        Assert.assertEquals(1, employessTurk.size());
        Assert.assertTrue(noEmployees.isEmpty());
    }
}
